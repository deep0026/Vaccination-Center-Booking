package com.VaccinationCenter.VaccinationCenter.Controller;

import com.VaccinationCenter.VaccinationCenter.Entity.vaccinationCenter;
import com.VaccinationCenter.VaccinationCenter.Model.RequiredResponse;
import com.VaccinationCenter.VaccinationCenter.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class vaccinationCenterController {
    @Autowired
    private VaccinationRepository repo;
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody vaccinationCenter Vaccination){
        vaccinationCenter save = repo.save(Vaccination);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable int id){
        RequiredResponse requiredResponse=new RequiredResponse();
        vaccinationCenter Center = repo.findById(id).get();
        requiredResponse.setCenter(Center);
        List listOfCitizen = restTemplate.getForObject("http://localhost:8081/test/id/" + id, List.class);
        requiredResponse.setCitizens(listOfCitizen);
        return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getlist(){
        List<vaccinationCenter> all = repo.findAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
}
