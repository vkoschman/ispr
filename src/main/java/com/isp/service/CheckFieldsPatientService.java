package com.isp.service;

import com.isp.dto.Questionnaire;
import com.isp.dto.Request;

public interface CheckFieldsPatientService {
    Questionnaire checkFields(Request request);
}
