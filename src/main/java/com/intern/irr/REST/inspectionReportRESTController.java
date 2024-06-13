package com.intern.irr.REST;

import com.intern.irr.entity.ReportAndDevicesPOJO;
import com.intern.irr.entity.inspectionReport;
import com.intern.irr.services.inspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class inspectionReportRESTController {

    //INJECT Service using constructor injection
    private inspectionService inspService;
    @Autowired
    public inspectionReportRESTController(inspectionService x){
        this.inspService =x;
    }

    //Expose Endpoints
    @GetMapping("/reports")
    public List<inspectionReport> getAll(){
        return inspService.getAll();
    }

    @GetMapping("/reports/{uuid}")
    public inspectionReport getReportByID(@PathVariable String uuid){

        inspectionReport temp= inspService.getReportByUUID(uuid);
        if(temp==null){
            throw new RuntimeException("\nEmployee with id "+uuid+" not found\n");
        }
        return temp;
    }

    //POST MAPPING
    @PostMapping("/reports")
    public ReportAndDevicesPOJO addReport(@RequestBody ReportAndDevicesPOJO body){
        inspectionReport rep = body.getReport();
        inspectionReport dbReport= new inspectionReport(rep.getFrNo(),rep.getFrNo(),rep.getInspectionAndTesting(),rep.getSafetyDevices(), rep.getInspectionFrequency(), rep.getTestProcedure(), rep.getTestDate(), rep.getSafetyDevicesNo());
        inspService.createReport(dbReport, body.getDevices());
        System.out.println("created new report: \n"+dbReport.toString());
        return body;
    }
    @DeleteMapping("/reports/{uuid}")
    public String deleteEmployeeByUUID(@PathVariable String uuid){
        inspService.deleteReportByUUID(uuid);
        return("Deleted Employee with uuid:<br>"+uuid);
    }
}
