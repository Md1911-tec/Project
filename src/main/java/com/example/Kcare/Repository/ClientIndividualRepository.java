package com.example.Kcare.Repository;

import com.example.Kcare.Entity.ClientIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientIndividualRepository extends JpaRepository<ClientIndividual, Long> {
}
