package com.mobilya.DAO;

import com.mobilya.Model.MusteriModel;
import com.mobilya.Database.BaglantiAyar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class MusteriDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;

    public MusteriDAO() {
        try {
            conn = new BaglantiAyar().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Yeni müşteri ekleme metodu
    public void musteriEkleDAO(MusteriModel musteriModel) {
        try {
            String query = "SELECT * FROM musteriler WHERE adsoyad='"
                    +musteriModel.getAdSoyad()
                    + "' AND lokasyon='"
                    +musteriModel.getLocation()
                    + "' AND telefon='"
                    +musteriModel.getTelefon()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                JOptionPane.showMessageDialog(null, "Müşteri zaten var.");
            else
                ekleMetodu(musteriModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ekleMetodu(MusteriModel musteriModel) {
        try {
            String query = "INSERT INTO musteriler VALUES(null,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, musteriModel.getMusteriKodu());
            prepStatement.setString(2, musteriModel.getAdSoyad());
            prepStatement.setString(3, musteriModel.getLocation());
            prepStatement.setString(4, musteriModel.getTelefon());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Yeni müşteri eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Mevcut müşteri ayrıntılarını düzenleme metodu
    public  void musteriDuzenleDAO(MusteriModel musteriModel) {
        try {
            String query = "UPDATE musteriler SET adsoyad=?,lokasyon=?,telefon=? WHERE musterikodu=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, musteriModel.getAdSoyad());
            prepStatement.setString(2, musteriModel.getLocation());
            prepStatement.setString(3, musteriModel.getTelefon());
            prepStatement.setString(4, musteriModel.getMusteriKodu());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Müşteri bilgileri güncellendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mevcut müşteriyi silme metodu
    public void musteriSilDAO(String musteriKodu) {
        try {
            String query = "DELETE FROM musteriler WHERE musterikodu='" +musteriKodu+ "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Müşteri kaldırıldı.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Görüntülenecek veri kümesini alma metodu
    public ResultSet getSorguSonucu() {
        try {
            String query = "SELECT musterikodu,adsoyad,lokasyon,telefon FROM musteriler";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Arama verilerini alma metodu
    public ResultSet getMusteriArama(String text) {
        try {
            String query = "SELECT musterikodu,adsoyad,lokasyon,telefon FROM musteriler " +
                    "WHERE musterikodu LIKE '%"+text+"%' OR adsoyad LIKE '%"+text+"%' OR " +
                    "lokasyon LIKE '%"+text+"%' OR telefon LIKE '%"+text+"%'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getMusteriAdi(String musteriKodu) {
        try {
            String query = "SELECT * FROM musteriler WHERE musterikodu='" +musteriKodu+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUrunAdi(String urunKodu) {
        try {
            String query = "SELECT urunadi,mevcutstok.miktar FROM urunler " +
                    "INNER JOIN mevcutstok ON urunler.urunkodu=mevcutstok.urunkodu " +
                    "WHERE mevcutstok.urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to display data set in tabular form
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
