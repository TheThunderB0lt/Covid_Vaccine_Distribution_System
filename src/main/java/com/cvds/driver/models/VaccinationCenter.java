package com.cvds.driver.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity // To create automatically table in Postgre with Table name VC
public class VaccinationCenter {
    @Id // It Indicates the ID
    @GeneratedValue(strategy = GenerationType.AUTO) // Generating unique ID for each VC
    UUID id; // Unique ID for each VC
    String name; // VC Name
    String type; //--> Govt / Pvt
    int covishieldCount;
    int covaxinCount; // No of Doses are in this VC
    int sputnikCount;
    int patientCount;
    int doctorCount;
    String address; // Address of the VC

    // 1 Doctors can work in --> Many vaccinationCenter ... (AND) ... Many Doctor are in --> 1 vaccinationCenter // --> BI_Directional
    @OneToMany(mappedBy = "vaccinationCenter") // DB(Table) -->(Vaccination_Doctor) this table is maintained by VC
    List<Doctor> doctors; //There will be multiple doctors are working in 1 vaccination center

    public VaccinationCenter() {
    }

    public VaccinationCenter(UUID id, String name, String type, int covishieldCount, int covaxinCount, int sputnikCount, int patientCount, int doctorCount, String address, List<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.covishieldCount = covishieldCount;
        this.covaxinCount = covaxinCount;
        this.sputnikCount = sputnikCount;
        this.patientCount = patientCount;
        this.doctorCount = doctorCount;
        this.address = address;
        this.doctors = doctors;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCovishieldCount() {
        return covishieldCount;
    }

    public void setCovishieldCount(int covishieldCount) {
        this.covishieldCount = covishieldCount;
    }

    public int getCovaxinCount() {
        return covaxinCount;
    }

    public void setCovaxinCount(int covaxinCount) {
        this.covaxinCount = covaxinCount;
    }

    public int getSputnikCount() {
        return sputnikCount;
    }

    public void setSputnikCount(int sputnikCount) {
        this.sputnikCount = sputnikCount;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public int getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(int doctorCount) {
        this.doctorCount = doctorCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "VaccinationCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", covishieldCount=" + covishieldCount +
                ", covaxinCount=" + covaxinCount +
                ", sputnikCount=" + sputnikCount +
                ", patientCount=" + patientCount +
                ", doctorCount=" + doctorCount +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
