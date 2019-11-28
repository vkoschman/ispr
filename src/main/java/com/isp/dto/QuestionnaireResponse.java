package com.isp.dto;

import java.util.Date;
import java.util.List;

import static com.isp.constants.Endpoints.RESOURCE_TYPE_QUESTIONNAIRE_RESPONSE;
import static com.isp.constants.Endpoints.STATUS_QUESTIONNAIRE_RESPONSE;
import static com.isp.dto.CDSHooksCardsGeneral.stringQuestionnaireId;

public class QuestionnaireResponse {
    public static final String resourceType = RESOURCE_TYPE_QUESTIONNAIRE_RESPONSE;
    public static final String status = STATUS_QUESTIONNAIRE_RESPONSE;
    private String id;
    private Date authored;
    public List<AnswerItem> item;
    //TODO:
    Object[] contained;

    //TODO: а что с title?
    public QuestionnaireResponse(List<AnswerItem> item) {
        this.item = item;
        this.id = stringQuestionnaireId();
    }
}
