package com.cvds.driver.controller;

import com.cvds.driver.dto.request.PatientLoginDTO;
import com.cvds.driver.dto.request.PatientSignupDTO;
import com.cvds.driver.dto.response.GeneralMessageDTO;
import com.cvds.driver.enums.VaccinationPreference;
import com.cvds.driver.exceptions.PatientDoesNotExitException;
import com.cvds.driver.exceptions.WrongCredentials;
import com.cvds.driver.models.Patient;
import com.cvds.driver.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")

public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody PatientSignupDTO patientSignupDTO) {
        Patient patient = patientService.signUp(patientSignupDTO);
        return new ResponseEntity(patient, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody PatientLoginDTO patientLoginDTO) {
        try {
            Patient patient = patientService.login(patientLoginDTO);
            return new ResponseEntity(patient, HttpStatus.OK);
        } catch (WrongCredentials wrongCredentials) {
            return new ResponseEntity(new GeneralMessageDTO(wrongCredentials.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (PatientDoesNotExitException patientDoesNotExitException) {
            return new ResponseEntity(new GeneralMessageDTO(patientDoesNotExitException.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/createApprointment")
    public ResponseEntity createAppointment(@RequestParam String email, @RequestParam VaccinationPreference) {

    }
}
