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

@RestController
@RequestMapping(ApiConstant.API_V_1 + "/chlamydiaTest")
public class ChlamydiaController {

    private final ChlamydiaService chlamydiaService;
    private final CheckFieldsPatientService checkFieldsPatientService;

    @Autowired
    public ChlamydiaController(final ChlamydiaService chlamydiaService, final CheckFieldsPatientService checkFieldsPatientService){
        this.chlamydiaService = chlamydiaService;
        this.checkFieldsPatientService = checkFieldsPatientService;
    }

    @PostMapping(value = "/requestPatient")
    @ApiOperation(value = "Get patient's details and return ")
    public ResponseEntity<Request> getQuestions(@ApiParam(value = "Request form containing info about patient", required = true)
                            @RequestBody final Request request) {
        Patient patient = request.getPrefetch().getPatient();
        Questionnaire obj = checkFieldsPatientService.checkFields(patient);

        // added condition on returtn card !!! defined type!!!!



        ChlamydiaPatient chlamydiaPatient = new ChlamydiaPatient(patient.getGender(), patient.getBirthDate(), patient.getId());
        Card decision = chlamydiaService.makeDecision(chlamydiaPatient);

        return ResponseEntity.status(HttpStatus.OK)
                .body(request);
    }
}