package com.Microservices.CitizenService.Entity;

import lombok.Data;

import java.util.List;
@Data
public class listVaccintionCenters {
    List<vaccinationCenter> id;
    List<vaccinationCenter> centerName;
    List<vaccinationCenter> centerAddress;
}
