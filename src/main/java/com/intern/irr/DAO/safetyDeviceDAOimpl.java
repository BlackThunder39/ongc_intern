package com.intern.irr.DAO;

import com.intern.irr.entity.inspectionReport;
import com.intern.irr.entity.safetyDevice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class safetyDeviceDAOimpl implements  safetyDeviceDAO{
    //define fields for entity manager (Created by springBoot)
    private EntityManager em;

    //Constructor Injection of Entity manager
    @Autowired
    public safetyDeviceDAOimpl(EntityManager emanager){
        this.em = emanager;
    }


    @Override
    public String createSafetyDevices(List<safetyDevice> devices) {
        for(safetyDevice s: devices) {
            em.persist(s);
            System.out.println("Adding device for uuid:\t"+s.getUuid());
        }
        return "devices added";
    }

    @Override
    public List<safetyDevice> getAllSafetyDevices(String uuid) {
        TypedQuery<safetyDevice> q = em.createQuery("SELECT s FROM safetyDevice s WHERE s.uuid=:theUUID", safetyDevice.class);
        q.setParameter("theUUID", uuid);
        return q.getResultList();
    }

    @Override
    public String deleteAllSafetyDevices(String uuid) {
        return null;
    }
}
