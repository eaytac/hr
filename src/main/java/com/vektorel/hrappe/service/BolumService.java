
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.Bolum;
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
public class BolumService implements IBaseService<Bolum> {

    @Override
    public boolean save(Bolum entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Bolum entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Bolum entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Bolum> getAll(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Bolum> list = null;
        
        if(query!=null){
            SQLQuery sorgu = session.createSQLQuery("select * from gnl_bolum where okul_id=" + new Long(query));
            sorgu.addEntity(Bolum.class);
            list = sorgu.list();
            //criteria.add(Restrictions.eq("il", query));
        } else {
            Criteria criteria = session.createCriteria(Bolum.class);
            criteria.addOrder(Order.asc("id"));
            list = criteria.list();
        }
        session.close();
        return list;
    }

    @Override
    public Bolum getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Bolum.class);
        criteria.add(Restrictions.eq("id", id));

        Bolum bolum = (Bolum) criteria.uniqueResult();
        session.close();
        return bolum;
    }
    
}
