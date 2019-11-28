package com.isp.controller;

import com.isp.constants.ApiConstant;
import com.isp.dto.*;
import com.isp.service.CheckFieldsPatientService;
import com.isp.service.ChlamydiaService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(ApiConstant.API_V_1 + "/chlamydiaTest")
public class ChlamydiaController {

    public Map<String, ChlamydiaPatient> chlamydiaPatientMap = new ConcurrentHashMap<>();
    private final ChlamydiaService chlamydiaService;
    private final CheckFieldsPatientService checkFieldsPatientService;

    @Autowired
    public ChlamydiaController(final ChlamydiaService chlamydiaService, final CheckFieldsPatientService checkFieldsPatientService){
        this.chlamydiaService = chlamydiaService;
        this.checkFieldsPatientService = checkFieldsPatientService;
    }

    @PostMapping(value = "/requestPatient")
    @ApiOperation(value = "Get patient's details and return ")
    public ResponseEntity<PatientCardDto> getQuestions(@ApiParam(value = "Request form containing info about patient", required = true)
                            @RequestBody final Request request) {
        Patient patient = request.getPrefetch().getPatient();
        ChlamydiaPatient chlamydiaPatient = new ChlamydiaPatient(patient.getGender(), patient.getBirthDate(), patient.getId());
        chlamydiaPatientMap.put(patient.getId(), chlamydiaPatient);

        if not chlamydiaPatientMap.get(patient.getId()):
            chlamydiaPatientMap.update(patient)

        Questionnaire questionnaire = checkFieldsPatientService.checkFields(chlamydiaPatientMap.get(patient.getId()), request.getPrefetch().getQuestionnaireResponse());


        // added condition on returtn card !!! defined type!!!!




        Card decision = chlamydiaService.makeDecision(chlamydiaPatient);
        PatientCardDto patientCardDto = new PatientCardDto(request, decision);
        return ResponseEntity.status(HttpStatus.OK)
                .body(patientCardDto);
    }
}