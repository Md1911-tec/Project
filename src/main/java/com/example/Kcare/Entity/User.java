package com.example.Kcare.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Name should not be blank")
    private String firstName;
    @NotBlank(message = "Name should not be blank")
    private String lastName;
    @Size(max = 10,min = 6,message = "Password must be 6 to 12 characters")
    private String password;
    @Email(message = "Email should not be valid and must be contain email format")
    private String email;
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "please enter valid number")
    private String phone;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Invalid dob, enter valid dob")
    private LocalDate dob;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "client_id")
    @JsonIgnore
    private ClientIndividual clientIndividual;


}
