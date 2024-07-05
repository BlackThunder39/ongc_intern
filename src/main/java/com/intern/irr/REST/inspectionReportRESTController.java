package com.intern.irr.REST;

import com.intern.irr.DAO.UserDAO;
import com.intern.irr.entity.ReportAndDevicesPOJO;
import com.intern.irr.entity.User;
import com.intern.irr.entity.inspectionFormat;
import com.intern.irr.entity.inspectionReport;
import com.intern.irr.services.inspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class inspectionReportRESTController {

    //INJECT Service using constructor injection
    private final inspectionService inspService;
    @Autowired
    public inspectionReportRESTController(inspectionService x){
        this.inspService =x;
    }

    //Expose Endpoints
    @GetMapping("/reports")
    public List<inspectionReport> getAll(){
        return inspService.getAll();
    }

    @GetMapping("/search/{xyz}")
    public List<inspectionReport> searchReports(@PathVariable String xyz){
        return inspService.searchReports(xyz);
    }


    @GetMapping("/reports/{uuid}")
    public ReportAndDevicesPOJO getReportByID(@PathVariable String uuid){

        inspectionReport temp= inspService.getReportByUUID(uuid);
        if(temp==null){
            throw new RuntimeException("\nReport with id "+uuid+" not found\n");
        }
        
        ReportAndDevicesPOJO x = new ReportAndDevicesPOJO();
        x.setReport(temp);
        x.setDevices(inspService.getAllSafetyDevices(uuid));
        return x;
    }

    //POST MAPPING
    @PostMapping("/reports")
    public ReportAndDevicesPOJO addReport(@RequestBody ReportAndDevicesPOJO body){
        inspectionReport rep = body.getReport();
        inspectionReport dbReport= new inspectionReport(rep.getFrNo(),rep.getFormatNo(),rep.getInspectionAndTesting(),rep.getSafetyDevices(), rep.getInspectionFrequency(), rep.getTestProcedure(), rep.getTestDate(), rep.getSafetyDevicesNo(),rep.getAuthor() );
        inspService.createReport(dbReport, body.getDevices());
        System.out.println("created new report: \n"+dbReport.toString());
        return body;
    }
    @DeleteMapping("/reports/{uuid}")
    public String deleteEmployeeByUUID(@PathVariable String uuid){
        inspService.deleteReportByUUID(uuid);
        return("Deleted Report with uuid:<br>"+uuid);
    }


    //Formats
    @GetMapping("/getRelatedInfo/{name}")
    public inspectionFormat getRelatedInfo(@PathVariable String name){
        return inspService.getRelatedInfo(name);
    }

    @GetMapping("/getAllFormats")
    public List<inspectionFormat> getAllFormats(){
        return inspService.getAllFormats();
    }

    //LOGIN
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return inspService.getAllUsers();
    }

    @PostMapping("/login")
     public List<User> loginUser(@RequestBody User body){
        System.out.println(body.getCpf());
        List<User> x = inspService.Login(body.getCpf(), body.getPassword());
        return x;
    }

}
