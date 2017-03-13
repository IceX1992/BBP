package org.unasat.service;

import org.unasat.hibernate.dao.*;
import org.unasat.model.Bus;
import org.unasat.model.BusRoute;
import org.unasat.model.Route;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dionc on 3/11/2017.
 */
public class RegisterBusRouteService {


    RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
    RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());

    BusRouteDao busRouteDao;

    public RegisterBusRouteService(BusRouteDao busRouteDao) {
        super();
        this.busRouteDao = busRouteDao;
    }

    public boolean register (BusRoute busRoute){
        return busRouteDao.save(busRoute);
    }

    public BusRoute findByBusRouteName(String busRouteName){
        return busRouteDao.getBusRouteByBusRouteName(busRouteName);
    }

    public BusRoute findByBusRouteId(Long busRouteId){
        return busRouteDao.getBusRouteByBusRouteId(busRouteId);
    }

    public List<BusRoute> getAll(){
        return  busRouteDao.getListOfBusRoutes();
    }

    public List<BusRoute> getListOfBusRoutesNotUsedRides(){
        List<BusRoute> listNew = new ArrayList<BusRoute>();
        BusRoute busRoute2;
        List<BusRoute> list = busRouteDao.getListOfBusRoutesNotUsedRides();

        if (list.size() > 0) {
                /*for(BusRoute busRoute : list){
                    busRoute2 = new BusRoute(busRoute.getBusRoute(),busRoute.getEstimatedDeparture(),busRoute.getEstimatedDArrival(), busRoute.getBus(), busRoute.getRoute());
                    listNew.add(busRoute2);
                }*/
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                BigInteger busRouteIdBigInt = (BigInteger) obj[0];
                Long busRouteId = busRouteIdBigInt.longValue();
                String busRoute = String.valueOf(obj[1]);
                String estArrString = String.valueOf(obj[2]);
                String estDepString = String.valueOf(obj[3]);
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.S");
                Date estArr = new Date();
                Date estDep = new Date();
                try {
                    estArr = inputDateFormat.parse(estArrString);
                    estDep = inputDateFormat.parse(estDepString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                BigInteger busIdBigInt = (BigInteger) obj[4];
                BigInteger routeIdBigInt = (BigInteger) obj[5];
                Long busId = busIdBigInt.longValue();
                Long routeId = routeIdBigInt.longValue();
                Bus bus = registerBusService.findById(busId);
                Route route = registerRouteService.findById(routeId);
                busRoute2 = new BusRoute(busRouteId,busRoute,estDep, estArr,bus,route);
                listNew.add(busRoute2);
            }
        }return listNew;
    }

    public List<BusRoute> getBusRouteLate(){
        return  busRouteDao.getBusRouteLate();
    }

 /*   public List<Long> mostUsedRoutes(){
        List<Object> objects;
        Object[] obj;
        List<Long> longList = null;
        Long test = 0l;
        List<Route> routeList = registerRouteService.getAll();
        for(Route route : routeList){
            test = busRouteDao.countRoute(route.getId());
        }


        List<BusRoute> busRouteList = getAll();
        for(BusRoute busRoute : busRouteList){
            longList.add(busRouteDao.countRoute(busRoute.getRoute().getId()));
*//*
            obj[0] =  busRoute.getBusRoute();
*//*
*//*
            obj[]
*//*
        }
        return longList;
    }*/

    public Long countRoute(Long routeId){
        return busRouteDao.countRoute(routeId);
    };



}
