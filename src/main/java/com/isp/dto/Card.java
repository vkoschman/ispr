package com.isp.dto;

import static com.isp.constants.Endpoints.INDICATOR_FOR_CARD;

public class Card {
    public static final String indicator = INDICATOR_FOR_CARD;
    private Object source;
    private String summary;
    private String detail;

    public Card(String summary, String detail) {
        this.summary = summary;
        this.detail = detail;
        this.source = "ChlamydiaScreeningCDS.cql";
    }

    public String getSummary() {
        return summary;
    }

    public String getDetail() {
        return detail;
    }
}
