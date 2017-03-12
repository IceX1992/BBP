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

    public int countRides(){
        List<Ride> rideList = rideDao.getListOfRides();
        return  rideList.size();
    }

    public int getSoldTicketsCount(){
        List<Ride> rideList = rideDao.getListOfRides();
        int count = 0;
        for(Ride ride : rideList){
            count = (int) (count + ride.getSoldTickets());
        }
        return  count;
    }

    public List<Ride> getAll(){
        return  rideDao.getListOfRides();
    }


}
