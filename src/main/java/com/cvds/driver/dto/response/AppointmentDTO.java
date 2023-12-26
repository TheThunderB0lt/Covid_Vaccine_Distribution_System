package com.cvds.driver.dto.response;


import com.cvds.driver.models.Patient;

import java.util.UUID;

public class AppointmentDTO {
    int doseNumber;
    Patient patient;
    UUID docId;
    String docName;
    UUID vcId;
    String vaccinationCenterName;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int doseNumber, Patient patient, UUID docId, String docName, UUID vcId, String vaccinationCenterName) {
        this.doseNumber = doseNumber;
        this.patient = patient;
        this.docId = docId;
        this.docName = docName;
        this.vcId = vcId;
        this.vaccinationCenterName = vaccinationCenterName;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public UUID getDocId() {
        return docId;
    }

    public void setDocId(UUID docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public UUID getVcId() {
        return vcId;
    }

    public void setVcId(UUID vcId) {
        this.vcId = vcId;
    }

    public String getVaccinationCenterName() {
        return vaccinationCenterName;
    }

    public void setVaccinationCenterName(String vaccinationCenterName) {
        this.vaccinationCenterName = vaccinationCenterName;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "doseNumber=" + doseNumber +
                ", patient=" + patient +
                ", docId=" + docId +
                ", docName='" + docName + '\'' +
                ", vcId=" + vcId +
                ", vaccinationCenterName='" + vaccinationCenterName + '\'' +
                '}';
    }
}
