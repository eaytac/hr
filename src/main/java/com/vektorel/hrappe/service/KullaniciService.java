
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.Kullanici;
import com.vektorel.hrappe.util.HRException;
import com.vektorel.hrappe.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eaytac
 */
public class KullaniciService implements  IBaseService<Kullanici>{
 @Override
    public boolean save(Kullanici entity) throws Exception {
        if(entity.getUsername()==null || entity.getUsername().trim().equals("")){
            throw  new HRException("Kullanıcı Adı Boş Olmamalıdır");
        }
        if(entity.getPass()==null || entity.getPass().trim().equals("")){
            throw  new HRException("Kullanıcı Şifre Boş Olmamalıdır");
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.save(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Kullanici entity) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.update(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Kullanici entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public List<Kullanici> getAll(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        if(query!=null){
//            select * from kullanici where ad_soyad like '%KARA%' or username like '%KARA%'
            criteria.add(Restrictions.or(Restrictions.ilike("username", query,MatchMode.ANYWHERE),
                    Restrictions.ilike("adSoyad", query,MatchMode.ANYWHERE)));
        }
        criteria.addOrder(Order.asc("id"));
        List l = criteria.list();
        session.close();
        return l;
    }

    @Override
    public Kullanici getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("id", id));
        return (Kullanici) criteria.uniqueResult();
    }

    public Kullanici getUsernameAndPassword(String username, String pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("pass", pass));
        Kullanici k = (Kullanici) criteria.uniqueResult();
        session.close();
        return k;
    }
}
