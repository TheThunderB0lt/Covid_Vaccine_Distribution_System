package com.cvds.driver.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Patient {
    @Id //creating ID
    @GeneratedValue(strategy = GenerationType.AUTO) //generating unique id automatically instead of creating new IDs all time
    UUID id; //UniqueID

    String name;
    String gender;

    @Column(unique = true)
    String aadhaarNumber;

    int doseCount;
    String VaccinationPreference;
    String address;

    @Column(unique = true)
    long phoneNumber;

    @Column(unique = true)
    String email;

    String password;

    public Patient() {
    }

    public Patient(UUID id, String name, String gender, String aadhaarNumber, int doseCount, String vaccinationPreference, String address, long phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.aadhaarNumber = aadhaarNumber;
        this.doseCount = doseCount;
        VaccinationPreference = vaccinationPreference;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public int getDoseCount() {
        return doseCount;
    }

    public void setDoseCount(int doseCount) {
        this.doseCount = doseCount;
    }

    public String getVaccinationPreference() {
        return VaccinationPreference;
    }

    public void setVaccinationPreference(String vaccinationPreference) {
        VaccinationPreference = vaccinationPreference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", aadhaarNumber='" + aadhaarNumber + '\'' +
                ", doseCount=" + doseCount +
                ", VaccinationPreference='" + VaccinationPreference + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
