package com.isp.controller;

import com.isp.constants.ApiConstant;
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

    @GetMapping(value = "/requestPatient")
    @ApiOperation(value = "Get patient's details and return ")
    public ResponseEntity<Request> getQuestions(@ApiParam(value = "Request form containing info about patient", required = true)
                            @RequestBody final Request request) {
        if (chlamydiaService.checkPresenceOfFields(request)){
            // all necessary fields are present and decision can be made
            Object decision = chlamydiaService.makeDecision(request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Request()); // когда инфы достаточно отправляем назад пустой json - решение приняли, от них ничего не надо
        }else{
            // not enough info, return request back with question
            // TODO: как и где заполняются поля вопроса?
            //TODO: засеттить и отправлять
            return ResponseEntity.status(HttpStatus.OK)
                    .body(request);
        }
    }
}