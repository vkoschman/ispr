package com.isp.dto;

import java.util.Map;

public class ChlamydiaPatient extends Patient{
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

    public int getSexuallyActive() {
        return sexuallyActive;
    }

    public Map<String, Observation> getObservations() {
        return observations;
    }

    public Map<String, DiagnosticReport> getDiagnosticReports() {
        return diagnosticReports;
    }

    public Map<String, Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, Condition> conditions) {
        this.conditions = conditions;
    }

    public void setObservations(Map<String, Observation> observations) {
        this.observations = observations;
    }

    public Map<String, MedicationTreatment> getMedicationTreatments() {
        return medicationTreatments;
    }

    public void setMedicationTreatments(Map<String, MedicationTreatment> medicationTreatments) {
        this.medicationTreatments = medicationTreatments;
    }

    public Map<String, MedicationPrescription> getMedicationPrescriptions() {
        return medicationPrescriptions;
    }

    public void setMedicationPrescriptions(Map<String, MedicationPrescription> medicationPrescriptions) {
        this.medicationPrescriptions = medicationPrescriptions;
    }

    public Map<String, DiagnosticOrder> getDiagnosticOrders() {
        return diagnosticOrders;
    }

    public void setDiagnosticOrders(Map<String, DiagnosticOrder> diagnosticOrders) {
        this.diagnosticOrders = diagnosticOrders;
    }

    public void setDiagnosticReports(Map<String, DiagnosticReport> diagnosticReports) {
        this.diagnosticReports = diagnosticReports;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}