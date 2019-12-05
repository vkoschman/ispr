package com.isp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Answer {
    private boolean valueBoolean;
    private String valueString;

    public Answer(boolean valueBoolean){
        this.valueBoolean = valueBoolean;
    }
}
