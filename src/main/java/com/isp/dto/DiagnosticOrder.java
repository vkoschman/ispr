package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiagnosticOrder {
    private String title;
    private String orderedAtTime; // Дата назначения
}