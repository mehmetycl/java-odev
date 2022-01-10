package com.mobilya.DAO;

import com.mobilya.Model.TedarikciModel;
import com.mobilya.Database.BaglantiAyar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class TedarikciDAO {

    Connection conn = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;

    public TedarikciDAO() {
        try {
            conn = new BaglantiAyar().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Yeni tedarikçi ekleme metodu
    public void tedarikciEkleDAO(TedarikciModel tedarikciModel) {
        try {
            String query = "SELECT * FROM tedarikciler WHERE tedarikciadi='"
                    +tedarikciModel.getTedarikciAdi()
                    + "' AND lokasyon='"
                    +tedarikciModel.getLokasyon()
                    + "' AND telefon='"
                    +tedarikciModel.getTelefon()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                JOptionPane.showMessageDialog(null, "Bu tedarikçi zaten var.");
            else
                ekleMetodu(tedarikciModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ekleMetodu(TedarikciModel tedarikciModel) {
        try {
            String query = "INSERT INTO tedarikciler VALUES(null,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, tedarikciModel.getTedarikciKodu());
            prepStatement.setString(2, tedarikciModel.getTedarikciAdi());
            prepStatement.setString(3, tedarikciModel.getLokasyon());
            prepStatement.setString(4, tedarikciModel.getTelefon());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Yeni tedarikçi başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mevcut tedarikçi ayrıntılarını düzenleme metodu
    public void tedarikciDuzenleDAO(TedarikciModel tedarikciModel) {
        try {
            String query = "UPDATE tedarikciler SET tedarikciadi=?,lokasyon=?,telefon=? WHERE tedarikcikodu=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, tedarikciModel.getTedarikciAdi());
            prepStatement.setString(2, tedarikciModel.getLokasyon());
            prepStatement.setString(3, tedarikciModel.getTelefon());
            prepStatement.setString(4, tedarikciModel.getTedarikciKodu());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tedarikçi ayrıntıları güncellendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mevcut tedarikçiyi silme metodu
    public void tedarikciSilDAO(String tedarikciKodu) {
        try {
            String query = "DELETE FROM tedarikciler WHERE tedarikcikodu='" +tedarikciKodu+ "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Tedarikçi kaldırıldı.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tedarikçi veri seti alma metodu
    public ResultSet getSorguSonucu() {
        try {
            String query = "SELECT tedarikcikodu, tedarikciadi, lokasyon, telefon FROM tedarikciler";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Arama methodu
    public ResultSet getAramaSonucu(String searchText) {
        try {
            String query = "SELECT tedarikcikodu, tedarikciadi, lokasyon, telefon FROM tedarikciler " +
                    "WHERE tedarikcikodu LIKE '%"+searchText+"%' OR lokasyon LIKE '%"+searchText+"%' " +
                    "OR tedarikciadi LIKE '%"+searchText+"%' OR telefon LIKE '%"+searchText+"%'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to set/update supplier combo box
    public DefaultComboBoxModel<String> setComboItems(ResultSet resultSet) throws SQLException {
        Vector<String> suppNames = new Vector<>();
        while (resultSet.next()){
            suppNames.add(resultSet.getString("tedarikciadi"));
        }
        return new DefaultComboBoxModel<>(suppNames);
    }

    // Method to display retrieved data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col=1; col <= colCount; col++){
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int col=1; col<=colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
