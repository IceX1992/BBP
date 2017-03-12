package org.unasat.hibernate.dao;

import org.unasat.model.BusRoute;

import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public interface BusRouteDao {
    List<BusRoute> getListOfBusRoutes();

    BusRoute getBusRouteByBusRouteId(Long busRouteId);

    boolean save(BusRoute busRoute);

    BusRoute getBusRouteByBusRouteName(String busRouteName);

    boolean isBusRouteExists(BusRoute busRoute);
}
