package com.cvds.driver.dto.request;

import com.cvds.driver.enums.VaccinationCenterPreference;

import java.util.UUID;

public class CreateAppointmentDTO {
    UUID id;
    VaccinationCenterPreference vaccinationCenterPreference;

    public CreateAppointmentDTO() {
    }

    public CreateAppointmentDTO(UUID id, VaccinationCenterPreference vaccinationCenterPreference) {
        this.id = id;
        this.vaccinationCenterPreference = vaccinationCenterPreference;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public VaccinationCenterPreference getVaccinationCenterPreference() {
        return vaccinationCenterPreference;
    }

    public void setVaccinationCenterPreference(VaccinationCenterPreference vaccinationCenterPreference) {
        this.vaccinationCenterPreference = vaccinationCenterPreference;
    }

    @Override
    public String toString() {
        return "CreateAppointmentDTO{" +
                "id=" + id +
                ", vaccinationCenterPreference=" + vaccinationCenterPreference +
                '}';
    }
}
