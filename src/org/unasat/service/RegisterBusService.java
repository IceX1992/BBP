package org.unasat.service;

import org.unasat.hibernate.dao.BusDao;
import org.unasat.model.Bus;

/**
 * Created by dionc on 3/10/2017.
 */
public class RegisterBusService {

    BusDao busDao;

    public RegisterBusService(BusDao busDao) {
        super();
        this.busDao = busDao;
    }

    public boolean register (Bus bus){
      return busDao.save(bus);
    }
}
