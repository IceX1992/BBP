package org.unasat.service;

import org.unasat.hibernate.dao.BusRouteDao;
import org.unasat.model.BusRoute;

import java.util.List;

/**
 * Created by dionc on 3/11/2017.
 */
public class RegisterBusRouteService {

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

    public List<BusRoute> getAll(){
        return  busRouteDao.getListOfBusRoutes();
    }

}
