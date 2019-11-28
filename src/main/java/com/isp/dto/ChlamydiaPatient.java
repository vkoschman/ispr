package com.isp.dto;

public class ChlamydiaPatient extends Patient{
    private String id;
    private String gender;
    private int ageInYears;

    //TODO: Has to be changed from Strings and int to classes and Maps!!!
    public int pregnancy = -1; // Test field
    int sexuallyActive;
    String condition;
    String observation;
    String diagnosticOrder;
    String procedure;
    String medicationPrescription;
    String medicationTreatment;

    public ChlamydiaPatient(String gender, String birthDate, String id){
        super(gender, birthDate, id);
    }

}