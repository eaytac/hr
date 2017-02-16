
package com.vektorel.hrappe.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eaytac
 */
@Entity
@Table(name = "gnl_cv")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_cv")
public class Cv extends EBase {

    private String cvTanimi;
    private Kisi kisi;
    private Adres adres;
    private Date cvEklenmeTarihi;
    private Fotograf fotograf;
    private Okul okul;
    private Bolum bolum;

    @Column(name = "cv_tanimi", length = 200)
    public String getCvTanimi() {
        return cvTanimi;
    }

    public void setCvTanimi(String cvTanimi) {
        this.cvTanimi = cvTanimi;
    }

    @JoinColumn(name = "kisi_id")
    @OneToOne(fetch = FetchType.LAZY)
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Embedded
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
   
    @Temporal(TemporalType.DATE)
    @Column(name = "cv_eklenme_tarihi")
    public Date getCvEklenmeTarihi() {
        return cvEklenmeTarihi;
    }

    public void setCvEklenmeTarihi(Date cvEklenmeTarihi) {
        this.cvEklenmeTarihi = cvEklenmeTarihi;
    }

    @JoinColumn(name = "fotograf_id")
    @OneToOne(cascade = CascadeType.ALL)
    public Fotograf getFotograf() {
        return fotograf;
    }

    public void setFotograf(Fotograf fotograf) {
        this.fotograf = fotograf;
    }

    @JoinColumn(name = "okul_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Okul getOkul() {
        return okul;
    }

    public void setOkul(Okul okul) {
        this.okul = okul;
    }

    @JoinColumn(name = "bolum_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

}
