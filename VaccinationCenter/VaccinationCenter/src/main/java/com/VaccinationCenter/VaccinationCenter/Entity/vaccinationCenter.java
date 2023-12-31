package com.VaccinationCenter.VaccinationCenter.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class vaccinationCenter {
   @Id
    private int id;
    private String centerName;
    private String centerAddress;
    private int vaccinationCenterId;
}
