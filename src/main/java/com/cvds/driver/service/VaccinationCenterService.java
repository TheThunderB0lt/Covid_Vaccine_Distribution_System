package com.cvds.driver.service;

import com.cvds.driver.models.VaccinationCenter;
import com.cvds.driver.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public void updateCountByOne(VaccinationCenter vaccinationCenter) {
        UUID id = vaccinationCenter.getId();
        int docCount = vaccinationCenter.getDoctorCount() + 1;
        vaccinationCenterRepository.updateDocCountByOne(id, docCount);
    }

    public List<VaccinationCenter> getMinimumVCOnTheBasisOfTypeAndPreference(String type, String preference) {
        if(preference.equals("Sputnik")) {
            return vaccinationCenterRepository.getAllVCOnTheBasisOfTypeAndSputnikinCount(type);
        } else if(preference.equals("Covishield")) {
            return vaccinationCenterRepository.getAllVCOnTheBasisOfTypeAndCovishieldinCount(type);
        } else {
            return vaccinationCenterRepository.getAllVCOnTheBasisOfTypeAndCovaxinCount(type);
        }
    }
}
