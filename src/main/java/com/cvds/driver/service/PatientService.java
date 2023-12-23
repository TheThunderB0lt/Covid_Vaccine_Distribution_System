package com.cvds.driver.service;

import com.cvds.driver.dto.request.PatientSignupDTO;
import com.cvds.driver.models.Patient;
import com.cvds.driver.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient signUp(PatientSignupDTO patientSignupDTO) {
        Patient patient = new Patient();

        patient.setName(patientSignupDTO.getName());
        patient.setEmail((patientSignupDTO.getEmail()));
        patient.setGender(patientSignupDTO.getGender());
        patient.setAddress(patientSignupDTO.getAddress());
        patient.setAadhaarNumber(patientSignupDTO.getAadhaarnumber());
        patient.setPassword(patientSignupDTO.getPassword());
        patient.setPhoneNumber(patientSignupDTO.getPhoneNumber());
        patient.setVaccinationPreference(patientSignupDTO.getVaccinationPreference().toString()); //this is for enum -->enum to string

        patientRepository.save(patient);
        return patient;
    }
}
