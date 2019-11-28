package com.isp.dto;

import java.util.Map;

public class ChlamydiaPatient extends Patient{
    private String id;
    private String gender;
    private int ageInYears;
    private int sexuallyActive = -1;

    //TODO: Has to remove pregnancy!!!
    public int pregnancy = -1; // Test field

    private Map<String, Condition> conditions;
    private Map<String, Observation> observations;
    private Map<String, MedicationTreatment> medicationTreatments;
    private Map<String, MedicationPrescription> medicationPrescriptions;
    private Map<String, DiagnosticOrder> diagnosticOrders;
    private Map<String, DiagnosticReport> diagnosticReports;
    private String procedure;

    public ChlamydiaPatient(String gender, String birthDate, String id){
        super(gender, birthDate, id);
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public int getSexuallyActive() {
        return sexuallyActive;
    }

    public Map<String, Observation> getObservations() {
        return observations;
    }

    public Map<String, DiagnosticReport> getDiagnosticReports() {
        return diagnosticReports;
    }
}