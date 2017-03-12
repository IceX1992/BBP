package org.unasat.hibernate.dao;

import org.unasat.model.BusRoute;

import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public interface BusRouteDao {
    List<BusRoute> getListOfBusRoutes();

    List<BusRoute> getListOfBusRoutesNotUsedRides();

    BusRoute getBusRouteByBusRouteId(Long busRouteId);

    List<BusRoute> getBusRouteLate();

    boolean save(BusRoute busRoute);

    BusRoute getBusRouteByBusRouteName(String busRouteName);

    boolean isBusRouteExists(BusRoute busRoute);

    Long countRoute(Long busId);
}
