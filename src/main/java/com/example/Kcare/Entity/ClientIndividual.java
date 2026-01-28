package com.example.Kcare.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_individual")

public class ClientIndividual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String dob;
    private String ssn;
    private String gender;

    @Column(name = "mdm_id")
    private Long mdmId;

    @Column(name = "irn_id")
    private Long irnId;


    @OneToOne(mappedBy = "clientIndividual" )

    private User user;



}

