package com.isp.service;

import com.isp.dto.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.IntStream;


@Service
public class CheckFieldsPatientServiceImpl implements CheckFieldsPatientService {
    private static Map<Integer, String> stringMap= new HashMap<>();
    static{
        stringMap.put(0, "gender");
        stringMap.put(1, "birthDate");
        stringMap.put(2, "conditions");
        stringMap.put(3, "observations");
        stringMap.put(4, "diagnosticReports");
        stringMap.put(5, "diagnosticOrders");
        stringMap.put(6, "medicationPrescriptions");
        stringMap.put(7, "medicationTreatments");
    }

    @SneakyThrows
    public Optional<Questionnaire> checkFields(ChlamydiaPatient chlamydiaPatient, QuestionnaireResponse qr) {
        String gender = chlamydiaPatient.getGender();
        String birthDate = chlamydiaPatient.getBirthDate();
        Condition conditions = chlamydiaPatient.getConditions();
        Observation observations = chlamydiaPatient.getObservations();
        DiagnosticReport diagnosticReports = chlamydiaPatient.getDiagnosticReports();
        DiagnosticOrder diagnosticOrders = chlamydiaPatient.getDiagnosticOrders();
        MedicationPrescription medicationPrescriptions = chlamydiaPatient.getMedicationPrescriptions();
        MedicationTreatment medicationTreatments = chlamydiaPatient.getMedicationTreatments();

        if (Objects.isNull(gender)) {
            if (qr != null && qr.item.get(0) != null) {
                Field field = chlamydiaPatient.getClass().getDeclaredField(stringMap.get(0));
                field.setAccessible(true);
                field.set(chlamydiaPatient, qr.item.get(0).getAnswer().get(0));
            }else {
                return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(0).get(0),
                        Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(0).get(0),
                                ChlamydiaPatient.questionsMap.get(0).get(1)))));
            }
        }

        if (Objects.isNull(birthDate)) {
            if (qr != null && qr.item.get(0) != null) {
                Field field = chlamydiaPatient.getClass().getDeclaredField(stringMap.get(1));
                field.setAccessible(true);
                field.set(chlamydiaPatient, qr.item.get(0).getAnswer().get(0));
            }else {
                return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(1).get(0),
                        Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(1).get(0),
                                ChlamydiaPatient.questionsMap.get(1).get(1)))));
            }
        }

        if (Objects.isNull(conditions)) {
            if (qr != null && qr.item.get(0) != null) {
                Field field = chlamydiaPatient.getClass().getDeclaredField(stringMap.get(2));
                field.setAccessible(true);
                field.set(chlamydiaPatient.getConditions(), qr.item.get(0).getAnswer().stream().filter(Objects::nonNull).findFirst().get());
            }else {
                return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(2).get(0),
                        Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(2).get(0),
                                ChlamydiaPatient.questionsMap.get(2).get(1)))));
            }
        }

//        if (Objects.isNull(observations)) {
//            if (qr != null && qr.item.get(0) != null) {
//                Field field = chlamydiaPatient.getClass().getDeclaredField(stringMap.get(0));
//                field.setAccessible(true);
//                field.set(chlamydiaPatient, qr.item.get(0).getAnswer().get(0));
//            }else {
//                return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(0).get(0),
//                        Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(0).get(0),
//                                ChlamydiaPatient.questionsMap.get(0).get(1)))));
//            }
//        }

//        for (int i = 0; i < rawTypesAreSoBadIknow.size(); i++) {
//            if (Objects.isNull(rawTypesAreSoBadIknow.get(i))) {
//                if (qr != null && qr.item.get(0) != null) {
//                    declaredFields[i].setAccessible(true);
//                    try {
//                        declaredFields[i].set(, qr.item.get(0).getAnswer().get(0));
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(i).get(0),
//                            Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(i).get(0),
//                                    ChlamydiaPatient.questionsMap.get(i).get(1)))));
//                }
//            }
//        }
        return Optional.empty();
    }
}
