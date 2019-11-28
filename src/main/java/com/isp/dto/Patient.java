package com.isp.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static com.isp.constants.Endpoints.PATIENT_RESOURCE_TYPE;

public class Patient {
    public static final String resourceType = PATIENT_RESOURCE_TYPE;
    private static boolean active = true;
    private String gender;
    private String birthDate;
    private String id;

    public Patient(String gender, String birthDate, String id) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
    }

    public int age() {
        return Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()).getYears();
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getId() {
        return id;
    }
}
