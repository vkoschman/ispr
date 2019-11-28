package com.isp.dto;

public class PatientCardDto {

    private Request request;
    private Card card;

    public PatientCardDto(final Request request, final Card card) {
        this.card = card;
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
