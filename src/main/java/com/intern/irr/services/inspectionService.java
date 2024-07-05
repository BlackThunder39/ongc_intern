package com.intern.irr.services;

import com.intern.irr.entity.User;
import com.intern.irr.entity.inspectionFormat;
import com.intern.irr.entity.inspectionReport;
import com.intern.irr.entity.safetyDevice;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface inspectionService {
    List<inspectionReport> getAll();
    //CRUD
    //Create
    void createReport(inspectionReport report, List<safetyDevice> devices);

    //Read
    inspectionReport getReportByUUID(String uuid);
    public List<inspectionReport> searchReports(String x);

    //Update: TBD

    //Delete
    void deleteReportByUUID(String uuid);

    public inspectionFormat getRelatedInfo(String name);
    public List<inspectionFormat> getAllFormats();
    List<safetyDevice> getAllSafetyDevices(String uuid);
    //LOGIN
    public List<User> getAllUsers();
    public List<User> Login(String username, String password);

}
