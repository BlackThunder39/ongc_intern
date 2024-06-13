package com.intern.irr.DAO;

import com.intern.irr.entity.safetyDevice;

import java.util.List;

public interface safetyDeviceDAO {
    //CRUD

    //Create
    String createSafetyDevices(List<safetyDevice> devices);

    //Read
    List<safetyDevice> getAllSafetyDevices(String uuid);

    //Update TBD
    //Delete
    String deleteAllSafetyDevices(String uuid);
}
