
package com.vektorel.hrappe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author eaytac
 */
@Entity
@Table(name = "gnl_kullanici")
@SequenceGenerator(allocationSize = 1,name = "default_id_generator",sequenceName = "seq_kullanici")
public class Kullanici extends EBase{
    private String username;
    private String pass;
    private String email;
    private String adSoyad;
    private KullaniciTip kullaniciTip;

    public Kullanici() {
    }

    public Kullanici(Long id,String username, String pass, String email, String adSoyad,KullaniciTip kullaniciTip) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.adSoyad = adSoyad;
        this.setId(id);
        this.kullaniciTip=kullaniciTip;
    }
    
    
    @Column(name = "uname",length = 100,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "pwd",length = 100)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Column(name = "email",length = 150)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ad_soyad",length = 200)
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }   

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "kullanici_tip")
    public KullaniciTip getKullaniciTip() {
        return kullaniciTip;
    }

    public void setKullaniciTip(KullaniciTip kullaniciTip) {
        this.kullaniciTip = kullaniciTip;
    }
    
}
