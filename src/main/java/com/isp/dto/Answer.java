package com.isp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Answer {
    private boolean valueBoolean;
    private String valueString;
    private int valueInteger;

    public Answer(){

    }

    public Answer(boolean valueBoolean){
        this.valueBoolean = valueBoolean;
    }

    public boolean getValueBoolean() {
        return valueBoolean;
    }

    public String getValueString() {
        return valueString;
    }

    public int getvalueInteger() {
        return valueInteger;
    }

    public void setValueBoolean(boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public void setValueInteger(int valueInteger) {
        this.valueInteger = valueInteger;
    }
}
