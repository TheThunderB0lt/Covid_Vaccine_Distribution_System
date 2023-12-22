package com.cvds.driver.controller;

import com.cvds.driver.models.VaccinationCenter;
import com.cvds.driver.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vc") //Base Endpoint

public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @GetMapping("/home")
    public String homepage() {
        return "This is Welcome page of COVID Vaccine Distribution Management System!";
    }

    @PostMapping("/register")
    public VaccinationCenter register(@RequestBody VaccinationCenter vaccinationCenter) {
        return vaccinationCenterService.registerVaccinationCenter(vaccinationCenter);
    }

}
