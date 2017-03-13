package org.unasat.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.unasat.hibernate.util.HibernateUtil;
import org.unasat.model.Ride;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public class HibernateRideDao implements RideDao {

    @Override
    public List<Ride> getListOfRides() {
        List<Ride> list = new ArrayList<Ride>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Ride").list();
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
    public List<Ride> getListOfLateRides() {
        List<Ride> list = new ArrayList<Ride>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query2 = session.createSQLQuery("select ride.* from ride  join bus_route on ride.busRoute_id = bus_route.id where ride.actual_arrival > bus_route.estimated_arrival");
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
    public Ride getRideByRideId(String rideId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Ride ride = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ride where id=" + rideId + "");
            ride = (Ride) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ride;
    }

    @Override
    public boolean save(Ride ride) {
        Session session = HibernateUtil.openSession();
        if (isRideExists(ride)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(ride);
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
    public boolean isRideExists(Ride ride) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Ride where id =" + ride.getId() + "");
            Ride u = (Ride) query.uniqueResult();
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
