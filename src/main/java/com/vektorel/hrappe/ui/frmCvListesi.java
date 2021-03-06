
package com.vektorel.hrappe.ui;

import com.vektorel.hrappe.entity.Cv;
import com.vektorel.hrappe.entity.Kullanici;
import com.vektorel.hrappe.service.CvService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author eaytac
 */
public class frmCvListesi extends javax.swing.JFrame {

    Kullanici kullanici;
    CvService cvService = new CvService();
    /**
     * Creates new form frmCvListesi
     */
        
    public frmCvListesi() {
        initComponents();
        setLocationRelativeTo(null);
        //pnlCvListesi.setVisible(false);
        cvTabloDoldur(null);

    }

    public frmCvListesi(Kullanici kullanici) {
        initComponents();
        setLocationRelativeTo(null);
        pnlCvListesi.setVisible(false);
        this.kullanici = kullanici;
        lblAktifKullanici.setText("Aktif Kullanıcı: " + kullanici.getAdSoyad());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAktifKullanici = new javax.swing.JLabel();
        pnlCvListesi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCvListesi = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCvIslemleri = new javax.swing.JMenu();
        mnuCvListesi = new javax.swing.JMenuItem();
        mnuCvEkle = new javax.swing.JMenuItem();
        mnuCvSil = new javax.swing.JMenuItem();
        mnuCvGuncelle = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAktifKullanici.setText("Aktif Kullanıcı: ");

        tblCvListesi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCvListesi);

        javax.swing.GroupLayout pnlCvListesiLayout = new javax.swing.GroupLayout(pnlCvListesi);
        pnlCvListesi.setLayout(pnlCvListesiLayout);
        pnlCvListesiLayout.setHorizontalGroup(
            pnlCvListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        pnlCvListesiLayout.setVerticalGroup(
            pnlCvListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCvListesiLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mnuCvIslemleri.setText("CV İşlemleri");

        mnuCvListesi.setText("Cv Listesi");
        mnuCvListesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCvListesiActionPerformed(evt);
            }
        });
        mnuCvIslemleri.add(mnuCvListesi);

        mnuCvEkle.setText("CV Ekle");
        mnuCvEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCvEkleActionPerformed(evt);
            }
        });
        mnuCvIslemleri.add(mnuCvEkle);

        mnuCvSil.setText("CV Sil");
        mnuCvSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCvSilActionPerformed(evt);
            }
        });
        mnuCvIslemleri.add(mnuCvSil);

        mnuCvGuncelle.setText("CV Güncelle");
        mnuCvGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCvGuncelleActionPerformed(evt);
            }
        });
        mnuCvIslemleri.add(mnuCvGuncelle);

        jMenuBar1.add(mnuCvIslemleri);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAktifKullanici)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlCvListesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCvListesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAktifKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCvListesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCvListesiActionPerformed
        cvTabloDoldur(null);
    }//GEN-LAST:event_mnuCvListesiActionPerformed

    private void mnuCvEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCvEkleActionPerformed
        frmCvEkle cv = new frmCvEkle();
        cv.setVisible(true);
        cvTabloDoldur(null);
    }//GEN-LAST:event_mnuCvEkleActionPerformed

    private void mnuCvSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCvSilActionPerformed
        if (tblCvListesi.getSelectedRowCount()> 1){
            JOptionPane.showMessageDialog(rootPane, "Lütfen sadece bir adet kayıt seçiniz!", "Fazla Kayıt Seçildi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int seciliKayit = tblCvListesi.getSelectedRow();
        if (seciliKayit > -1) {
            int secim = JOptionPane.showConfirmDialog(rootPane, "Seçili kaydı silmek istediğinizden emin misiniz?", "Dikkat", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (secim == 0) {
                String value = tblCvListesi.getValueAt(seciliKayit, 0).toString();
                Cv cv = cvService.getById(new Long(value));
                cvService.delete(cv);
                cvTabloDoldur(null);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen silmek istediğiniz kaydı tablodan seçiniz!", "Kayıt Seçilmedi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_mnuCvSilActionPerformed

    private void mnuCvGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCvGuncelleActionPerformed
        if (tblCvListesi.getSelectedRowCount()> 1){
            JOptionPane.showMessageDialog(rootPane, "Lütfen sadece bir adet kayıt seçiniz!", "Fazla Kayıt Seçildi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int seciliKayit = tblCvListesi.getSelectedRow();
        if (seciliKayit > -1) {
            String value = tblCvListesi.getValueAt(seciliKayit, 0).toString();
            Cv cv = cvService.getById(new Long(value));
            frmCvEkle guncelle = new frmCvEkle (cv);
            guncelle.setVisible(true);
            cvTabloDoldur(null);
        }
    }//GEN-LAST:event_mnuCvGuncelleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAktifKullanici;
    private javax.swing.JMenuItem mnuCvEkle;
    private javax.swing.JMenuItem mnuCvGuncelle;
    private javax.swing.JMenu mnuCvIslemleri;
    private javax.swing.JMenuItem mnuCvListesi;
    private javax.swing.JMenuItem mnuCvSil;
    private javax.swing.JPanel pnlCvListesi;
    private javax.swing.JTable tblCvListesi;
    // End of variables declaration//GEN-END:variables

    private void cvTabloDoldur(String query) {
        //pnlCvListesi.setVisible(true);

        List<Cv> cvListesi = cvService.getAll(query);
        String[][] data = new String[cvListesi.size()][3];

        for (int i = 0; i < cvListesi.size(); i++) {
            data[i][0] = cvListesi.get(i).getId().toString();
            data[i][1] = cvListesi.get(i).getCvTanimi();
            data[i][2] = cvListesi.get(i).getCvEklenmeTarihi().toString();
        }

        tblCvListesi.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "No", "CV Tanımı", "CV Eklenme Tarihi"
                }
        ));
    }

}
