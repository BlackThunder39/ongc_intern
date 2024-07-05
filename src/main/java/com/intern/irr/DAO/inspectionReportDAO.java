package com.intern.irr.DAO;

import com.intern.irr.entity.inspectionReport;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface inspectionReportDAO {

    List<inspectionReport> getAll();

    List<inspectionReport> searchReports(String x);

    //CRUD
    //Create
    inspectionReport createReport(inspectionReport report);

    //Read
    inspectionReport getReportByUUID(String uuid);

    //Update: TBD

    //Delete
    void deleteReportByUUID(String uuid);
}
