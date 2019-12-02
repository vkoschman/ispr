package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Observation {
    private String title; // Дублирует ключ из Map. Например, "Risk Evaluation, Document: Sexually Transmitted Infection"
    private String observedAtTime; // Дата наблюдения
}