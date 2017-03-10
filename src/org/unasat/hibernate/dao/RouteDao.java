package org.unasat.hibernate.dao;

import org.unasat.model.Route;

import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public interface RouteDao {
    List<Route> getListOfRoutes();

    Route getRouteByRouteId(String routeId);

    boolean save(Route route);

    boolean isRouteExists(Route route);
}