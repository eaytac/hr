
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.Kisi;
import com.vektorel.hrappe.util.HRException;
import com.vektorel.hrappe.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Emre
 */
public class KisiService implements IBaseService<Kisi> {
    
    @Override
    public boolean save(Kisi entity) throws Exception {

        if (entity.getAd() == null || entity.getAd().trim().equals("")) {
            throw new HRException("Kişi adı alanı boş bırakılmamalıdır.");
        }
        if (entity.getSoyad() == null || entity.getSoyad().trim().equals("")) {
            throw new HRException("Kişi soyadı alanı boş bırakılmamalıdır.");
        }
        if (entity.getTc() == null || entity.getTc().toString().equals("")) {
            throw new HRException("Kişi TC kimlik numarası alanı boş bırakılmamalıdır.");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.save(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Kisi entity) throws Exception {
        if (entity.getAd() == null || entity.getAd().trim().equals("")) {
            throw new HRException("Kişi adı alanı boş bırakılmamalıdır.");
        }
        if (entity.getSoyad() == null || entity.getSoyad().trim().equals("")) {
            throw new HRException("Kişi soyadı alanı boş bırakılmamalıdır.");
        }
        if (entity.getTc() == null || entity.getTc().toString().equals("")) {
            throw new HRException("Kişi TC kimlik numarası alanı boş bırakılmamalıdır.");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.update(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Kisi entity) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public List<Kisi> getAll(String query) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kisi.class);
        criteria.addOrder(Order.asc("id"));
        List l = criteria.list();
        session.close();
        return l;
    }

    @Override
    public Kisi getById(Long id) {
        Session  session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kisi.class);
        criteria.add(Restrictions.eq("id", id));
        Kisi kisi = (Kisi) criteria.uniqueResult();
        session.close();
        return kisi;
    }

}
