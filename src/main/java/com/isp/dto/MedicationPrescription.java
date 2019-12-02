package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicationPrescription {
    private String title;
    private String reason; // Причина назначения
    private String orderedAtTime; // Начало назначения
}