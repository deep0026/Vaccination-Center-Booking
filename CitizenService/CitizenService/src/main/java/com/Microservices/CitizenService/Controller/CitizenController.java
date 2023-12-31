package com.Microservices.CitizenService.Controller;

import com.Microservices.CitizenService.Entity.Citizen;
import com.Microservices.CitizenService.Entity.listVaccintionCenters;
import com.Microservices.CitizenService.Entity.vaccinationCenter;
import com.Microservices.CitizenService.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    listVaccintionCenters centers;
    @Autowired
    public CitizenRepository repo;
    @Autowired
    public RestTemplate restTemplate;
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id){

        List<Citizen> byVaccinationCenterId = repo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(byVaccinationCenterId, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Citizen citizen) {
        if (citizen.getVaccinationCenterId() == 1 || citizen.getVaccinationCenterId() == 2) {
            Citizen save = repo.save(citizen);
            return new ResponseEntity<>(save, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("enter valid", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> getListOfCenters(){
       centers=new listVaccintionCenters();
        List forObject = restTemplate.getForObject("http://localhost:8082/vaccination/list", List.class);
        centers.setId(forObject);
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
