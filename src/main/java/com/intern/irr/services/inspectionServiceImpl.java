package com.intern.irr.services;

import com.intern.irr.DAO.inspectionReportDAO;
import com.intern.irr.DAO.safetyDeviceDAO;
import com.intern.irr.entity.inspectionReport;
import com.intern.irr.entity.safetyDevice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class inspectionServiceImpl implements inspectionService {
    private inspectionReportDAO ins;
    private safetyDeviceDAO safetyDev;

    @Autowired
    public inspectionServiceImpl(inspectionReportDAO x, safetyDeviceDAO y){
        this.safetyDev=y;
        this.ins=x;
    }


    @Override
    public List<inspectionReport> getAll() {
        return ins.getAll();
    }
    @Transactional
    @Override
    public void createReport(inspectionReport report, List<safetyDevice> devices) {
        ins.createReport(report);

        //make all uuids for devices same as report being added
        for(safetyDevice s: devices){
            s.setUuid(report.getUuid());
        }
        safetyDev.createSafetyDevices(devices);

    }

    @Override
    public inspectionReport getReportByUUID(String uuid) {
        return ins.getReportByUUID(uuid);
    }
    @Transactional
    @Override
    public void deleteReportByUUID(String uuid) {
        ins.deleteReportByUUID(uuid);
    }
}
