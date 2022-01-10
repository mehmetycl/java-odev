package com.mobilya.UI;

import com.mobilya.DAO.UrunDAO;
import com.mobilya.DAO.TedarikciDAO;
import com.mobilya.Model.UrunModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SatinAlmaSayfasi extends javax.swing.JPanel {

    UrunModel urunModel;
    String kullaniciadi = null;
    String tedarikci = null;
    Dashboard dashboard;
    int miktar;
    String urunKodu = null;

    public SatinAlmaSayfasi(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
        loadComboBox();
        loadDataSet();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tedarikciCombo = new javax.swing.JComboBox<>();
        tedarikciEkleButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kodText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        miktarText = new javax.swing.JTextField();
        maliyetText = new javax.swing.JTextField();
        satisText = new javax.swing.JTextField();
        markaText = new javax.swing.JTextField();
        satinalmaButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        temizleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        satinalmaTable = new javax.swing.JTable();
        yenileButton = new javax.swing.JButton();
        aramaText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("SATIN ALMA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürün satın al"));

        jLabel2.setText("Tedarikçi:");

        tedarikciCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tedarikciEkleButton.setText("Yeni bir Tedarikçi eklemek için tıklayın");
        tedarikciEkleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedarikciEkleButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Urun Kodu:");

        jLabel4.setText("Urun Adı:");

        jLabel5.setText("Tarih:");

        jLabel6.setText("Miktar:");

        jLabel7.setText("Maliyet fiyatı:");

        jLabel8.setText("Satış fiyatı:");
        jLabel8.setToolTipText("");

        jLabel9.setText("Marka:");

        kodText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kodTextKeyReleased(evt);
            }
        });

        satinalmaButton.setText("Satın alma");
        satinalmaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satinalmaButtonActionPerformed(evt);
            }
        });

        silButton.setText("Sil");
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        temizleButton.setText("TEMİZLE");
        temizleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tedarikciCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tedarikciEkleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kodText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(miktarText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maliyetText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(satisText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(markaText))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(satinalmaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(silButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addComponent(temizleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tedarikciCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tedarikciEkleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miktarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maliyetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satisText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satinalmaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temizleButton))
        );

        satinalmaTable.setModel(new javax.swing.table.DefaultTableModel(
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
        satinalmaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                satinalmaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(satinalmaTable);

        yenileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        yenileButton.setText("YENİLE");
        yenileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenileButtonActionPerformed(evt);
            }
        });

        aramaText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaTextKeyReleased(evt);
            }
        });

        jLabel10.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yenileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yenileButton)
                    .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yenileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileButtonActionPerformed
        loadDataSet();
        loadComboBox();
        temizleButtonActionPerformed(evt); 
    }//GEN-LAST:event_yenileButtonActionPerformed

    private void tedarikciEkleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedarikciEkleButtonActionPerformed
        dashboard.tedarikciSayfasiEkle();
    }//GEN-LAST:event_tedarikciEkleButtonActionPerformed

    private void satinalmaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satinalmaButtonActionPerformed
        urunModel = new UrunModel();
        if (kodText.getText().equals("") || jDateChooser1.getDate()==null
                || miktarText.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Lütfen gerekli tüm ayrıntıları girin.");
        else {
            urunModel.setTedarikciKodu(new UrunDAO().getTedarikciKodu(tedarikciCombo.getSelectedItem().toString()));
            urunModel.setUrunKodu(kodText.getText());
            try {
                ResultSet resultSet = new UrunDAO().getUrunAdi(kodText.getText());
                if (resultSet.next()) {
                    urunModel.setTarih(jDateChooser1.getDate().toString());
                    urunModel.setMiktar(Integer.parseInt(miktarText.getText()));
                    Double costPrice = Double.parseDouble(maliyetText.getText());
                    Double totalCost = costPrice * Integer.parseInt(miktarText.getText());
                    urunModel.setToplamTutar(totalCost);

                    new UrunDAO().satinalmaEkleDAO(urunModel);
                    loadDataSet();
                } else
                    JOptionPane.showMessageDialog(null, "Bu yeni bir ürün gibi görünüyor" +
                            " henüz eklenmedi.\nLütfen devam etmeden önce bu ürünÜ \"Ürünler\" bölümüne ekleyin.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_satinalmaButtonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        if (satinalmaTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(null, "Lütfen tablodan bir işlem seçin.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Bu satın alma işlemini silmek istediğinizden emin misiniz?",
                    "Onayla",
                    JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION) {
                new UrunDAO().satinalmabilgisiSilDAO((int) satinalmaTable.getValueAt(satinalmaTable.getSelectedRow(),0));
                new UrunDAO().satinalmaStokunuDuzenle(urunKodu, miktar);
                loadDataSet();
            }
        }
    }//GEN-LAST:event_silButtonActionPerformed

    private void temizleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleButtonActionPerformed
        kodText.setText("");
        nameText.setText("");
        jDateChooser1.setDate(null);
        miktarText.setText("");
        maliyetText.setText("");
        satisText.setText("");
        markaText.setText("");
        aramaText.setText("");
    }//GEN-LAST:event_temizleButtonActionPerformed

    private void aramaTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaTextKeyReleased
        loadSearchData(aramaText.getText());
    }//GEN-LAST:event_aramaTextKeyReleased

    private void satinalmaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satinalmaTableMouseClicked
        int row = satinalmaTable.getSelectedRow();
        int col = satinalmaTable.getColumnCount();

        Object[] data = new Object[col];
        for (int i=0; i<col; i++)
            data[i] = satinalmaTable.getValueAt(row, i);
        
        miktar = Integer.parseInt(data[3].toString());
        urunKodu = data[1].toString();
    }//GEN-LAST:event_satinalmaTableMouseClicked

    private void kodTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodTextKeyReleased
        try {
            ResultSet resultSet = new UrunDAO().getKoddanUrun(kodText.getText());
            if (resultSet.next()) {
                nameText.setText(resultSet.getString("urunadi"));
                maliyetText.setText(String.valueOf(resultSet.getDouble("maliyetfiyati")));
                satisText.setText(String.valueOf(resultSet.getDouble("satisfiyati")));
                markaText.setText(resultSet.getString("marka"));
            } else {
                nameText.setText("");
                maliyetText.setText("");
                satisText.setText("");
                markaText.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_kodTextKeyReleased

    // Tedarikçi adlarını içeren birleşik giriş kutusunu yükleme ve güncelleme yöntemi
    public void loadComboBox() {
        try {
            TedarikciDAO supplierDAO = new TedarikciDAO();
            tedarikciCombo.setModel(supplierDAO.setComboItems(supplierDAO.getSorguSonucu()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tabloya veri yükleme yöntemi
    public void loadDataSet() {
        try {
            UrunDAO productDAO = new UrunDAO();
            satinalmaTable.setModel(productDAO.buildTableModel(productDAO.getSatinAlmaBilgisi()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Arama sonucunu tabloda gösterme yöntemi
    public void loadSearchData(String text) {
        try {
            UrunDAO productDAO = new UrunDAO();
            satinalmaTable.setModel(productDAO.buildTableModel(productDAO.getSatinAlmaBilgisiArama(text)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaText;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kodText;
    private javax.swing.JTextField maliyetText;
    private javax.swing.JTextField markaText;
    private javax.swing.JTextField miktarText;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton satinalmaButton;
    private javax.swing.JTable satinalmaTable;
    private javax.swing.JTextField satisText;
    private javax.swing.JButton silButton;
    private javax.swing.JComboBox<String> tedarikciCombo;
    private javax.swing.JButton tedarikciEkleButton;
    private javax.swing.JButton temizleButton;
    private javax.swing.JButton yenileButton;
    // End of variables declaration//GEN-END:variables
}
