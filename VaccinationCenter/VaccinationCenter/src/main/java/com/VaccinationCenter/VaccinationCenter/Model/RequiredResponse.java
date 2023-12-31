package com.VaccinationCenter.VaccinationCenter.Model;

import com.VaccinationCenter.VaccinationCenter.Entity.vaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
    private vaccinationCenter center;
    private List<Citizen> citizens;
}
