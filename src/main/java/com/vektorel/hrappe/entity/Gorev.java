
package com.vektorel.hrappe.entity;

import java.math.BigDecimal;
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
@Table(name = "gnl_gorev_is")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_gorev_is")
public class Gorev extends EBase {

    String baslik;
    Departman departman;
    String gorevTanimi;
    String aciklama;
    BigDecimal maas;

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    @JoinColumn(name = "departman_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    public String getGorevTanimi() {
        return gorevTanimi;
    }

    public void setGorevTanimi(String gorevTanimi) {
        this.gorevTanimi = gorevTanimi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Column(precision = 16, scale = 2, name = "maas")
    public BigDecimal getMaas() {
        return maas;
    }

    public void setMaas(BigDecimal maas) {
        this.maas = maas;
    }

}
