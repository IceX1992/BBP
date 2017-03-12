package org.unasat.service;

import org.unasat.hibernate.dao.BusDao;
import org.unasat.model.Bus;

import java.util.List;

/**
 * Created by dionc on 3/10/2017.
 */
public class RegisterBusService {

    BusDao busDao;

    public Bus findById(Long id){
        return busDao.getBusByBusId(id);
    }

    public RegisterBusService(BusDao busDao) {
        super();
        this.busDao = busDao;
    }

    public boolean register (Bus bus){
      return busDao.save(bus);
    }

    public boolean update (Bus bus){
      return busDao.update(bus);
    }

    public List<Bus> getAll(){
        return  busDao.getListOfBusses();
    }

    public int countBusses(){
        List<Bus> busList = busDao.getListOfBusses();
        return  busList.size();
    }

    public int getMaxCount(){
        List<Bus> busList = busDao.getListOfBusses();
        int count = 0;
        for(Bus bus : busList){
            count = (int) (count + bus.getMaxPassengers());
        }
        return  count;
    }

    public boolean delete (Bus bus){
        return busDao.delete(bus);
    }
}
