
package com.vektorel.hrappe.util;

import com.vektorel.hrappe.entity.Kisi;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author eaytac
 */
public class HibernateTest {
    
    
    public static void main(String[] args) {
       
        /*
        1-
        */
        Date d1=new Date(168, 1,1);
        Date d2=new Date(170, 1,1);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Kisi.class);
        
//        cr.add(Restrictions.between("dogumTarihi", d1, d2));
        
//        cr.add(Restrictions.between("id", 10189L, 10200L));
        
//        Long[] t = new Long[]{10189L, 10200L};
//        cr.add(Restrictions.in("id", t));

//        cr.add(Restrictions.idEq(10189L));
        
//        cr.add(Restrictions.ne("id", 10189L));
        
//        cr.add(Restrictions.or(Restrictions.eq("id", 10189L),
//                Restrictions.eq("id", 10200L),
//                Restrictions.eq("id", 10179L)));
        
//        SQLQuery lQuery = session.createSQLQuery("select * from gnl_kisi");
//        lQuery.addEntity(Kisi.class);
//        List<Kisi> list = lQuery.list();


        List<Kisi> list = cr.list();
        
        for(Kisi kisi : list) {
            System.out.println(kisi.toString());
        }
        
    }
    
}
