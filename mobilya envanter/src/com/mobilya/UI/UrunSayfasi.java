package com.mobilya.UI;

import com.mobilya.DAO.UrunDAO;
import com.mobilya.DAO.TedarikciDAO;
import com.mobilya.Model.UrunModel;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.SQLException;

public class UrunSayfasi extends javax.swing.JPanel {

    UrunModel urunModel;
    String kullaniciadi = null;
    String tedarikci = null;
    int kullaniciID;
    Dashboard dashboard;
    
    
    public UrunSayfasi() {
    }
    
    public UrunSayfasi(String kullaniciadi, Dashboard dashboard){
        initComponents();
        this.kullaniciadi = kullaniciadi;
        this.dashboard = dashboard;
        loadComboBox();
        loadDataSet();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        entryPanel = new javax.swing.JPanel();
        tedarikciCombo = new javax.swing.JComboBox<>();
        addSuppButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kodText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        miktarText = new javax.swing.JTextField();
        musteriText = new javax.swing.JTextField();
        satisText = new javax.swing.JTextField();
        markaText = new javax.swing.JTextField();
        ekleButton = new javax.swing.JButton();
        duzenleButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        temizleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        urunTable = new javax.swing.JTable();
        yenileButton = new javax.swing.JButton();
        aramaText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("ÜRÜNLER");

        entryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürün Detaylarını Girin"));

        tedarikciCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bir tedarikçi seçin" }));
        tedarikciCombo.setToolTipText("Bir tedarikçi seçin");

        addSuppButton.setText("Yeni Tedarikçi eklemek için tıklayın");
        addSuppButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSuppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSuppButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Ürün Kodu:");

        jLabel3.setText("Ürün Adı:");

        jLabel4.setText("Tarih:");

        jLabel5.setText("Miktar:");

        jLabel6.setText("Maliyet fiyatı:");

        jLabel7.setText("Satış fiyatı:");

        jLabel8.setText("Marka:");

        jDateChooser1.setForeground(new java.awt.Color(102, 102, 102));

        ekleButton.setText("Ekle");
        ekleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });

        duzenleButton.setText("Düzenle");
        duzenleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        duzenleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzenleButtonActionPerformed(evt);
            }
        });

        silButton.setText("Sil");
        silButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        temizleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        temizleButton.setText("TEMİZLE");
        temizleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temizleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout entryPanelLayout = new javax.swing.GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout.setHorizontalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temizleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tedarikciCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSuppButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kodText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markaText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miktarText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(musteriText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(satisText))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(ekleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duzenleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(silButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        entryPanelLayout.setVerticalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tedarikciCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSuppButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miktarText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musteriText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(satisText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markaText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ekleButton)
                    .addComponent(duzenleButton)
                    .addComponent(silButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temizleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        urunTable.setModel(new javax.swing.table.DefaultTableModel(
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
        urunTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urunTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urunTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(urunTable);

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

        jLabel9.setText("Ara:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yenileButton))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yenileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );

        entryPanel.getAccessibleContext().setAccessibleName("Ürün Detaylarını Girin");
    }// </editor-fold>//GEN-END:initComponents

    private void duzenleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzenleButtonActionPerformed
        if (urunTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(null, "Lütfen tablodan ürün seçiniz.");
        else{
            urunModel = new UrunModel();
            if (nameText.getText().equals("") || musteriText.getText().equals("")
                    || satisText.getText().equals("") || markaText.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Lütfen gerekli tüm ayrıntıları girin.");
            else {
                urunModel.setUrunKodu(kodText.getText());
                urunModel.setUrunAdi(nameText.getText());
                urunModel.setTarih(jDateChooser1.getDateFormatString());
                urunModel.setMiktar(Integer.parseInt(miktarText.getText()));
                urunModel.setMaliyetFiyati(Double.parseDouble(musteriText.getText()));
                urunModel.setSatisFiyati(Double.parseDouble(satisText.getText()));
                urunModel.setMarka(markaText.getText());
                urunModel.setKullaniciID(kullaniciID);

                new UrunDAO().urunDuzenleDAO(urunModel);
            }
            loadDataSet();
        }
    }//GEN-LAST:event_duzenleButtonActionPerformed

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
        urunModel = new UrunModel();
        if (nameText.getText().equals("") || musteriText.getText().equals("")
                || satisText.getText().equals("") || markaText.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Lütfen gerekli tüm ayrıntıları girin.");
        else {
            urunModel.setUrunKodu(kodText.getText());
            urunModel.setUrunAdi(nameText.getText());
            urunModel.setTarih(jDateChooser1.getDateFormatString());
            urunModel.setMiktar(Integer.parseInt(miktarText.getText()));
            urunModel.setMaliyetFiyati(Double.parseDouble(musteriText.getText()));
            urunModel.setSatisFiyati(Double.parseDouble(satisText.getText()));
            urunModel.setMarka(markaText.getText());
            urunModel.setKullaniciID(kullaniciID);

            new UrunDAO().urunEkleDAO(urunModel);
            loadDataSet();
        }
    }//GEN-LAST:event_ekleButtonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        if (urunTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(null, "Lütfen tablodan ürün seçiniz.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Bu ürünü silmek istediğinizden emin misiniz?",
                    "Onayla",
                    JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION) {
                new UrunDAO().urunSilDAO(
                        (String) urunTable.getValueAt(
                                urunTable.getSelectedRow(),0));
                loadDataSet();
            }
        }
    }//GEN-LAST:event_silButtonActionPerformed

    private void temizleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleButtonActionPerformed
        kodText.setText("");
        nameText.setText("");
        jDateChooser1.setDate(null);
        miktarText.setText("");
        musteriText.setText("");
        satisText.setText("");
        markaText.setText("");
        aramaText.setText("");
    }//GEN-LAST:event_temizleButtonActionPerformed

    //static String productName;
    private void urunTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urunTableMouseClicked
        int row = urunTable.getSelectedRow();
        int col = urunTable.getColumnCount();

        Object[] data = new Object[col];
        for (int i=0; i<col; i++)
            data[i] = urunTable.getValueAt(row, i);

         kodText.setText(data[0].toString());
        nameText.setText(data[1].toString());
        musteriText.setText(data[2].toString());
        satisText.setText(data[3].toString());
        markaText.setText(data[4].toString());


    }//GEN-LAST:event_urunTableMouseClicked

    private void addSuppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSuppButtonActionPerformed
        dashboard.tedarikciSayfasiEkle();
    }//GEN-LAST:event_addSuppButtonActionPerformed

    private void yenileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileButtonActionPerformed
        loadDataSet();
        loadComboBox();
        temizleButtonActionPerformed(evt);  
    }//GEN-LAST:event_yenileButtonActionPerformed

    private void aramaTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaTextKeyReleased
        loadSearchData(aramaText.getText());
    }//GEN-LAST:event_aramaTextKeyReleased

    // Tedarikci adlarını içeren birleşik giriş kutusunu güncelleme yöntemi
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
            urunTable.setModel(productDAO.buildTableModel(productDAO.getSorguSonucu()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Method to display search result in table
    public void loadSearchData(String text) {
        try {
            UrunDAO productDAO = new UrunDAO();
            urunTable.setModel(productDAO.buildTableModel(productDAO.getUrunArama(text)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSuppButton;
    private javax.swing.JTextField aramaText;
    private javax.swing.JButton duzenleButton;
    private javax.swing.JButton ekleButton;
    private javax.swing.JPanel entryPanel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kodText;
    private javax.swing.JTextField markaText;
    private javax.swing.JTextField miktarText;
    private javax.swing.JTextField musteriText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField satisText;
    private javax.swing.JButton silButton;
    private javax.swing.JComboBox<String> tedarikciCombo;
    private javax.swing.JButton temizleButton;
    private javax.swing.JTable urunTable;
    private javax.swing.JButton yenileButton;
    // End of variables declaration//GEN-END:variables
}
