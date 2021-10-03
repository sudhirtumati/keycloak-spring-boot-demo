package com.sample.security.webapp.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeCreateRequest {

    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;
    @Past
    private LocalDate dateOfBirth;
}
