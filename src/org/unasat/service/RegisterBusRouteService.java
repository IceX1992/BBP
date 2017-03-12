package org.unasat.service;

import org.unasat.hibernate.dao.BusRouteDao;
import org.unasat.model.Bus;
import org.unasat.model.BusRoute;
import org.unasat.model.Route;

import java.util.List;

/**
 * Created by dionc on 3/11/2017.
 */
public class RegisterBusRouteService {

    BusRouteDao busRouteDao;

    RegisterBusService registerBusService;

    RegisterRouteService registerRouteService;

    public RegisterBusRouteService(BusRouteDao busRouteDao) {
        super();
        this.busRouteDao = busRouteDao;
    }

    public boolean register (BusRoute busRoute){
        return busRouteDao.save(busRoute);
    }

    public List<BusRoute> getAll(){
        return  busRouteDao.getListOfBusRoutes();
    }

    public List<Bus> getAllBusses(){
        return registerBusService.getAll();
    }

    public List<Route> getAllRoutes(){
        return registerRouteService.getAll();
    }

}
