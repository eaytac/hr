package com.vektorel.hrappe.ui;

import com.vektorel.hrappe.entity.Adres;
import com.vektorel.hrappe.entity.Bolum;
import com.vektorel.hrappe.entity.Cinsiyet;
import com.vektorel.hrappe.entity.Cv;
import com.vektorel.hrappe.entity.Fotograf;
import com.vektorel.hrappe.entity.Il;
import com.vektorel.hrappe.entity.Ilce;
import com.vektorel.hrappe.entity.Kisi;
import com.vektorel.hrappe.entity.Okul;
import com.vektorel.hrappe.service.BolumService;
import com.vektorel.hrappe.service.CvService;
import com.vektorel.hrappe.service.IlService;
import com.vektorel.hrappe.service.IlceService;
import com.vektorel.hrappe.service.KisiService;
import com.vektorel.hrappe.service.OkulService;
import com.vektorel.hrappe.util.DefaultComboModel;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Math.toIntExact;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author eaytac
 */
public class frmCvEkle extends javax.swing.JFrame {

    byte[] fotografDosyasi;
    String fotografDosyaAdresi;

    /**
     * Creates new form frmCv
     */
    public frmCvEkle() {
        initComponents();
        setLocationRelativeTo(null);
        comboInit();
        IlAdlariCBDoldur();
        IlceAdlariCBDoldur("1");
        okulAdlariCBDoldur();
        bolumAdlariCBDoldur("101");
    }

    public frmCvEkle(Cv cv) {
        initComponents();
        setLocationRelativeTo(null);
        comboInit();
        IlAdlariCBDoldur();
        okulAdlariCBDoldur();

        txtCvTanimi.setText(cv.getCvTanimi());
        lblId.setText(cv.getId().toString());
        txtAd.setText(cv.getKisi().getAd());
        txtSoyad.setText(cv.getKisi().getSoyad());
        txtEposta.setText(cv.getAdres().getEposta());
        txtTCKimlikNo.setText(cv.getKisi().getTc().toString());
        txtDogumTarihi.setDate(cv.getKisi().getDogumTarihi());

        Cinsiyet c = Cinsiyet.getEnum(cv.getKisi().getCinsiyet().ordinal());
        cmbCinsiyet.setSelectedItem(c);

        txtAdres.setText(cv.getAdres().getAcikAdres());

        cmbIl.setSelectedIndex(toIntExact(cv.getAdres().getIl().getId()) - 1);
        IlceAdlariCBDoldur(null);
        cmbIlce.setSelectedIndex(toIntExact(cv.getAdres().getIlce().getId()) - 1);
        
        int okulKod = toIntExact(cv.getOkul().getKod()) - 1;
        cmbOkul.setSelectedIndex(okulKod);
        bolumAdlariCBDoldur(null);
        cmbBolum.setSelectedIndex(toIntExact(cv.getBolum().getId()) - 1);
        
        Fotograf fotograf = cv.getFotograf();
        byte[] foto = fotograf.getImage();
        ImageIcon image = new ImageIcon(foto);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(lblFotograf.getWidth(), lblFotograf.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        lblFotograf.setIcon(newImage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEposta = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        txtTCKimlikNo = new javax.swing.JTextField();
        txtDogumTarihi = new com.toedter.calendar.JDateChooser();
        cmbCinsiyet = new javax.swing.JComboBox<>();
        txtAdres = new javax.swing.JTextField();
        cmbIl = new javax.swing.JComboBox<>();
        cmbIlce = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblFotograf = new javax.swing.JLabel();
        btnFotografSec = new javax.swing.JButton();
        btnIptal = new javax.swing.JButton();
        btnKaydet = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCvTanimi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbOkul = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbBolum = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ad:");

        jLabel2.setText("Soyad:");

        jLabel3.setText("E-Posta adresi:");

        jLabel4.setText("Adres:");

        jLabel5.setText("T.C. Kimlik No:");

        jLabel6.setText("Doğum Tarihi:");

        jLabel7.setText("Cinsiyet:");

        jLabel8.setText("İl:");

        jLabel9.setText("İlçe:");

        txtDogumTarihi.setDateFormatString("dd.MM.yyyy");

        cmbIl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIlItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CV Bilgileri");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblFotograf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFotografSec.setText("Fotoğraf Seç");
        btnFotografSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotografSecActionPerformed(evt);
            }
        });

        btnIptal.setText("İptal");
        btnIptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIptalActionPerformed(evt);
            }
        });

        btnKaydet.setText("Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel11.setText("Kullanıcı ID:");

        lblId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("CV Tanımı:");

        jLabel13.setText("Mezun Olduğu Okul:");

        cmbOkul.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOkulItemStateChanged(evt);
            }
        });

        jLabel14.setText("Mezun Olduğu Bölüm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoyad, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(cmbBolum, 0, 205, Short.MAX_VALUE)
                            .addComponent(cmbOkul, 0, 205, Short.MAX_VALUE)
                            .addComponent(cmbIlce, 0, 205, Short.MAX_VALUE)
                            .addComponent(cmbIl, 0, 205, Short.MAX_VALUE)
                            .addComponent(txtAdres, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(cmbCinsiyet, 0, 205, Short.MAX_VALUE)
                            .addComponent(txtDogumTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtAd, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtCvTanimi, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIptal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKaydet))
                            .addComponent(txtEposta, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtTCKimlikNo, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFotograf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFotografSec, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCvTanimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtTCKimlikNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtDogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbIl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbIlce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbOkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmbBolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIptal)
                            .addComponent(btnKaydet)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFotograf, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFotografSec)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIptalActionPerformed
        int secim = JOptionPane.showConfirmDialog(rootPane, "Çıkmak istediğinizden emin misiniz? Kaydedilmemiş veriler kaybedilecek!!!", "Çıkış", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (secim == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnIptalActionPerformed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        try {
            CvService cvService = new CvService();
            Cv cv = new Cv();
            Date date = new Date();
            
            Kisi k = new Kisi();
            KisiService ks = new KisiService();
            k.setAd(txtAd.getText());
            k.setSoyad(txtSoyad.getText());
            k.setTc(new Long(txtTCKimlikNo.getText()));
            k.setDogumTarihi(txtDogumTarihi.getDate());
            
            DefaultComboModel secilenCinsiyet = (DefaultComboModel) cmbCinsiyet.getSelectedItem();
            Cinsiyet c = Cinsiyet.getEnum(secilenCinsiyet.getValue().intValue());
            k.setCinsiyet(c);
            ks.save(k);
            cv.setKisi(k);
            
            Adres adres = new Adres();
            adres.setEposta(txtEposta.getText());
            adres.setAcikAdres(txtAdres.getText());
            
            DefaultComboModel secilenIl = (DefaultComboModel) cmbIl.getSelectedItem();
            IlService ilService = new IlService();
            Il il = ilService.getById(secilenIl.getValue());
            adres.setIl(il);
            
            DefaultComboModel secilenIlce = (DefaultComboModel) cmbIlce.getSelectedItem();
            IlceService ilceService = new IlceService();
            Ilce ilce = ilceService.getById(secilenIlce.getValue());
            adres.setIlce(ilce);
            
            cv.setAdres(adres);

            cv.setCvTanimi(txtCvTanimi.getText());
            
            if (cv.getCvEklenmeTarihi() == null) { //Veritabanında iş başvuru tarihi yoksa kaydet
                cv.setCvEklenmeTarihi(date); // Formun kaydedildiği tarih iş başvuru tarihi olarak kabul edilecek!
            }
           
            DefaultComboModel secilenOkul = (DefaultComboModel) cmbOkul.getSelectedItem();
            OkulService okulService = new OkulService();
            Okul okul = okulService.getById(secilenOkul.getValue());
            okul.setId(okul.getId());
            cv.setOkul(okul);
            
            DefaultComboModel secilenBolum = (DefaultComboModel) cmbBolum.getSelectedItem();
            BolumService bolumService = new BolumService();
            Bolum bolum = bolumService.getById(secilenBolum.getValue());
            bolum.setId(bolum.getId());
            cv.setBolum(bolum);

            //Fotoğrafı veritabanına kaydetme aşamaları
            FileInputStream fileInputStream = new FileInputStream(fotografDosyaAdresi);
            fileInputStream.read(fotografDosyasi);
            Path path = Paths.get(fotografDosyaAdresi);
            byte[] data = Files.readAllBytes(path);
            Fotograf fotograf = new Fotograf();
            fotograf.setImage(data);
            cv.setFotograf(fotograf);
            fileInputStream.close();

            //Kaydetme veya güncelleme işlemini yapalım.
            if (lblId.getText().equals("")) {
                cvService.save(cv);
                this.dispose();
            } else {
                cv.setId(new Long(lblId.getText()));
                cvService.update(cv);
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnFotografSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotografSecActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Resim dosyaları", "jpg", "png");
        fileChooser.addChoosableFileFilter(filter);
        int sonuc = fileChooser.showSaveDialog(null);

        if (sonuc == JFileChooser.APPROVE_OPTION) {
            File secilenDosya = fileChooser.getSelectedFile();
            String secilenDosyaAdresi = secilenDosya.getAbsolutePath();
            this.fotografDosyaAdresi = secilenDosyaAdresi;
            this.fotografDosyasi = new byte[(int) secilenDosyaAdresi.length()];
            lblFotograf.setIcon(ResizeImage(secilenDosyaAdresi));
        } else if (sonuc == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Dosya seçilmedi. İşleme devam edebilmek için lütfen bir dosya seçiniz!", "Dosya Seçilmedi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnFotografSecActionPerformed

    private void cmbIlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIlItemStateChanged
        String il = String.valueOf(cmbIl.getSelectedIndex()+1);
        IlceAdlariCBDoldur(il);
    }//GEN-LAST:event_cmbIlItemStateChanged

    private void cmbOkulItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOkulItemStateChanged
        DefaultComboModel secilenOkul = (DefaultComboModel) cmbOkul.getSelectedItem();
        OkulService okulService = new OkulService();
        Okul okul = okulService.getById(secilenOkul.getValue());
        bolumAdlariCBDoldur((okul.getId()).toString());
    }//GEN-LAST:event_cmbOkulItemStateChanged

    public ImageIcon ResizeImage(String fotografKonumu) {
        ImageIcon fotograf = new ImageIcon(fotografKonumu);
        Image img = fotograf.getImage();
        Image newImg = img.getScaledInstance(lblFotograf.getWidth(), lblFotograf.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFotografSec;
    private javax.swing.JButton btnIptal;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cmbBolum;
    private javax.swing.JComboBox<String> cmbCinsiyet;
    private javax.swing.JComboBox<String> cmbIl;
    private javax.swing.JComboBox<String> cmbIlce;
    private javax.swing.JComboBox<String> cmbOkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblFotograf;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtCvTanimi;
    private com.toedter.calendar.JDateChooser txtDogumTarihi;
    private javax.swing.JTextField txtEposta;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTCKimlikNo;
    // End of variables declaration//GEN-END:variables

private void comboInit() { 
        DefaultComboModel[] dizi = new DefaultComboModel[3];
        for (int i = 0; i < Cinsiyet.values().length; i++) {
            String label = Cinsiyet.values()[i].getLabel();
            dizi[i] = new DefaultComboModel(new Long(i), label);
        }
        cmbCinsiyet.setModel(new DefaultComboBoxModel(dizi));
    }

List<Il> ilListe = null;

private void IlAdlariCBDoldur() {
        ilListe = new IlService().getAll(null);
        DefaultComboModel[] dizi = new DefaultComboModel[ilListe.size()];
        for (int i = 0; i < ilListe.size(); i++) {
            Il il = ilListe.get(i);
            dizi[i] = new DefaultComboModel(il.getId(), il.getAd());
        }
        cmbIl.setModel(new DefaultComboBoxModel(dizi));
    }

List<Ilce> ilceListe = null;

    private void IlceAdlariCBDoldur(String il) {
        if (il == null){
            ilceListe = new IlceService().getAll(null);
        } else {
            ilceListe = new IlceService().getAll(il);
        }
                
        DefaultComboModel[] dizi = new DefaultComboModel[ilceListe.size()];
        for (int i = 0; i < ilceListe.size(); i++) {
            Ilce ilce = ilceListe.get(i);
            dizi[i] = new DefaultComboModel(ilce.getId(), ilce.getAd());
        }
        cmbIlce.setModel(new DefaultComboBoxModel(dizi));
    }

List<Okul> okulListe = null;

private void okulAdlariCBDoldur() {
        okulListe = new OkulService().getAll(null);
        DefaultComboModel[] dizi = new DefaultComboModel[okulListe.size()];
        for (int i = 0; i < okulListe.size(); i++) {
            Okul okul = okulListe.get(i);
            dizi[i] = new DefaultComboModel(okul.getId(), okul.getAdi());
        }
        cmbOkul.setModel(new DefaultComboBoxModel(dizi));
    }
    
List<Bolum> bolumListe = null;

    private void bolumAdlariCBDoldur(String okul) {
        if (okul == null){
            bolumListe = new BolumService().getAll(null);
        } else {
            bolumListe = new BolumService().getAll(okul);
        }
                
        DefaultComboModel[] dizi = new DefaultComboModel[bolumListe.size()];
        for (int i = 0; i < bolumListe.size(); i++) {
            Bolum bolum = bolumListe.get(i);
            dizi[i] = new DefaultComboModel(bolum.getId(), bolum.getTanim());
        }
        cmbBolum.setModel(new DefaultComboBoxModel(dizi));
    }
}
