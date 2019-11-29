package com.isp.dto;

import lombok.Setter;

public class Prefetch {
    private Patient patient;
    private Questionnaire questionnaire;
    private QuestionnaireResponse questionnaireResponse;

    public Prefetch(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Prefetch(Patient patient, Questionnaire questionnaire, QuestionnaireResponse questionnaireResponse) {
        this.patient = patient;
        this.questionnaire = questionnaire;
        this.questionnaireResponse = questionnaireResponse;
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

    public void setQuestionnaireResponse(QuestionnaireResponse questionnaireResponse) {
        this.questionnaireResponse = questionnaireResponse;
    }
}