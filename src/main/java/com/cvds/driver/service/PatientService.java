package com.cvds.driver.service;

import com.cvds.driver.dto.request.PatientLoginDTO;
import com.cvds.driver.dto.request.PatientSignupDTO;
import com.cvds.driver.exceptions.PatientDoesNotExitException;
import com.cvds.driver.exceptions.WrongCredentials;
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

    public Patient login(PatientLoginDTO patientLoginDTO) {
        Patient patient = patientRepository.getPatientByEmail(patientLoginDTO.getEmail());

        if(patient == null) {
            throw new PatientDoesNotExitException("Patient Email Id is not registered in our portal");
        }
        if(!patient.getPassword().equals(patientLoginDTO.getPassword())) {
            throw new WrongCredentials("Inavalid Password/Credentials");
        }
        return patient;
    }

    public void createAppointment(String email, String vaccinationPreference) {
        //1. Get patient by email
        Patient p = patientRepository.getPatientByEmail(email);

        //2. Identify vaccination preference
        String vPref = p.getVaccinationPreference();

        if(vPref.equals("Sputnik")) {

        } else if(vPref.equals("Covishield")) {

        } else if(vPref.equals("Covaxin")) {

        }
    }
}
