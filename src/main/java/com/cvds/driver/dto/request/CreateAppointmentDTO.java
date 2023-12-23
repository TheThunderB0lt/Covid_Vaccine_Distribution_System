package com.cvds.driver.dto.request;

import com.cvds.driver.enums.VaccinationCenterPreference;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CreateAppointmentDTO {
    UUID id;
    VaccinationCenterPreference vaccinationCenterPreference;
}
