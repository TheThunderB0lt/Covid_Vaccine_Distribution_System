package com.cvds.driver.service;

import com.cvds.driver.models.Doctor;
import com.cvds.driver.models.VaccinationCenter;
import com.cvds.driver.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    // Doctor will get assigned in that vaccination center who is having minimum number of doctor
    public Doctor registerDoctor(Doctor obj) {
        List<VaccinationCenter> vaccinationCenterList = vaccinationCenterService.getMinDoctorCountInVC();
        VaccinationCenter vaccinationCenter = vaccinationCenterList.get(0);
        obj.setVaccinationCenter(vaccinationCenter);
        vaccinationCenterService.updateCountByOne(vaccinationCenter);
        doctorRepository.save(obj);
        return obj;
    }

    public List<Doctor> getMinimumDoctorOnTheBasisOfVC(UUID vcid) {
        return doctorRepository.getMinimumDoctorOnTheBasisOfVC(vcid);
    }
}
