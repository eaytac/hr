package com.vektorel.hrappe;

import com.vektorel.hrappe.ui.frmCvEkle;
import com.vektorel.hrappe.ui.frmCvListesi;
import com.vektorel.hrappe.ui.frmLogin;

/**
 *
 * @author eaytac
 */
public class App {
    public static void main(String[] args) {
        
        System.out.println("Application is start...");
//        frmLogin login=new frmLogin(null, true);
//        login.setLocationRelativeTo(null);
//        login.show();

//        frmCvEkle cvEkle = new frmCvEkle();
//        cvEkle.setVisible(true);
        
        frmCvListesi cvListesi = new frmCvListesi();
        cvListesi.setVisible(true);
    }
}
