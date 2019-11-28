package com.isp.service;

import com.isp.dto.Request;
import com.isp.dto.Card;
import com.isp.dto.ChlamydiaPatient;

public interface ChlamydiaService {

    boolean checkPresenceOfFields(Request request);

    //TODO: make type more specific, as implemented
    Card makeDecision(ChlamydiaPatient request);
}
