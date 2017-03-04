package org.unasat.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.unasat.hibernate.util.HibernateUtil;
import org.unasat.model.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public class HibernateRouteDao implements RouteDao {

    @Override
    public List<Route> getListOfRoutes() {
        List<Route> list = new ArrayList<Route>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Route").list();
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
    public Route getRouteByRouteId(String routeId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Route route = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ride where id=" + routeId + "");
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return route;
    }

    @Override
    public boolean save(Route route) {
        Session session = HibernateUtil.openSession();
        if (isRouteExists(route)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(route);
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
    public boolean isRouteExists(Route route) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Route where id =" + route.getId() + "");
            Route u = (Route) query.uniqueResult();
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
