package org.unasat.hibernate.dao;

import org.unasat.model.Route;

import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public interface RouteDao {
    List<Route> getListOfRoutes();

    Route getRouteByRouteId(Long routeId);

    Route getRouteByRouteName(String routeName);

    boolean save(Route route);

    boolean isRouteExists(Route route);

    boolean delete(Route route);

    boolean update(Route route);
}