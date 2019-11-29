package com.isp.dto;

import java.util.Date;
import java.util.List;

import static com.isp.dto.CDSHooksCardsGeneral.stringQuestionnaireId;

public class QuestionnaireResponse {
    private String resourceType;
    private String status;
    private String id;
    private String questionnaire;
    private Date authored;
    public List<AnswerItem> item;

    public QuestionnaireResponse(){

    }

    public QuestionnaireResponse(List<AnswerItem> item) {
        this.item = item;
        this.id = stringQuestionnaireId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAuthored() {
        return authored;
    }

    public void setAuthored(Date authored) {
        this.authored = authored;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }
}
