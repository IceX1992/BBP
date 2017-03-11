package org.unasat.hibernate.dao;

import org.unasat.model.Bus;

import java.util.List;

/**
 * Created by dionc on 2/25/2017.
 */
public interface BusDao {
    List<Bus> getListOfBusses();
    Bus getBusByBusId(String busId);
    boolean save(Bus bus);

    boolean delete(Bus bus);

    boolean update(Bus bus);

    boolean isBusExists(Bus bus);
}
