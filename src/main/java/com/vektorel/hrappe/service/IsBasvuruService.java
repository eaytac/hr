
package com.vektorel.hrappe.service;

import com.vektorel.hrappe.entity.IsBasvuru;
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
public class IsBasvuruService implements IBaseService<IsBasvuru> {

    @Override
    public boolean save(IsBasvuru entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.save(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(IsBasvuru entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.update(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(IsBasvuru entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(entity);
        trans.commit();
        session.close();
        return true;
    }

    @Override
    public List<IsBasvuru> getAll(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(IsBasvuru.class);
//        if(query!=null){
//            criteria.add(Restrictions.or(Restrictions.ilike("username", query,MatchMode.ANYWHERE),
//                    Restrictions.ilike("adSoyad", query,MatchMode.ANYWHERE)));
//        }
        criteria.addOrder(Order.asc("id"));
        List l = criteria.list();
        session.close();
        return l;
    }

    @Override
    public IsBasvuru getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(IsBasvuru.class);
        criteria.add(Restrictions.eq("id", id));
        IsBasvuru isBasvuru = (IsBasvuru) criteria.uniqueResult();
        session.close();
        return isBasvuru;
    }

}
