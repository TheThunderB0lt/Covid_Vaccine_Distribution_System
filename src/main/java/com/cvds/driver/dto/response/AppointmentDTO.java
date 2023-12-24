package com.cvds.driver.dto.response;

import com.cvds.driver.models.Doctor;
import com.cvds.driver.models.Patient;
import com.cvds.driver.models.VaccinationCenter;

public class AppointmentDTO {
    int doseNumber;
    Patient patient;
    Doctor doctor;
    VaccinationCenter vaccinationCenter;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int doseNumber, Patient patient, Doctor doctor, VaccinationCenter vaccinationCenter) {
        this.doseNumber = doseNumber;
        this.patient = patient;
        this.doctor = doctor;
        this.vaccinationCenter = vaccinationCenter;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "doseNumber=" + doseNumber +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", vaccinationCenter=" + vaccinationCenter +
                '}';
    }
}
