package com.isp.service;

import com.isp.dto.ChlamydiaPatient;
import com.isp.dto.Questionnaire;
import com.isp.dto.QuestionnaireResponse;
import com.isp.dto.Request;

public interface CheckFieldsPatientService {
    Questionnaire checkFields(ChlamydiaPatient chlamydiaPatient, QuestionnaireResponse qr);
}
