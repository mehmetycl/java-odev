package com.mobilya.DAO;

import com.mobilya.Model.KullaniciModel;
import com.mobilya.Database.BaglantiAyar;
import com.mobilya.UI.KullanicilarSayfasi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class KullaniciDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // Constructor method
    public KullaniciDAO() {
        try {
            conn = new BaglantiAyar().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // Yeni kullanıcı ekleme metodu
    public void kullaniciEkleDAO(KullaniciModel kullaniciModel, String kullaniciTuru) {
        try {
            String query = "SELECT * FROM kullanicilar WHERE adsoyad='"
                    +kullaniciModel.getAdSoyad()
                    +"' AND telefon='"
                    +kullaniciModel.getTelefon()
                    +"' AND kullanicituru='"
                    +kullaniciModel.getKullaniciTuru()
                    +"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                JOptionPane.showMessageDialog(null, "Kullanıcı zaten var");
            else
                ekleMetodu(kullaniciModel, kullaniciTuru);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void ekleMetodu(KullaniciModel kullaniciModel, String kullaniciTuru) {
        try {

            String resQuery = "SELECT * FROM kullanicilar";
            resultSet = statement.executeQuery(resQuery);

            String query = "INSERT INTO kullanicilar (adsoyad,telefon,kulaniciadi,parola,kullanicituru) " +
                    "VALUES(?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, kullaniciModel.getAdSoyad());
            prepStatement.setString(3, kullaniciModel.getTelefon());
            prepStatement.setString(4, kullaniciModel.getKullaniciAdi());
            prepStatement.setString(5, kullaniciModel.getParola());
            prepStatement.setString(6, kullaniciModel.getKullaniciTuru());
            prepStatement.executeUpdate();

            if("ADMINISTRATOR".equals(kullaniciTuru))
                JOptionPane.showMessageDialog(null, "Yeni yönetici eklendi.");
            else JOptionPane.showMessageDialog(null, "Yeni çalışan eklendi.");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Mevcut kullanıcıyı düzenleme metodu
    public void kullaniciDuzenleDAO(KullaniciModel kullaniciModel) {

        try {
            String query = "UPDATE kullanicilar SET adsoyad=?,telefon=?,kullanicituru=? WHERE kullaniciadi=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, kullaniciModel.getAdSoyad());
            prepStatement.setString(3, kullaniciModel.getTelefon());
            prepStatement.setString(4, kullaniciModel.getKullaniciTuru());
            prepStatement.setString(5, kullaniciModel.getKullaniciAdi());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Mevcut kullanıcıyı silme metodu
    public void kullaniciSilDAO(String kullaniciAdi) {
        try {
            String query = "DELETE FROM kullanicilar WHERE kullaniciadi=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, kullaniciAdi);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kullanıcı Silindi.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        new KullanicilarSayfasi().loadDataSet();
    }

    // Tabloda görüntülenecek veri kümesini alma metodu
    public ResultSet getSorguSonucu() {
        try {
            String query = "SELECT * FROM kullanicilar";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getKullaniciDAO(String kullaniciAdi) {
        try {
            String query = "SELECT * FROM kullanicilar WHERE kullaniciadi='" +kullaniciAdi+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    public void getAdSoyad(KullaniciModel kullaniciModel, String kullaniciAdi) {
        try {
            String query = "SELECT * FROM kullanicilar WHERE kullaniciadi='" +kullaniciAdi+ "' LIMIT 1";
            resultSet = statement.executeQuery(query);
            String adSoyad = null;
            if(resultSet.next()) adSoyad = resultSet.getString(2);
            kullaniciModel.setAdSoyad(adSoyad);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getKullaniciLogsDAO() {
        try {
            String query = "SELECT kullanicilar.adsoyad,userlogs.username,in_time,out_time FROM userlogs" +
                    " INNER JOIN kullanicilar on userlogs.username=kullanicilar.kullaniciadi";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void kullaniciGirisiEkle(KullaniciModel kullaniciModel) {
        try {
            String query = "INSERT INTO userlogs (username, in_time, out_time) values(?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, kullaniciModel.getKullaniciAdi());
            prepStatement.setString(2, kullaniciModel.getInTime());
            prepStatement.setString(3, kullaniciModel.getOutTime());

            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getParolaDAO(String kullaniciadi, String parola){
        try {
            String query = "SELECT parola FROM kullanicilar WHERE kullaniciadi='"
                    +kullaniciadi
                    + "' AND parola='"
                    +parola
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public void parolaDegistir(String kullaniciadi, String parola) {
        try {
            String query = "UPDATE kullanicilar SET parola=? WHERE kullaniciadi='" +kullaniciadi+ "'";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, parola);
            prepStatement.setString(2, kullaniciadi);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Parola değiştirildi.");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    // Veri kümesini tablo biçiminde görüntüleme metodu
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
