package com.cvds.driver.service;

import com.cvds.driver.models.VaccinationCenter;
import com.cvds.driver.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenter registerVaccinationCenter(VaccinationCenter vaccinationCenter) {
        vaccinationCenterRepository.save(vaccinationCenter);
        return vaccinationCenter;
    }

    public List<VaccinationCenter> getMinDoctorCountInVC() {
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterRepository.getMinDoctorVaccinationCenter();
        return vaccinationCenters;
    }
}
