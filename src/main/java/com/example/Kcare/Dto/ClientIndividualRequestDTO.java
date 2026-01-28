package com.example.Kcare.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientIndividualRequestDTO {

    @NotBlank(message = "Name should not be blank")
    private String firstName;
    @NotBlank(message = "Name should not be blank")
    private String lastName;
    @Past(message = "Invalid dob, enter valid dob")
    private String dob;
    private String ssn;
    private String gender;
//    private Long mdmId;
//    private Long irnId;


}
