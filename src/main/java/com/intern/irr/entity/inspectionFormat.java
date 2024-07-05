package com.intern.irr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="frformat1")
public class inspectionFormat {
    @Id
    @Column(name="frno")
    private String frNo;
    @Column(name="format_no")
    private String formatNo;
    @Column(name="inspection_and_testing")
    private String inspectionAndTesting;
    @Column(name="safety_devices")
    private String safetyDevices;
    @Column(name="inspection_frequency")
    private String inspectionFrequency;
    @Column(name="test_procedure")
    private String testProcedure;

    public inspectionFormat() {}

    public String getFrNo() {
        return frNo;
    }

    public void setFrNo(String frNo) {
        this.frNo = frNo;
    }

    public String getFormatNo() {
        return formatNo;
    }

    public void setFormatNo(String formatNo) {
        this.formatNo = formatNo;
    }

    public String getInspectionAndTesting() {
        return inspectionAndTesting;
    }

    public void setInspectionAndTesting(String inspectionAndTesting) {
        this.inspectionAndTesting = inspectionAndTesting;
    }

    public String getSafetyDevices() {
        return safetyDevices;
    }

    public void setSafetyDevices(String safetyDevices) {
        this.safetyDevices = safetyDevices;
    }

    public String getInspectionFrequency() {
        return inspectionFrequency;
    }

    public void setInspectionFrequency(String inspectionFrequency) {
        this.inspectionFrequency = inspectionFrequency;
    }

    public String getTestProcedure() {
        return testProcedure;
    }

    public void setTestProcedure(String testProcedure) {
        this.testProcedure = testProcedure;
    }

    @Override
    public String toString() {
        return "inspectionFormat{" +
                "frNo='" + frNo + '\'' +
                ", formatNo='" + formatNo + '\'' +
                ", inspectionAndTesting='" + inspectionAndTesting + '\'' +
                ", safetyDevices='" + safetyDevices + '\'' +
                ", inspectionFrequency='" + inspectionFrequency + '\'' +
                ", testProcedure='" + testProcedure + '\'' +
                '}';
    }
}
