package org.unasat.hibernate.dao;

import org.unasat.model.Ride;

import java.util.List;

/**
 * Created by justi on 3/4/2017.
 */
public interface RideDao {
    List<Ride> getListOfRides();

    Ride getRideByRideId(String rideId);

    boolean save(Ride ride);

    boolean isRideExists(Ride ride);
}
