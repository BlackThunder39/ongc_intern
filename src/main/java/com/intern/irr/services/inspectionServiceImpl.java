package com.intern.irr.services;

import com.intern.irr.DAO.UserDAO;
import com.intern.irr.DAO.inspectionFormatDAO;
import com.intern.irr.DAO.inspectionReportDAO;
import com.intern.irr.DAO.safetyDeviceDAO;
import com.intern.irr.entity.User;
import com.intern.irr.entity.inspectionFormat;
import com.intern.irr.entity.inspectionReport;
import com.intern.irr.entity.safetyDevice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class inspectionServiceImpl implements inspectionService {
    private inspectionReportDAO ins;
    private safetyDeviceDAO safetyDev;
    private inspectionFormatDAO format;

    private UserDAO user;

    @Autowired
    public inspectionServiceImpl(inspectionReportDAO x, safetyDeviceDAO y, inspectionFormatDAO z, UserDAO alpha){
        this.safetyDev=y;
        this.format=z;
        this.ins=x;
        this.user=alpha;
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
    @Override
    public List<safetyDevice> getAllSafetyDevices(String uuid){
        return safetyDev.getAllSafetyDevices(uuid);
    }
    @Override
    public List<inspectionReport> searchReports(String x) {
        return ins.searchReports(x);
    }


    @Transactional
    @Override
    public void deleteReportByUUID(String uuid) {
        ins.deleteReportByUUID(uuid);
    }



    // FORMATS:
    @Override
    public inspectionFormat getRelatedInfo(String name){
        return format.getData(name);
    }
    @Override
    public List<inspectionFormat> getAllFormats() {
        return format.getAllFormats();
    }


    //LOGIN
    public List<User> getAllUsers(){
        return user.getAllUsers();
    }
    public List<User> Login(String username, String password){
        return user.loginUser(username, password);
    }
}
