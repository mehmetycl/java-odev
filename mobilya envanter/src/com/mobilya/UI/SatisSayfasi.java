package com.mobilya.UI;

import com.mobilya.DAO.MusteriDAO;
import com.mobilya.DAO.UrunDAO;
import com.mobilya.Model.UrunModel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SatisSayfasi extends javax.swing.JPanel {

    String kullaniciadi;
    Dashboard dashboard;
    int miktar;
    String urunKodu;

    
    public SatisSayfasi(String username, Dashboard dashboard) {
        initComponents();
        this.kullaniciadi = username;
        this.dashboard = dashboard;
        musteriAdiLabel.setVisible(false);
        urunAdiLabel.setVisible(false);
        loadDataSet();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        satislPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        musteriKoduText = new javax.swing.JTextField();
        urunKoduText = new javax.swing.JTextField();
        fiyatText = new javax.swing.JTextField();
        miktarText = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        satisButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        temizleButton = new javax.swing.JButton();
        musteriekleButton = new javax.swing.JButton();
        musteriAdiLabel = new javax.swing.JLabel();
        urunAdiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        satisTable = new javax.swing.JTable();
        aramaText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("SATIŞ");

        satislPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürün Sat"));

        jLabel2.setText("Müşteri Kodu:");

        jLabel3.setText("Urun Kodu:");

        jLabel4.setText("Tarih:");

        jLabel5.setText("Satış fiyatı:");

        jLabel6.setText("Miktar:");

        musteriKoduText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                musteriKoduTextKeyReleased(evt);
            }
        });

        urunKoduText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                urunKoduTextKeyReleased(evt);
            }
        });

        satisButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        satisButton.setText("ÜRÜN SAT");
        satisButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        satisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisButtonActionPerformed(evt);
            }
        });

        silButton.setText("Sil");
        silButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        temizleButton.setText("Temizle");
        temizleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temizleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleButtonActionPerformed(evt);
            }
        });

        musteriekleButton.setText("Yeni Müşteri eklemek için tıklayın");
        musteriekleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        musteriekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriekleButtonActionPerformed(evt);
            }
        });

        musteriAdiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musteriAdiLabel.setLabelFor(musteriKoduText);

        urunAdiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        urunAdiLabel.setLabelFor(urunKoduText);

        javax.swing.GroupLayout satislPanelLayout = new javax.swing.GroupLayout(satislPanel);
        satislPanel.setLayout(satislPanelLayout);
        satislPanelLayout.setHorizontalGroup(
            satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(satislPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(urunAdiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musteriAdiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musteriekleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(musteriKoduText))
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urunKoduText))
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(temizleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miktarText))
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fiyatText))
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        satislPanelLayout.setVerticalGroup(
            satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(satislPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(satislPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(musteriKoduText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musteriAdiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(musteriekleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urunKoduText, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(urunAdiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiyatText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miktarText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(satislPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(silButton)
                    .addComponent(temizleButton))
                .addContainerGap())
        );

        satisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        satisTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                satisTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(satisTable);

        aramaText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaTextKeyReleased(evt);
            }
        });

        jLabel7.setText("Ara:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(satislPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(satislPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        if (satisTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz tablodan bir giriş seçin.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    this,
                    "Bu satışı veritabanından silmek istediğinizden emin misiniz?",
                    "Onayla",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                new UrunDAO().satisbilgisiSilDAO(Integer.parseInt(
                        satisTable.getValueAt(satisTable.getSelectedRow(),0).toString()));
                new UrunDAO().satilanStokuDuzenle(satisTable.getValueAt(satisTable.getSelectedRow(),1).toString(), miktar);
                loadDataSet();
            }
        }
    }//GEN-LAST:event_silButtonActionPerformed

    private void temizleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleButtonActionPerformed
        musteriKoduText.setText("");
        musteriAdiLabel.setText("");
        musteriAdiLabel.setVisible(false);
        urunKoduText.setText("");
        urunAdiLabel.setText("");
        urunAdiLabel.setVisible(false);
        jDateChooser1.setDate(null);
        fiyatText.setText("");
        miktarText.setText("");
        loadDataSet();
    }//GEN-LAST:event_temizleButtonActionPerformed

    private void musteriekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriekleButtonActionPerformed
        dashboard.musteriSayfasiEkle();
    }//GEN-LAST:event_musteriekleButtonActionPerformed

    private void satisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisButtonActionPerformed
        if (musteriKoduText.getText().equals("") || urunKoduText.getText().equals("")
                || jDateChooser1.getDate()==null || miktarText.getText().equals("") || fiyatText.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Lütfen gerekli tüm alanları doldurun.");
        else {
            try {
                ResultSet resultSet = new MusteriDAO().getMusteriAdi(musteriKoduText.getText());
                if (resultSet.next()) {
                    UrunModel urunModel = new UrunModel();
                    urunModel.setMusteriKodu(musteriKoduText.getText());
                    urunModel.setTarih(jDateChooser1.getDate().toString());
                    urunModel.setUrunKodu(urunKoduText.getText());
                    Double sellPrice = Double.parseDouble(fiyatText.getText());
                    Double toplamgelir = sellPrice * Integer.parseInt(miktarText.getText());
                    urunModel.setToplamGelir(toplamgelir);
                    urunModel.setMiktar(Integer.parseInt(miktarText.getText()));
                    new UrunDAO().urunSatisDAO(urunModel, kullaniciadi);
                    loadDataSet();
                } else
                    JOptionPane.showMessageDialog(this, "Bu müşteri mevcut değil.\n" +
                            "Yeni müşteri ekleyin veya geçerli bir müşteri kodu kullanın.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_satisButtonActionPerformed

    private void satisTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satisTableMouseClicked
        int row = satisTable.getSelectedRow();
        int col = satisTable.getColumnCount();
        Object[] data = new Object[col];
        for (int i=0; i<col; i++)
            data[i] = satisTable.getValueAt(row, i);
        miktar = Integer.parseInt(data[3].toString());
        urunKodu = data[1].toString();
    }//GEN-LAST:event_satisTableMouseClicked

    private void musteriKoduTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_musteriKoduTextKeyReleased
        try {
            ResultSet resultSet = new MusteriDAO().getMusteriAdi(musteriKoduText.getText());
            if (resultSet.next())
                musteriAdiLabel.setText("Adı: "
                        +resultSet.getString("adsoyad")
                        + " | Lokasyon: "
                        +resultSet.getString("lokasyon"));
            else
                musteriAdiLabel.setText("||   Müşteri veritabanında mevcut değil.   ||");
            musteriAdiLabel.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_musteriKoduTextKeyReleased

    private void urunKoduTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urunKoduTextKeyReleased
        try {
            ResultSet resultSet = new MusteriDAO().getUrunAdi(urunKoduText.getText());
            if (resultSet.next()) {
                urunAdiLabel.setText("Adı: "
                        + resultSet.getString("urunadi")
                        + " | Mevcut Miktarı: "
                        + resultSet.getString("miktar"));
                Double sellPrice = new UrunDAO().getUrunSatis(urunKoduText.getText());
                fiyatText.setText(sellPrice.toString());
            } else
                urunAdiLabel.setText("||   Ürün Envanterde yok.  ||");
            urunAdiLabel.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_urunKoduTextKeyReleased

    private void aramaTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaTextKeyReleased
        loadSearchData(aramaText.getText());
    }//GEN-LAST:event_aramaTextKeyReleased

    // Tabloya veri yükleme yöntemi
    public void loadDataSet() {
        try {
            UrunDAO productDAO = new UrunDAO();
            satisTable.setModel(productDAO.buildTableModel(productDAO.getSatisBilgisi()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Arama sonucunu tabloda gösterme yöntemi
    public void loadSearchData(String text) {
        try {
            UrunDAO productDAO = new UrunDAO();
            satisTable.setModel(productDAO.buildTableModel(productDAO.getSatisArama(text)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaText;
    private javax.swing.JTextField fiyatText;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField miktarText;
    private javax.swing.JLabel musteriAdiLabel;
    private javax.swing.JTextField musteriKoduText;
    private javax.swing.JButton musteriekleButton;
    private javax.swing.JButton satisButton;
    private javax.swing.JTable satisTable;
    private javax.swing.JPanel satislPanel;
    private javax.swing.JButton silButton;
    private javax.swing.JButton temizleButton;
    private javax.swing.JLabel urunAdiLabel;
    private javax.swing.JTextField urunKoduText;
    // End of variables declaration//GEN-END:variables
}
