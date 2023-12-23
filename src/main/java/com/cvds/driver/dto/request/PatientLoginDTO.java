package com.cvds.driver.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PatientLoginDTO {
    String email;
    String password;
}
