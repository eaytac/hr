
package com.vektorel.hrappe.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eaytac
 */
@Entity
@Table(name = "gnl_is_basvuru")
@SequenceGenerator(allocationSize = 1,name = "default_id_generator",sequenceName = "seq_is_basvuru")
public class IsBasvuru extends EBase {
    //İş başvuru görev classından gelecek.
    //Bu class kullanıcının hangi iş pozisyonlarına, hangi tarihte, hangi cv ile başvurduğunu tutacak.
    
    private Date isBavuruTarihi;
    private Date sonBasvuruTarihi;
    private Cv basvuruYapilanCv;
    private String basvuruYapilanPozisyonAdi;
    private String basvuruYapilanPozisyonAciklamasi;

    @Temporal(TemporalType.DATE)
    @Column(name = "is_basvuru_tarihi")
    public Date getIsBavuruTarihi() {
        return isBavuruTarihi;
    }

    public void setIsBavuruTarihi(Date isBavuruTarihi) {
        this.isBavuruTarihi = isBavuruTarihi;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "son_basvuru_tarihi")
    public Date getSonBasvuruTarihi() {
        return sonBasvuruTarihi;
    }

    public void setSonBasvuruTarihi(Date sonBasvuruTarihi) {
        this.sonBasvuruTarihi = sonBasvuruTarihi;
    }

    @JoinColumn(name = "cv_id")
    @ManyToOne (fetch = FetchType.LAZY)
    public Cv getBasvuruYapilanCv() {
        return basvuruYapilanCv;
    }

    public void setBasvuruYapilanCv(Cv basvuruYapilanCv) {
        this.basvuruYapilanCv = basvuruYapilanCv;
    }

    @Column(name = "bsvyp_poz_adi", length = 150)
    public String getBasvuruYapilanPozisyonAdi() {
        return basvuruYapilanPozisyonAdi;
    }

    public void setBasvuruYapilanPozisyonAdi(String basvuruYapilanPozisyonAdi) {
        this.basvuruYapilanPozisyonAdi = basvuruYapilanPozisyonAdi;
    }

    @Column(name = "bsvyp_poz_acikl", length = 250)
    public String getBasvuruYapilanPozisyonAciklamasi() {
        return basvuruYapilanPozisyonAciklamasi;
    }

    public void setBasvuruYapilanPozisyonAciklamasi(String basvuruYapilanPozisyonAciklamasi) {
        this.basvuruYapilanPozisyonAciklamasi = basvuruYapilanPozisyonAciklamasi;
    }
    
    
}
