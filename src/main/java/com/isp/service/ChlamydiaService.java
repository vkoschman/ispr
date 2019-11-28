package com.isp.service;

import com.isp.dto.Request;

public interface ChlamydiaService {

    boolean checkPresenceOfFields(Request request);

    //TODO: make type more specific, as implemented
    Object makeDecision(Request request);
}
