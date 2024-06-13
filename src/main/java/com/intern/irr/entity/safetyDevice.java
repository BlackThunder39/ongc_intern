package com.intern.irr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="safety_device")
public class safetyDevice {
    @Id
    @Column(name="uuid")
    private String uuid;

    @Id
    @Column(name="srno")
    private Integer srno;
    @Column(name="safety_device")
    private String safetyDevice;
    @Column(name="safety_device_tag")
    private String safetyDeviceTag;
    @Column(name="activity")
    private String activity;
    @Column(name="observation")
    private String observation;
    @Column(name="requirements")
    private String requirements;
    @Column(name="remarks")
    private String remarks;

    //CONSTRUCTORS

    public safetyDevice() {}

    public safetyDevice(String uuid, Integer srno, String safetyDevice, String safetyDeviceTag, String activity, String observation, String requirements, String remarks) {
        this.uuid = uuid;
        this.srno = srno;
        this.safetyDevice = safetyDevice;
        this.safetyDeviceTag = safetyDeviceTag;
        this.activity = activity;
        this.observation = observation;
        this.requirements = requirements;
        this.remarks = remarks;
    }


    //GETTERS SETTERS
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getSrno() {
        return srno;
    }

    public void setSrno(Integer srno) {
        this.srno = srno;
    }

    public String getSafetyDevice() {
        return safetyDevice;
    }

    public void setSafetyDevice(String safetyDevice) {
        this.safetyDevice = safetyDevice;
    }

    public String getSafetyDeviceTag() {
        return safetyDeviceTag;
    }

    public void setSafetyDeviceTag(String safetyDeviceTag) {
        this.safetyDeviceTag = safetyDeviceTag;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }



    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "safetyDevice{" +
                "uuid='" + uuid + '\'' +
                ", srno=" + srno +
                ", safetyDevice='" + safetyDevice + '\'' +
                ", safetyDeviceTag='" + safetyDeviceTag + '\'' +
                ", activity='" + activity + '\'' +
                ", observation='" + observation + '\'' +
                ", requirements='" + requirements + '\'' +
                ", remarks=" + remarks +
                '}';
    }
}
