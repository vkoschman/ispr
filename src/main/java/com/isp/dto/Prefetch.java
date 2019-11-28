package com.isp.dto;

import lombok.Setter;

@Setter
public class Prefetch {
    private Patient patient;
    private Questionnaire questionnaire;
    private QuestionnaireResponse questionnaireResponse;

    public Prefetch(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Prefetch(Patient patient, Questionnaire questionnaire) {
        this.patient = patient;
        this.questionnaire = questionnaire;
    }

    public Patient getPatient() {
        return patient;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public QuestionnaireResponse getQuestionnaireResponse() {
        return questionnaireResponse;
    }
}