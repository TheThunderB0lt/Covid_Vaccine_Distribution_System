package com.cvds.driver.controller;

import com.cvds.driver.models.Doctor;
import com.cvds.driver.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@RequestMapping("/doctor") //Base endpoint
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor obj) {
        Doctor doctor = doctorService.registerDoctor(obj);
        return "Doctor details Created";
    }
}
