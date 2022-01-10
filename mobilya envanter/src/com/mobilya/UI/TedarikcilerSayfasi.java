package com.mobilya.UI;

import com.mobilya.DAO.TedarikciDAO;
import com.mobilya.Model.TedarikciModel;

import javax.swing.*;
import java.sql.SQLException;

public class TedarikcilerSayfasi extends javax.swing.JPanel {

    public TedarikcilerSayfasi() {
        initComponents();
        loadDataSet();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        krediText = new javax.swing.JTextField();
        kodText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        telefonText = new javax.swing.JTextField();
        lokasyonText = new javax.swing.JTextField();
        borcText = new javax.swing.JTextField();
        ekleButton = new javax.swing.JButton();
        silButton = new javax.swing.JButton();
        duzenleButton = new javax.swing.JButton();
        temizleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tedarikciTable = new javax.swing.JTable();
        aramaText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("TEDARİKÇİLER");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tedarikçi Ayrıntılarını Girin"));

        jLabel2.setText("Tedarikçi Kodu:");

        jLabel3.setText("Tedarikçi Adı:");

        jLabel4.setText("Lokasyon:");

        jLabel5.setText("İletişim:");

        jLabel6.setText("Borç miktarı:");

        jLabel7.setText("Kredi miktarı:");

        ekleButton.setText("Ekle");
        ekleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });

        silButton.setText("Sil");
        silButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        silButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButtonActionPerformed(evt);
            }
        });

        duzenleButton.setText("Düzenle");
        duzenleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        duzenleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzenleButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temizleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(krediText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kodText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borcText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefonText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lokasyonText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ekleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duzenleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(silButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lokasyonText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borcText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(krediText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ekleButton)
                    .addComponent(silButton)
                    .addComponent(duzenleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temizleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tedarikciTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tedarikciTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tedarikciTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tedarikciTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tedarikciTable);

        aramaText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaTextKeyReleased(evt);
            }
        });

        jLabel8.setText("Ara:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aramaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tedarikciTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tedarikciTableMouseClicked
        int row = tedarikciTable.getSelectedRow();
        int col = tedarikciTable.getColumnCount();
        Object[] data = new Object[col];

        for (int i=0; i<col; i++)
            data[i] = tedarikciTable.getValueAt(row, i);
        kodText.setText((String) data[0]);
        nameText.setText((String) data[1]);
        lokasyonText.setText((String) data[2]);
        telefonText.setText((String) data[3]);
    }//GEN-LAST:event_tedarikciTableMouseClicked

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
        if (kodText.getText().equals("") || nameText.getText().equals("")
                || lokasyonText.getText().equals("") || telefonText.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Lütfen gerekli tüm ayrıntıları girin.");
        else {
            TedarikciModel supplierDTO = new TedarikciModel();
            supplierDTO.setTedarikciKodu(kodText.getText());
            supplierDTO.setTedarikciAdi(nameText.getText());
            supplierDTO.setLokasyon(lokasyonText.getText());
            supplierDTO.setTelefon(telefonText.getText());
            new TedarikciDAO().tedarikciEkleDAO(supplierDTO);
            loadDataSet();
        }
    }//GEN-LAST:event_ekleButtonActionPerformed

    private void duzenleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzenleButtonActionPerformed
        if (tedarikciTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "Lütfen tablodan düzenlemek için bir giriş seçin.");
        else {
            if (kodText.getText().equals("") || nameText.getText().equals("")
                    || lokasyonText.getText().equals("") || telefonText.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Lütfen gerekli tüm ayrıntıları girin.");
            else {
                TedarikciModel supplierDTO = new TedarikciModel();
                supplierDTO.setTedarikciKodu(kodText.getText());
                supplierDTO.setTedarikciAdi(nameText.getText());
                supplierDTO.setLokasyon(lokasyonText.getText());
                supplierDTO.setTelefon(telefonText.getText());
                new TedarikciDAO().tedarikciDuzenleDAO(supplierDTO);
                loadDataSet();
            }
        }
    }//GEN-LAST:event_duzenleButtonActionPerformed

    private void silButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButtonActionPerformed
        if (tedarikciTable.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "Lütfen tablodan silinecek bir giriş seçin.");
        else {
            int opt = JOptionPane.showConfirmDialog(
                    this,
                    "Bu tedarikçiyi silmek istediğinizden emin misiniz?",
                    "Onayla",
                    JOptionPane.YES_NO_OPTION);
            if (opt==JOptionPane.YES_OPTION) {
                new TedarikciDAO().tedarikciSilDAO(tedarikciTable.getValueAt(tedarikciTable.getSelectedRow(),0).toString());
                loadDataSet();
            }
        }
    }//GEN-LAST:event_silButtonActionPerformed

    private void temizleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleButtonActionPerformed
        kodText.setText("");
        nameText.setText("");
        lokasyonText.setText("");
        telefonText.setText("");
        aramaText.setText("");
    }//GEN-LAST:event_temizleButtonActionPerformed

    private void aramaTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaTextKeyReleased
        String text = aramaText.getText();
        loadSearchData(text);
    }//GEN-LAST:event_aramaTextKeyReleased


    // Tabloya veri yükleme yöntemi
    public void loadDataSet() {
        try {
            TedarikciDAO tedarikciModel = new TedarikciDAO();
            tedarikciTable.setModel(tedarikciModel.buildTableModel(tedarikciModel.getSorguSonucu()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Arama sonucunu tabloda gösterme yöntemi
    public void loadSearchData(String text) {
        try {
            TedarikciDAO supplierDAO = new TedarikciDAO();
            tedarikciTable.setModel(supplierDAO.buildTableModel(supplierDAO.getAramaSonucu(text)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaText;
    private javax.swing.JTextField borcText;
    private javax.swing.JButton duzenleButton;
    private javax.swing.JButton ekleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kodText;
    private javax.swing.JTextField krediText;
    private javax.swing.JTextField lokasyonText;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton silButton;
    private javax.swing.JTable tedarikciTable;
    private javax.swing.JTextField telefonText;
    private javax.swing.JButton temizleButton;
    // End of variables declaration//GEN-END:variables
}
