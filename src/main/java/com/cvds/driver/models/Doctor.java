package com.cvds.driver.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id; // Unique ID for doctor
    String name;
    String docDegree;

    // Many Doctor are in --> 1 vaccinationCenter ... (AND) ... 1 Doctors can work in --> Many vaccinationCenter // --> BI_Directional
    @ManyToOne // DB(Table) -->(Vaccination_Doctor)
    VaccinationCenter vaccinationCenter;

    int patientCount;

    // 1 Doctor can see --> Many patients ... (BUT) ... Many Doctors can't check to !-> 1 Patient // --> UNI_Directional
    @OneToMany // DB(Table) -->(Vaccination_Doctor) (Doctor_Patient)
    List<Patient> patients; // a particular doctor can see many patients

    public Doctor() {
    }

    public Doctor(UUID id, String name, String docDegree, VaccinationCenter vaccinationCenter, int patientCount, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.docDegree = docDegree;
        this.vaccinationCenter = vaccinationCenter;
        this.patientCount = patientCount;
        this.patients = patients;
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

    public String getDocDegree() {
        return docDegree;
    }

    public void setDocDegree(String docDegree) {
        this.docDegree = docDegree;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
