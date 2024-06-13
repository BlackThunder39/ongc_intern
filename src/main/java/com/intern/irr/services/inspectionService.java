package com.intern.irr.services;

import com.intern.irr.entity.inspectionReport;
import com.intern.irr.entity.safetyDevice;

import java.util.List;

public interface inspectionService {
    List<inspectionReport> getAll();
    //CRUD
    //Create
    void createReport(inspectionReport report, List<safetyDevice> devices);

    //Read
    inspectionReport getReportByUUID(String uuid);

    //Update: TBD

    //Delete
    void deleteReportByUUID(String uuid);




}
