package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicationTreatment {
    private String title;
    private String performanceTime; // Начало лечения
}