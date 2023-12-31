package com.Microservices.CitizenService.Repository;

import com.Microservices.CitizenService.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,Integer> {
    public List<Citizen> findByVaccinationCenterId(int id);
}
