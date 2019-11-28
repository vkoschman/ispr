package com.isp.dto;

public class DiagnosticOrder {
    private String title;
    private String orderedAtTime; // Дата назначения

    public DiagnosticOrder(String title, String orderedAtTime) {
        this.title = title;
        this.orderedAtTime = orderedAtTime;
    }

    public String getTitle() {
        return title;
    }

    public String getOrderedAtTime() {
        return orderedAtTime;
    }
}