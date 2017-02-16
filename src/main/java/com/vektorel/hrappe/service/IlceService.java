
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.Ilce;
import com.vektorel.hrappe.entity.Kisi;
import com.vektorel.hrappe.util.HRException;
import com.vektorel.hrappe.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eaytac
 */
public class IlceService implements IBaseService<Ilce> {

    @Override
    public boolean save(Ilce entity) throws Exception {

        if (entity.getAd() == null && entity.getAd().trim().equals("")) {
            throw new HRException("İlçe Adı Boş Olamaz!");
        }

        if (entity.getKod() == null && entity.getKod().trim().equals("")) {
            throw new HRException("İlçe Kodu Boş Olamaz!");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Ilce entity) throws Exception {
        if (entity.getAd() == null && entity.getAd().trim().equals("")) {
            throw new HRException("İlçe Adı Boş Olamaz!");
        }

        if (entity.getKod() == null && entity.getKod().trim().equals("")) {
            throw new HRException("İlçe Kodu Boş Olamaz!");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Ilce entity) throws Exception {
        if (entity.getAd() == null && entity.getAd().trim().equals("")) {
            throw new HRException("İlçe Adı Boş Olamaz!");
        }

        if (entity.getKod() == null && entity.getKod().trim().equals("")) {
            throw new HRException("İlçe Kodu Boş Olamaz!");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public List<Ilce> getAll(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Ilce> list = null;
        
        if(query!=null){
            SQLQuery sorgu = session.createSQLQuery("select * from gnl_ilce where il_id=" + new Long(query));
            sorgu.addEntity(Ilce.class);
            list = sorgu.list();
            //criteria.add(Restrictions.eq("il", query));
        } else {
            Criteria criteria = session.createCriteria(Ilce.class);
            criteria.addOrder(Order.asc("id"));
            list = criteria.list();
        }
        session.close();
        return list;
    }

    @Override
    public Ilce getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Ilce.class);
        criteria.add(Restrictions.eq("id", id));

        Ilce ilce = (Ilce) criteria.uniqueResult();
        session.close();
        return ilce;
    }

}
