
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
@Table(name = "gnl_departman")
@SequenceGenerator(allocationSize = 1,name = "default_id_generator",sequenceName = "seq_departman")
public class Departman  extends EBase{
    String kod;
    Adres adres;
    Kisi yonetici;
    String tanim;

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Embedded
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @JoinColumn(name = "yonetici_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Kisi getYonetici() {
        return yonetici;
    }

    public void setYonetici(Kisi yonetici) {
        this.yonetici = yonetici;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }
    
    
}
