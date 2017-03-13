package org.unasat.service;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.hibernate.dao.HibernateBusRouteDao;
import org.unasat.hibernate.dao.RideDao;
import org.unasat.model.BusRoute;
import org.unasat.model.Ride;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dionc on 3/12/2017.
 */
public class RegisterRidesService {

    RideDao rideDao;
    RegisterBusRouteService registerBusRouteService = new RegisterBusRouteService(new HibernateBusRouteDao());


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

    public List<Ride> getListOfLateRides(){
        Ride ride;
        List<Ride> listNew = new ArrayList<Ride>();
        List<Ride> list = rideDao.getListOfLateRides();
        if (list.size() > 0) {
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                BigInteger rideIdBigInt = (BigInteger) obj[0];
                Long rideId = rideIdBigInt.longValue();
                String actualArrString = String.valueOf(obj[1]);
                String actualDepString = String.valueOf(obj[2]);
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.S");
                Date actArr = new Date();
                Date actDep = new Date();
                try {
                    actArr = inputDateFormat.parse(actualArrString);
                    actDep = inputDateFormat.parse(actualDepString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                BigInteger busTicketsSoldInt = (BigInteger) obj[3];
                BigInteger busRouteIdBigInt = (BigInteger) obj[4];
                Long busTicketsSold = busTicketsSoldInt.longValue();
                Long busRouteId = busRouteIdBigInt.longValue();
                BusRoute busRoute = registerBusRouteService.findByBusRouteId(busRouteId);
                ride = new Ride(rideId,actArr,actDep,busTicketsSold,busRoute);
                listNew.add(ride);
            }
        }
        return listNew;
    }
}
