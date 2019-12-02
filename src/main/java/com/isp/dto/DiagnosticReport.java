package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiagnosticReport {
    private String title;
    private String observedAtTime; // Дата проведения
    private String value; // Результат
}