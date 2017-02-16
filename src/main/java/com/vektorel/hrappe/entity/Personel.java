
package com.vektorel.hrappe.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "gnl_personel")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_personel")
public class Personel extends EBase {

    String sicilNo;
    Departman departman;
    Gorev gorev;
    Cv cv;
    Date baslamaTarihi;
    Kisi kisi;
    BigDecimal maas;

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    @JoinColumn(name = "departman_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    @JoinColumn(name = "gorev_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Gorev getGorev() {
        return gorev;
    }

    public void setGorev(Gorev gorev) {
        this.gorev = gorev;
    }

    @JoinColumn(name = "cv_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Date getBaslamaTarihi() {
        return baslamaTarihi;
    }

    public void setBaslamaTarihi(Date baslamaTarihi) {
        this.baslamaTarihi = baslamaTarihi;
    }

    @JoinColumn(name = "kisi_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Column(precision = 16, scale = 2, name = "maas")
    public BigDecimal getMaas() {
        return maas;
    }

    public void setMaas(BigDecimal maas) {
        this.maas = maas;
    }

}
