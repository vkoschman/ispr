package com.isp.service;

import com.isp.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckFieldsPatientServiceImpl implements CheckFieldsPatientService {

    List<Item>

    String genderQuestion = "What is the patient's gender?";
    String genderType = "string";
    String ageQuestion = "What is the patient's age?";
    String ageType = "integer";
    String sexualActiveQuestion = "Is the patient sexually active?";
    String sexualActiveType = "boolean";
    String chlamydiaTestData = "Laboratory Test, Result: Chlamydia Screening";

    String chlamydiaTestQuestion = "Did the patient take a Chlamydia Screening test?";
    String chlamydiaTestType = "boolean";

    String chlamydiaTestDateQuestion = "When did the patient take the Chlamydia Screening test?";
    String chlamydiaTestDateType = "string";
    String chlamydiaTestResultQuestion = "What was the result of patient's Chlamydia Screening test?";
    String chlamydiaTestResultType = "string";
    String sexuallyTransmittedInfectionData = "Risk Evaluation, Document: Sexually Transmitted Infection";

    String sexuallyTransmittedInfectionQuestion = "Was the patient observed for sexually transmitted infection";
    String sexuallyTransmittedInfectionType = "boolean";

    String sexuallyTransmittedInfectionDateQuestion = "When was the patient observed for sexually transmitted infection";
    String sexuallyTransmittedInfectionDateType = "string";

    public Questionnaire checkFields(ChlamydiaPatient chlamydiaPatient, QuestionnaireResponse qr) {
        return null;
    }

}
