package com.isp.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChlamydiaPatient extends Patient {
    private Boolean sexuallyActive;

    private Condition conditions;
    private Observation observations;
    private MedicationTreatment medicationTreatments;
    private MedicationPrescription medicationPrescriptions;
    private DiagnosticOrder diagnosticOrders;
    private DiagnosticReport diagnosticReports;

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

    private String procedure;

    public ChlamydiaPatient(String gender, String birthDate, String id) {
        super(gender, birthDate, id);
    }

    public Boolean getSexuallyActive() {
        return sexuallyActive;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public void setSexuallyActive(Boolean sexuallyActive) {
        this.sexuallyActive = sexuallyActive;
    }

    public Condition getConditions() {
        return conditions;
    }

    public void setConditions(Condition conditions) {
        this.conditions = conditions;
    }

    public Observation getObservations() {
        return observations;
    }

    public void setObservations(Observation observations) {
        this.observations = observations;
    }

    public MedicationTreatment getMedicationTreatments() {
        return medicationTreatments;
    }

    public void setMedicationTreatments(MedicationTreatment medicationTreatments) {
        this.medicationTreatments = medicationTreatments;
    }

    public MedicationPrescription getMedicationPrescriptions() {
        return medicationPrescriptions;
    }

    public void setMedicationPrescriptions(MedicationPrescription medicationPrescriptions) {
        this.medicationPrescriptions = medicationPrescriptions;
    }

    public DiagnosticOrder getDiagnosticOrders() {
        return diagnosticOrders;
    }

    public void setDiagnosticOrders(DiagnosticOrder diagnosticOrders) {
        this.diagnosticOrders = diagnosticOrders;
    }

    public DiagnosticReport getDiagnosticReports() {
        return diagnosticReports;
    }

    public void setDiagnosticReports(DiagnosticReport diagnosticReports) {
        this.diagnosticReports = diagnosticReports;
    }
}