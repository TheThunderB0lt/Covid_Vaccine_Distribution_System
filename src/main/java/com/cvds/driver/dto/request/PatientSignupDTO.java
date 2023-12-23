package com.cvds.driver.dto.request;

import com.cvds.driver.enums.VaccinationPreference;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PatientSignupDTO {
    String name;
    String email;
    String password;
    String aadhaarnumber;
    long phoneNumber;
    String gender;
    VaccinationPreference vaccinationPreference; // It accepts only 3, bcoz its enum class --> Covishield, Covxin, Sputnik
    String address;

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAadhaarnumber() {
        return aadhaarnumber;
    }

    public void setAadhaarnumber(String aadhaarnumber) {
        this.aadhaarnumber = aadhaarnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public VaccinationPreference getVaccinationPreference() {
        return vaccinationPreference;
    }

    public void setVaccinationPreference(VaccinationPreference vaccinationPreference) {
        this.vaccinationPreference = vaccinationPreference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
