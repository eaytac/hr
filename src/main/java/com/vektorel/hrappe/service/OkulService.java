
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.Okul;
import com.vektorel.hrappe.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eaytac
 */
public class OkulService implements IBaseService<Okul> {

    @Override
    public boolean save(Okul entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Okul entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Okul entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Okul> getAll(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Okul.class);
        criteria.addOrder(Order.asc("kod"));
        List l = criteria.list();
        session.close();
        return l;
    }

    @Override
    public Okul getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Okul.class);
        criteria.add(Restrictions.eq("id", id));

        Okul okul = (Okul) criteria.uniqueResult();
        session.close();
        return okul;
    }

    public Okul getByKod(Long kod) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Okul.class);
        criteria.add(Restrictions.eq("kod", kod));

        Okul okul = (Okul) criteria.uniqueResult();
        session.close();
        return okul;
    }
}
