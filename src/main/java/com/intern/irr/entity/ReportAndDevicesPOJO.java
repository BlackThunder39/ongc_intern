package com.intern.irr.entity;

import java.util.List;

public class ReportAndDevicesPOJO {
    inspectionReport report;
    List<safetyDevice> devices;

    public ReportAndDevicesPOJO() {}

    public inspectionReport getReport() {
        return report;
    }

    public void setReport(inspectionReport report) {
        this.report = report;
    }

    public List<safetyDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<safetyDevice> devices) {
        this.devices = devices;
    }
}
