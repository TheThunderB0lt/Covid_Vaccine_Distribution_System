package com.cvds.driver.service;

import com.cvds.driver.dto.request.PatientLoginDTO;
import com.cvds.driver.dto.request.PatientSignupDTO;
import com.cvds.driver.dto.response.AppointmentDTO;
import com.cvds.driver.exceptions.PatientDoesNotExitException;
import com.cvds.driver.exceptions.WrongCredentials;
import com.cvds.driver.models.Doctor;
import com.cvds.driver.models.Patient;
import com.cvds.driver.models.VaccinationCenter;
import com.cvds.driver.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @Autowired
    DoctorService doctorService;

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

    public AppointmentDTO createAppointment(String email, String vaccinationCenterPreference) {
        //1. Get patient by email
        Patient p = patientRepository.getPatientByEmail(email);

        //2. Identify vaccination preference
        String vPref = p.getVaccinationPreference();

        // Getting all the VC & the preferences
        List<VaccinationCenter> vcList = vaccinationCenterService.getMinimumVCOnTheBasisOfTypeAndPreference(vaccinationCenterPreference, vPref);

        //3. Assigning 0th index VC to patient
        VaccinationCenter patientVC = vcList.get(0);

        //4. Assign doctor who is handling minimum number patient to current patient
        List<Doctor> doctorList = doctorService.getMinimumDoctorOnTheBasisOfVC(patientVC.getId());

        //5. Take out minimum doctor
        Doctor patientDoctor = doctorList.get(0);

        //patient_count for that particular VC will get +1 //--> VC -> patient_count + 1
        vaccinationCenterService.updatePatientCountByOne(patientVC);

        //Doctor -> patient_count + 1
        doctorService.updatePatientCountByOne(patientDoctor);

        //This particular doctor see this particular patient
        patientDoctor.getPatients().add(p);

        //getting pId & docId then save into doctor_patient TB
        //Doctor -> List -> add patient -> Insert docId, PId into Doctor_Patient TB
        doctorService.addpatientVsDoctor(p.getId(), patientDoctor.getId());

        //Return ResponseBody -> Patient details, patientVc details, doctor details
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDoseNumber(p.getDoseCount() + 1);
        appointmentDTO.setPatient(p);
        appointmentDTO.setDoctor(patientDoctor);
        appointmentDTO.setVaccinationCenter(patientVC);

        return appointmentDTO;
    }
}
