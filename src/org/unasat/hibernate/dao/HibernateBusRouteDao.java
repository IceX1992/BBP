package org.unasat.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.unasat.hibernate.util.HibernateUtil;
import org.unasat.model.BusRoute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public class HibernateBusRouteDao implements BusRouteDao {
    @Override
    public List<BusRoute> getListOfBusRoutes() {
        List<BusRoute> list = new ArrayList<BusRoute>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from BusRoute").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public BusRoute getBusRouteByBusRouteId(String busRouteId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        BusRoute busRoute = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from BusRoute where id=" + busRouteId + "");
            busRoute = (BusRoute) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return busRoute;
    }

    @Override
    public boolean save(BusRoute busRoute) {
        Session session = HibernateUtil.openSession();
        if (isBusRouteExists(busRoute)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(busRoute);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean isBusRouteExists(BusRoute busRoute) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where id=" + busRoute.getId() + "");
            BusRoute u = (BusRoute) query.uniqueResult();
            tx.commit();
            if (u != null) result = true;
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
}
