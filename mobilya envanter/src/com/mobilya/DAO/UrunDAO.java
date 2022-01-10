package com.mobilya.DAO;

import com.mobilya.Model.UrunModel;
import com.mobilya.Database.BaglantiAyar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

// Ürünler, Satın Alma, Stok ve Satış
public class UrunDAO {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    PreparedStatement prepStatement2 = null;
    Statement statement = null;
    Statement statement2 = null;
    ResultSet resultSet = null;

    public UrunDAO() {
        try {
            conn = new BaglantiAyar().getConn();
            statement = conn.createStatement();
            statement2 = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getTedarikciBilgisi() {
        try {
            String query = "SELECT * FROM tedarikciler";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getMusteriBilgisi() {
        try {
            String query = "SELECT * FROM musteriler";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUrunStok() {
        try {
            String query = "SELECT * FROM mevcutstok";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUrunBilgisi() {
        try {
            String query = "SELECT * FROM urunler";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public Double getUrunMaliyeti(String urunKodu) {
        Double costPrice = null;
        try {
            String query = "SELECT maliyetfiyati FROM urunler WHERE urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                costPrice = resultSet.getDouble("maliyetfiyati");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return costPrice;
    }

    public Double getUrunSatis(String urunKodu) {
        Double sellPrice = null;
        try {
            String query = "SELECT satisfiyati FROM urunler WHERE urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                sellPrice = resultSet.getDouble("satisfiyati");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sellPrice;
    }

    String tedarikciKodu;
    public String getTedarikciKodu(String tedarikciAdi) {
        try {
            String query = "SELECT tedarikcikodu FROM tedarikciler WHERE tedarikciadi='" +tedarikciAdi+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tedarikciKodu = resultSet.getString("tedarikcikodu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tedarikciKodu;
    }

    String urunKodu;
    public String getUrunKodu(String urunAdi) {
        try {
            String query = "SELECT urunkodu FROM urunler WHERE urunadi='" +urunAdi+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tedarikciKodu = resultSet.getString("urunkodu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urunKodu;
    }

    String musteriKodu;
    public String getCustCode(String musteriAdi) {
        try {
            String query = "SELECT musterikodu FROM musteriler WHERE adsoyad='" +musteriAdi+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tedarikciKodu = resultSet.getString("musterikodu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musteriKodu;
    }

    // Envanterde stok olup olmadığını kontrol etme metodu
    boolean flag = false;
    public boolean stokKontrol(String urunKodu) {
        try {
            String query = "SELECT * FROM mevcutstok WHERE urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Yeni bir ürün ekleme metodu
    public void urunEkleDAO(UrunModel urunModel) {
        try {
            String query = "SELECT * FROM urunler WHERE urunadi='"
                    + urunModel.getUrunAdi()
                    + "' AND maliyetfiyati='"
                    + urunModel.getMaliyetFiyati()
                    + "' AND satisfiyati='"
                    + urunModel.getSatisFiyati()
                    + "' AND marka='"
                    + urunModel.getMarka()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                JOptionPane.showMessageDialog(null, "Ürün zaten eklendi.");
            else
                ekleMetodu(urunModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ekleMetodu(UrunModel urunModel) {
        try {
            String query = "INSERT INTO urunler VALUES(null,?,?,?,?,?)";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, urunModel.getUrunKodu());
            prepStatement.setString(2, urunModel.getUrunAdi());
            prepStatement.setDouble(3, urunModel.getMaliyetFiyati());
            prepStatement.setDouble(4, urunModel.getSatisFiyati());
            prepStatement.setString(5, urunModel.getMarka());

            String query2 = "INSERT INTO mevcutstok VALUES(?,?)";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setString(1, urunModel.getUrunKodu());
            prepStatement2.setInt(2, urunModel.getMiktar());

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ürün eklendi ve satışa hazır.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Yeni bir satın alma işlemi ekleme metodu
    public void satinalmaEkleDAO(UrunModel urunModel) {
        try {
            String query = "INSERT INTO satinalmabilgisi VALUES(null,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, urunModel.getTedarikciKodu());
            prepStatement.setString(2, urunModel.getUrunKodu());
            prepStatement.setString(3, urunModel.getTarih());
            prepStatement.setInt(4, urunModel.getMiktar());
            prepStatement.setDouble(5, urunModel.getToplamTutar());

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Satın alma günlüğü eklendi.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String urunKodu = urunModel.getUrunKodu();
        if(stokKontrol(urunKodu)) {
            try {
                String query = "UPDATE mevcutstok SET miktar=miktar+? WHERE urunkodu=?";
                prepStatement = conn.prepareStatement(query);
                prepStatement.setInt(1, urunModel.getMiktar());
                prepStatement.setString(2, urunKodu);

                prepStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if (!stokKontrol(urunKodu)) {
            try {
                String query = "INSERT INTO mevcutstok VALUES(?,?)";
                prepStatement = (PreparedStatement) conn.prepareStatement(query);
                prepStatement.setString(1, urunModel.getUrunKodu());
                prepStatement.setInt(2, urunModel.getMiktar());

                prepStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        stoksil();
    }

    // Mevcut ürün ayrıntılarını güncelleme metodu
    public void urunDuzenleDAO(UrunModel urunModel) {
        try {
            String query = "UPDATE urunler SET urunadi=?,maliyetfiyati=?,satisfiyati=?,marka=? WHERE urunkodu=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, urunModel.getUrunAdi());
            prepStatement.setDouble(2, urunModel.getMaliyetFiyati());
            prepStatement.setDouble(3, urunModel.getSatisFiyati());
            prepStatement.setString(4, urunModel.getMarka());
            prepStatement.setString(5, urunModel.getUrunKodu());

            String query2 = "UPDATE mevcutstok SET miktar=? WHERE urunkodu=?";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setInt(1, urunModel.getMiktar());
            prepStatement2.setString(2, urunModel.getUrunKodu());

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ürün ayrıntıları güncellendi.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Yapılan herhangi bir işlem üzerine Envanterdeki stokların güncellenmesine yönelik metod
    public void satinalmaStokunuDuzenle(String urunKodu, int miktar) {
        try {
            String query = "SELECT * FROM mevcutstok WHERE urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                String query2 = "UPDATE mevcutstok SET miktar=miktar-? WHERE urunkodu=?";
                prepStatement = conn.prepareStatement(query2);
                prepStatement.setInt(1, miktar);
                prepStatement.setString(2, urunKodu);
                prepStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void satilanStokuDuzenle(String urunKodu, int miktar) {
        try {
            String query = "SELECT * FROM mevcutstok WHERE urunkodu='" +urunKodu+ "'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                String query2 = "UPDATE mevcutstok SET miktar=miktar+? WHERE urunkodu=?";
                prepStatement = conn.prepareStatement(query2);
                prepStatement.setInt(1, miktar);
                prepStatement.setString(2, urunKodu);
                prepStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void stoksil() {
        try {
            String query = "DELETE FROM mevcutstok WHERE urunkodu NOT IN(SELECT urunkodu FROM satinalmabilgisi)";
            String query2 = "DELETE FROM satisbilgisi WHERE urunkodu NOT IN(SELECT urunkodu FROM urunler)";
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Bir ürünü envanterden kalıcı olarak silme metodu
    public void urunSilDAO(String urunkodu) {
        try {
            String query = "DELETE FROM urunler WHERE urunkodu=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, urunkodu);

            String query2 = "DELETE FROM mevcutstok WHERE urunkodu=?";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setString(1, urunkodu);

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ürün kaldırıldı.");
        } catch (SQLException e){
            e.printStackTrace();
        }
        stoksil();
    }

    public void satinalmabilgisiSilDAO(int id){
        try {
            String query = "DELETE FROM satinalmabilgisi WHERE id=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "İşlem kaldırıldı.");
        } catch (SQLException e){
            e.printStackTrace();
        }
        stoksil();
    }

    public void satisbilgisiSilDAO(int id) {
        try {
            String query = "DELETE FROM satisbilgisi WHERE id=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "İşlem kaldırıldı.");
        } catch (SQLException e){
            e.printStackTrace();
        }
        stoksil();
    }

    // Satış işlemleri
    public void urunSatisDAO(UrunModel urunModel, String kullaniciadi) {
        int quantity = 0;
        String prodCode = null;
        try {
            String query = "SELECT * FROM mevcutstok WHERE urunkodu='" +urunModel.getUrunKodu()+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                prodCode = resultSet.getString("urunkodu");
                quantity = resultSet.getInt("miktar");
            }
            if (urunModel.getMiktar()>quantity)
                JOptionPane.showMessageDialog(null, "Bu ürün için yetersiz stok.");
            else if (urunModel.getMiktar()<=0)
                JOptionPane.showMessageDialog(null, "Lütfen geçerli bir miktar girin");
            else {
                String stockQuery = "UPDATE mevcutstok SET miktar=miktar-'"
                        +urunModel.getMiktar()
                        +"' WHERE urunkodu='"
                        +urunModel.getUrunKodu()
                        +"'";
                String salesQuery = "INSERT INTO satisbilgisi(tarih,urunkodu,musterikodu,miktar,gelir,satisyapan)" +
                        "VALUES('"+urunModel.getTarih()+"','"+urunModel.getUrunKodu()+"','"+urunModel.getMusteriKodu()+
                        "','"+urunModel.getMiktar()+"','"+urunModel.getToplamGelir()+"','"+kullaniciadi+"')";
                statement.executeUpdate(stockQuery);
                statement.executeUpdate(salesQuery);
                JOptionPane.showMessageDialog(null, "Ürün satıldı.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Görüntülemek için ürün veri seti alımı
    public ResultSet getSorguSonucu() {
        try {
            String query = "SELECT urunkodu,urunadi,maliyetfiyati,satisfiyati,marka FROM urunler ORDER BY id";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    // Tablo veri seti alımını satın al
    public ResultSet getSatinAlmaBilgisi() {
        try {
            String query = "SELECT satinalmabilgisi.id,satinalmabilgisi.urunkodu,urunadi,miktar,toplamtutar " +
                    "FROM satinalmabilgisi INNER JOIN urunler " +
                    "ON urunler.urunkodu=satinalmabilgisi.urunkodu ORDER BY id;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    // Stok tablosu veri seti alımı
    public ResultSet getMevcutStokBilgisi() {
        try {
            String query = """
                    SELECT mevcutstok.urunkodu,urunler.urunadi,
                    mevcutstok.miktar,urunler.maliyetfiyati,urunler.satisfiyati
                    FROM mevcutstok INNER JOIN urunler
                    ON mevcutstok.urunkodu=urunler.urunkodu;
                    """;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    // Satış tablosu veri seti alımı
    public ResultSet getSatisBilgisi() {
        try {
            String query = """
                    SELECT satisbilgisi.id,satisbilgisi.urunkodu,urunadi,
                    satisbilgisi.miktar,gelir,kullanicilar.adsoyad AS satis_yapan
                    FROM satisbilgisi INNER JOIN urunler
                    ON satisbilgisi.urunkodu=urunler.urunkodu
                    INNER JOIN kullanicilar
                    ON satisbilgisi.satisyapan=kullanicilar.kullaniciadi;
                    """;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    // Ürünler için arama metodu
    public ResultSet getUrunArama(String text) {
        try {
            String query = "SELECT urunkodu,urunadi,maliyetfiyati,satisfiyati,marka FROM urunler " +
                    "WHERE urunkodu LIKE '%"+text+"%' OR urunadi LIKE '%"+text+"%' OR markaLIKE '%"+text+"%'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getKoddanUrun(String text) {
        try {
            String query = "SELECT urunkodu,urunadi,maliyetfiyati,satisfiyati,marka FROM urunler " +
                    "WHERE urunkodu='" +text+ "' LIMIT 1";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Satış için arama metodu
    public ResultSet getSatisArama(String text) {
        try {
            String query = "SELECT satisbilgisi.id,satisbilgisi.urunkodu,urunadi,\n" +
                    "                    satisbilgisi.miktar,gelir,kullanicilar.adsoyad AS satis_yapan\n" +
                    "                    FROM satisbilgisi INNER JOIN urunler\n" +
                    "                    ON satisbilgisi.urunkodu=urunler.urunkodu\n" +
                    "                    INNER JOIN kullanicilar\n" +
                    "                    ON ssatisbilgisi.satisyapan=kullanicilar.kullaniciadi\n" +
                    "                    INNER JOIN musteriler\n" +
                    "                    ON musteriler.musterikodu=satisbilgisi.musterikodu\n" +
                    "WHERE satisbilgisi.urunkodu LIKE '%"+text+"%' OR urunadi LIKE '%"+text+"%' " +
                    "OR kullanicilar.adsoyad LIKE '%"+text+"%' OR musteriler.adsoyad LIKE '%"+text+"%' ORDER BY id;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Satın alma günlükleri için arama metodu
    public ResultSet getSatinAlmaBilgisiArama(String text) {
        try {
            String query = "SELECT id,satinalmabilgisi.urunkodu,urunler.urunadi,miktar,toplamtutar " +
                    "FROM satinalmabilgisi INNER JOIN urunler ON satinalmabilgisi.urunkodu=urunler.urunkodu " +
                    "INNER JOIN tedarikciler ON satinalmabilgisi.tedarikcikodu=tedarikciler.tedarikcikodu" +
                    "WHERE id LIKE '%"+text+"%' OR urunkodu LIKE '%"+text+"%' OR urunadi LIKE '%"+text+"%' " +
                    "OR tedarikciler.tedarikciadi LIKE '%"+text+"%' OR satinalmabilgisi.tedarikcikodu LIKE '%"+text+"%' " +
                    "OR tarih LIKE '%"+text+"%' ORDER BY id";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUrunAdi(String urunkodu) {
        try {
            String query = "SELECT urunadi FROM urunler WHERE urunkodu='" +urunkodu+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public String getTedarikciAdi(int id) {
        String tedarik = null;
        try {
            String query = "SELECT tedarikciadi FROM tedarikciler " +
                    "INNER JOIN satinalmabilgisi ON tedarikciler.tedarikcikodu=satinalmabilgisi.tedarikcikodu " +
                    "WHERE satinalmabilgisi.id='" +id+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                tedarik = resultSet.getString("tedarikciadi");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tedarik;
    }

    public String getMusteriAdi(int id) {
        String musteri = null;
        try {
            String query = "SELECT adsoyad FROM musteriler " +
                    "INNER JOIN satisbilgisi ON musteriler.musterikodu=satisbilgisi.musterikodu " +
                    "WHERE satisbilgisi.id='" +id+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                musteri = resultSet.getString("adsoyad");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return musteri;
    }

    public String getSatinAlmaTarihi(int id) {
        String tarih = null;
        try {
            String query = "SELECT tarih FROM satinalmabilgisi WHERE id='" +id+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                tarih = resultSet.getString("tarih");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tarih;
    }
    public String getSatisTarihi(int id) {
        String date = null;
        try {
            String query = "SELECT tarih FROM satisbilgisi WHERE id='" +id+ "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                date = resultSet.getString("tarih");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return date;
    }


    // Ürünle ilgili veri kümesini tablo biçiminde görüntüleme metodu
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
