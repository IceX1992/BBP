package org.unasat.service;

import org.unasat.hibernate.dao.RouteDao;
import org.unasat.model.Route;

import java.util.List;

/**
 * Created by dionc on 3/11/2017.
 */
public class RegisterRouteService {

    RouteDao routeDao;

    public RegisterRouteService(RouteDao routeDao) {
        super();
        this.routeDao = routeDao;
    }

    public boolean register (Route route){
        return routeDao.save(route);
    }

    public boolean update (Route route){
        return routeDao.update(route);
    }

    public List<Route> getAll(){
        return  routeDao.getListOfRoutes();
    }

    public boolean delete (Route route){
        return routeDao.delete(route);
    }

}
