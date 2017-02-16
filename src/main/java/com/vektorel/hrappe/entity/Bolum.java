
package com.vektorel.hrappe.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author eaytac
 */
@Entity
@Table(name = "gnl_bolum")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_bolum")
public class Bolum extends EBase {

    Long kod;
    String tanim;
    Kisi bolumBsk;
    Adres adres;
    Okul okul;

    public Long getKod() {
        return kod;
    }

    public void setKod(Long kod) {
        this.kod = kod;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @JoinColumn(name = "kisi_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    public Kisi getBolumBsk() {
        return bolumBsk;
    }

    public void setBolumBsk(Kisi bolumBsk) {
        this.bolumBsk = bolumBsk;
    }

    @Embedded
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    
    @JoinColumn(name = "okul_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    public Okul getOkul() {
        return okul;
    }

    public void setOkul(Okul okul) {
        this.okul = okul;
    }
}