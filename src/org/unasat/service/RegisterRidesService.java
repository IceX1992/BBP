package org.unasat.service;

import org.unasat.hibernate.dao.RideDao;
import org.unasat.model.Ride;

import java.util.List;

/**
 * Created by dionc on 3/12/2017.
 */
public class RegisterRidesService {

    RideDao rideDao;

    public RegisterRidesService(RideDao rideDao) {
        super();
        this.rideDao = rideDao;
    }

    public boolean register (Ride ride){
        return rideDao.save(ride);
    }

    public List<Ride> getAll(){
        return  rideDao.getListOfRides();
    }


}
