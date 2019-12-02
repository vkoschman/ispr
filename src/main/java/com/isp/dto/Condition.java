package com.isp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Condition {
    private String title;
    private String effectiveTime; // Дата постановки состояния

    public Condition(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}