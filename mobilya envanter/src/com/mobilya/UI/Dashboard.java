package com.mobilya.UI;

import com.mobilya.DAO.KullaniciDAO;
import com.mobilya.Model.KullaniciModel;
import com.mobilya.Database.BaglantiAyar;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class Dashboard extends javax.swing.JFrame {

    CardLayout layout;
    String kullaniciTuruSec;
    String kullaniciadi;
    String adSoyad;
    KullaniciModel kullaniciModel;
    LocalDateTime outTime;

    public Dashboard(String kullaniciadi, String kullaniciTuru, KullaniciModel kullaniciModel) {
        initComponents();

        navPanel.setVisible(false);
        menuPanel.setVisible(true);
        layout = new CardLayout();
        kullaniciTuruSec = kullaniciTuru;
        this.kullaniciadi = kullaniciadi;
        this.kullaniciModel = kullaniciModel;
        if("EMPLOYEE".equalsIgnoreCase(kullaniciTuru))
            notForEmployee();
        currentUserSession();

        // Panel Layout set to Card Layout to allow switching between different sections
        displayPanel.setLayout(layout);
        displayPanel.add("AnaSayfa", new AnaSayfa(kullaniciadi));
        displayPanel.add("Kullanıcılar", new KullanicilarSayfasi());
        displayPanel.add("Müşteriler", new MusteriSayfasi());
        displayPanel.add("Ürünler", new UrunSayfasi(kullaniciadi, this));
        displayPanel.add("Tedarikçiler", new TedarikcilerSayfasi());
        displayPanel.add("Mevcut Stok", new MevcutStokSayfasi(kullaniciadi));
        displayPanel.add("Satış", new SatisSayfasi(kullaniciadi, this));
        displayPanel.add("Satın Alma", new SatinAlmaSayfasi(this));
        displayPanel.add("Logs", new KullaniciLogsSayfasi());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                outTime = LocalDateTime.now();
                kullaniciModel.setOutTime(String.valueOf(outTime));
                kullaniciModel.setKullaniciAdi(kullaniciadi);
                new KullaniciDAO().kullaniciGirisiEkle(kullaniciModel);
                super.windowClosing(e);
            }
        });

        setTitle("Envanter Yönetimi");
        setVisible(true);
    }

    // Methods to display different sections in the mainframe
    public void anasayfaEkle(){
        layout.show(displayPanel, "AnaSayfa");
    }
    public void kullaniciSayfasiEkle() {
        layout.show(displayPanel, "Kullanıcılar");
    }
    public void musteriSayfasiEkle() {
        layout.show(displayPanel, "Müşteriler");
    }
    public void urunSayfasiEkle() {
        layout.show(displayPanel, "Ürünler");
    }
    public void tedarikciSayfasiEkle() {
        layout.show(displayPanel, "Tedarikçiler");
    }
    public void stokSayfasiEkle() {
        layout.show(displayPanel, "Mevcut Stok");
    }
    public void satisSayfasiEkle() {
        layout.show(displayPanel, "Satış");
    }
    public void satinAlmaSayfasiEkle() {
        layout.show(displayPanel, "Satın Alma");
    }
    public void logsSayfasiEkle() {
        layout.show(displayPanel, "Logs");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        navPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        urunButton = new javax.swing.JButton();
        stokButton = new javax.swing.JButton();
        musteriButton = new javax.swing.JButton();
        tedarikciButton = new javax.swing.JButton();
        satisButton = new javax.swing.JButton();
        kullanicilarButton = new javax.swing.JButton();
        satinalmaButton = new javax.swing.JButton();
        logsButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        kullaniciPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        cikisButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Manager");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        menuPanel.setPreferredSize(new java.awt.Dimension(120, 26));

        menuButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mobilya/UI/Icons/menu_icon_150667.png"))); // NOI18N
        menuButton.setText("MENÜ");
        menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mobilya/UI/Icons/homepages_home_house_icon_150665.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        urunButton.setText("Ürünler");
        urunButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        urunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunButtonActionPerformed(evt);
            }
        });

        stokButton.setText("Mevcut Stok");
        stokButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stokButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokButtonActionPerformed(evt);
            }
        });

        musteriButton.setText("Müşteriler");
        musteriButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        musteriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriButtonActionPerformed(evt);
            }
        });

        tedarikciButton.setText("Tedarikçiler");
        tedarikciButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tedarikciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedarikciButtonActionPerformed(evt);
            }
        });

        satisButton.setText("Satış");
        satisButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        satisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisButtonActionPerformed(evt);
            }
        });

        kullanicilarButton.setText("Kullanıcılar");
        kullanicilarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kullanicilarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanicilarButtonActionPerformed(evt);
            }
        });

        satinalmaButton.setText("Satın alma");
        satinalmaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        satinalmaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satinalmaButtonActionPerformed(evt);
            }
        });

        logsButton.setText("User Logs");
        logsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stokButton, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(musteriButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tedarikciButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kullanicilarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satinalmaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(urunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stokButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(musteriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tedarikciButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(satisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(satinalmaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kullanicilarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        displayPanel.setLayout(new java.awt.CardLayout());

        nameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mobilya/UI/Icons/user_icon_150670.png"))); // NOI18N
        nameLabel.setText("Kullanıcı: ");
        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cikisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mobilya/UI/Icons/log-out_icon-icons.com_50106.png"))); // NOI18N
        cikisButton.setText("Çıkış Yap");
        cikisButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cikisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kullaniciPanelLayout = new javax.swing.GroupLayout(kullaniciPanel);
        kullaniciPanel.setLayout(kullaniciPanelLayout);
        kullaniciPanelLayout.setHorizontalGroup(
            kullaniciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullaniciPanelLayout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cikisButton))
        );
        kullaniciPanelLayout.setVerticalGroup(
            kullaniciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullaniciPanelLayout.createSequentialGroup()
                .addGroup(kullaniciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kullaniciPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cikisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kullaniciPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kullaniciPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cikisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisButtonActionPerformed
        int opt = JOptionPane.showConfirmDialog(
                null,
                "<html>Çıkış yapmak istediğinizden emin misiniz?<br>Tekrar giriş yapmanız gerekecek.<html>",
                "Onayla",
                JOptionPane.YES_NO_OPTION);
        if (opt==JOptionPane.YES_OPTION){
            outTime = LocalDateTime.now();
            kullaniciModel.setOutTime(String.valueOf(outTime));
            kullaniciModel.setKullaniciAdi(kullaniciadi);
            new KullaniciDAO().kullaniciGirisiEkle(kullaniciModel);
            dispose();
            Giris logPage = new Giris();
            logPage.setVisible(true);
        }
    }//GEN-LAST:event_cikisButtonActionPerformed

    private void kullanicilarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanicilarButtonActionPerformed
        kullaniciSayfasiEkle();
    }//GEN-LAST:event_kullanicilarButtonActionPerformed

    private void satisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisButtonActionPerformed
        satisSayfasiEkle();
    }//GEN-LAST:event_satisButtonActionPerformed

    private void tedarikciButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedarikciButtonActionPerformed
        tedarikciSayfasiEkle();
    }//GEN-LAST:event_tedarikciButtonActionPerformed

    private void musteriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriButtonActionPerformed
        musteriSayfasiEkle();
    }//GEN-LAST:event_musteriButtonActionPerformed

    private void stokButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokButtonActionPerformed
        stokSayfasiEkle();
    }//GEN-LAST:event_stokButtonActionPerformed

    private void urunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunButtonActionPerformed
        urunSayfasiEkle();
    }//GEN-LAST:event_urunButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed

        anasayfaEkle();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        navPanel.setVisible(!navPanel.isVisible());
    }//GEN-LAST:event_menuButtonActionPerformed

    private void satinalmaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satinalmaButtonActionPerformed
        satinAlmaSayfasiEkle();
    }//GEN-LAST:event_satinalmaButtonActionPerformed

    private void logsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logsButtonActionPerformed
        logsSayfasiEkle();
    }//GEN-LAST:event_logsButtonActionPerformed

    public void currentUserSession() {
        KullaniciModel userDTO = new KullaniciModel();
        new KullaniciDAO().getAdSoyad(userDTO, kullaniciadi);
        nameLabel.setText("User: " + userDTO.getAdSoyad() + " ("+kullaniciTuruSec+")");
    }

    // Yalnızca YÖNETİCİ türü kullanıcının 'Kullanıcılar' ve 'Kullanıcı Günlükleri'ni görüntülemesine ve değiştirmesine izin verir
    public void notForEmployee(){
        navPanel.remove(kullanicilarButton);
        navPanel.remove(logsButton);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cikisButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel kullaniciPanel;
    private javax.swing.JButton kullanicilarButton;
    private javax.swing.JButton logsButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton menuButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton musteriButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton satinalmaButton;
    private javax.swing.JButton satisButton;
    private javax.swing.JButton stokButton;
    private javax.swing.JButton tedarikciButton;
    private javax.swing.JButton urunButton;
    // End of variables declaration//GEN-END:variables
}
