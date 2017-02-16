
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
@Table(name = "gnl_okul")
@SequenceGenerator(allocationSize = 1,name = "default_id_generator",sequenceName = "seq_okul")
public class Okul extends EBase{
    Long kod;
    String adi;
    Adres adres;

    public Long getKod() {
        return kod;
    }

    public void setKod(Long kod) {
        this.kod = kod;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Embedded
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
