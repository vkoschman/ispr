package com.isp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ChlamydiaPatient extends Patient {
    private Boolean sexuallyActive;

    private Condition conditions;
    private Observation observations;
    private MedicationTreatment medicationTreatments;
    private MedicationPrescription medicationPrescriptions;
    private DiagnosticOrder diagnosticOrders;
    private DiagnosticReport diagnosticReports;
    private String procedure;

    public static Map<Integer, List<String>> questionsMap = new HashMap<>();

    static {
        questionsMap.put(0, Arrays.asList("What is the patient's gender?", "string"));
        questionsMap.put(1, Arrays.asList("What is the patient's age?", "integer"));
        questionsMap.put(2, Arrays.asList("Is the patient sexually active?", "boolean"));
        questionsMap.put(3, Arrays.asList("Did the patient take a Chlamydia Screening test?", "boolean"));
        questionsMap.put(4, Arrays.asList("When did the patient take the Chlamydia Screening test?", "string"));
        questionsMap.put(5, Arrays.asList("What was the result of patient's Chlamydia Screening test?", "string"));
        questionsMap.put(6, Arrays.asList("Was the patient observed for sexually transmitted infection", "boolean"));
        questionsMap.put(7, Arrays.asList("When was the patient observed for sexually transmitted infection", "string"));
    }

    public ChlamydiaPatient(String gender, String birthDate, String id) {
        super(gender, birthDate, id);
    }
}