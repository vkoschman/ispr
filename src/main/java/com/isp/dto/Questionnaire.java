package com.isp.dto;

import java.util.List;

import static com.isp.constants.Endpoints.RESOURCE_TYPE_QUESTIONNAIRE;
import static com.isp.constants.Endpoints.STATUS_QUESTIONNAIRE;

public class Questionnaire {
    public static final String resourceType = RESOURCE_TYPE_QUESTIONNAIRE;
    public static final String status = STATUS_QUESTIONNAIRE;
    private String id;
    private String title;
    private List<Item> item;
    //TODO:
    Object[] contained;

    public Questionnaire(String title, List<Item> item) {
        this.title = title;
        this.item = item;
        this.id = CDSHooksCardsGeneral.stringQuestionnaireId();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Item> getItem() {
        return item;
    }
}
