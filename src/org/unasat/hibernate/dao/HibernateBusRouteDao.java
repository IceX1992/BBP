package org.unasat.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.unasat.hibernate.util.HibernateUtil;
import org.unasat.model.BusRoute;

import java.math.BigInteger;
import java.util.*;

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
    public List<BusRoute> getListOfBusRoutesNotUsedRides() {
        List<BusRoute> list = new ArrayList<BusRoute>();

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            //Query query2 = session.createSQLQuery("select br.id,br.name,br.estimated_arrival,br.estimated_departure,br.bus_id,br.route_id from bus_route as br left join ride as r on r.busRoute_id = br.id where r.id is null");
            Query query2 = session.createSQLQuery("select br.* from bus_route as br left join ride as r on r.busRoute_id = br.id where r.id is null");
            list = query2.list();

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
    public BusRoute getBusRouteByBusRouteId(Long busRouteId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        BusRoute busRoute = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from BusRoute where id=" + busRouteId);
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
    public List<BusRoute> getBusRouteLate() {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<BusRoute> busRouteList = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            busRouteList = session.createQuery("from Ride where actualArrival > busRoute.estimatedDArrival").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return busRouteList;
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
    public BusRoute getBusRouteByBusRouteName(String busRouteName) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        BusRoute busRoute = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from BusRoute where busRoute=:busRoute");
            query.setParameter("busRoute", busRouteName);
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

    @Override
    public Long countRoute(Long routeId){
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Long result = 0L;
        Object obj;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query2 = session.createSQLQuery("select count(*) from bus_route where bus_route.route_id = :ROUTEID");
            query2.setParameter("ROUTEID",routeId);
            obj = query2.uniqueResult();
            BigInteger test = (BigInteger) obj;
            result = test != null ? test.longValue() : 0L;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
