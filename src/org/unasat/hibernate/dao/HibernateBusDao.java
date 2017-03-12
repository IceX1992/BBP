package org.unasat.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.unasat.hibernate.util.HibernateUtil;
import org.unasat.model.Bus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dionc on 2/25/2017.
 */
public class HibernateBusDao implements BusDao {


    @Override
    public List<Bus> getListOfBusses() {
        List<Bus> list = new ArrayList<Bus>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Bus").list();
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
    public Bus getBusByBusId(Long busId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Bus bus = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Bus where id="+busId+"");
            bus = (Bus)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bus;    }

    @Override
    public Bus getBusByBusPlate(String busPlate) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Bus bus = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Bus where licencePlate=:licPlate");
            query.setParameter("licPlate", busPlate);
            bus = (Bus)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bus;    }

    @Override
    public boolean save(Bus bus) {
        Session session = HibernateUtil.openSession();
        if(isBusExists(bus)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(bus);
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
    public boolean delete(Bus bus) {
        Session session = HibernateUtil.openSession();
        if(!isBusExists(bus)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.delete(bus);
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
    public boolean update(Bus bus) {
        Session session = HibernateUtil.openSession();

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(bus);
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
    public boolean isBusExists(Bus bus){
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Bus where id="+bus.getId()+"");
            Bus u = (Bus)query.uniqueResult();
            tx.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }

}
