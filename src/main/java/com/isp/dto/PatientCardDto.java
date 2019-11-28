package com.isp.dto;

public class PatientCardDto {

    private Request request;
    private Card card;

    public PatientCardDto(final Request request, final Card card) {
        this.card = card;
        this.request = request;
    }
}
