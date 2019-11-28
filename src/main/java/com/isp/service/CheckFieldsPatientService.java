package com.isp.service;

import com.isp.dto.Patient;
import com.isp.dto.Questionnaire;

public interface CheckFieldsPatientService {
    Questionnaire checkFields(Patient patient);
}
