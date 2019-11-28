package com.isp.controller;

import com.isp.constants.ApiConstant;
import com.isp.dto.Card;
import com.isp.dto.ChlamydiaPatient;
import com.isp.dto.Patient;
import com.isp.dto.Request;
import com.isp.service.ChlamydiaService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

@RestController
@RequestMapping(ApiConstant.API_V_1 + "/chlamydiaTest")
public class ChlamydiaController {

    private final ChlamydiaService chlamydiaService;

    @Autowired
    public ChlamydiaController(final ChlamydiaService chlamydiaService){
        this.chlamydiaService = chlamydiaService;
    }

    @PostMapping(value = "/requestPatient")
    @ApiOperation(value = "Get patient's details and return ")
    public ResponseEntity<Request> getQuestions(@ApiParam(value = "Request form containing info about patient", required = true)
                            @RequestBody final Request request) {
        Patient patient = request.getPrefetch().getPatient();
        ChlamydiaPatient chlamydiaPatient = new ChlamydiaPatient(patient.getGender(), patient.getBirthDate(), patient.getId());
        Card decision = chlamydiaService.makeDecision(chlamydiaPatient);

        return ResponseEntity.status(HttpStatus.OK)
                .body(request);
    }
}