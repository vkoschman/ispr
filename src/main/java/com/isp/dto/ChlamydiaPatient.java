package com.isp.dto;

import java.util.HashMap;

public class ChlamydiaPatient extends Patient{
    private String id;
    private String gender;
    private int ageInYears;
    private int sexuallyActive = -1;

    //TODO: Has to remove pregnancy!!!
    public int pregnancy = -1; // Test field

    private HashMap<String, Condition> conditions;
    private HashMap<String, Observation> observations;
    private HashMap<String, MedicationTreatment> medicationTreatments;
    private HashMap<String, MedicationPrescription> medicationPrescriptions;
    private HashMap<String, DiagnosticOrder> diagnosticOrders;
    private HashMap<String, DiagnosticReport> diagnosticReports;
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

    public HashMap<String, Observation> getObservations() {
        return observations;
    }

    public HashMap<String, DiagnosticReport> getDiagnosticReports() {
        return diagnosticReports;
    }
}