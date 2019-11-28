package com.isp.service;

import com.isp.dto.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.IntStream;


@Service
public class CheckFieldsPatientServiceImpl implements CheckFieldsPatientService {

    public Optional<Questionnaire> checkFields(ChlamydiaPatient chlamydiaPatient, QuestionnaireResponse qr) {
        String gender = chlamydiaPatient.getGender();
        String birthDate = chlamydiaPatient.getBirthDate();
        Map<String, Condition> conditions = chlamydiaPatient.getConditions();
        Map<String, Observation> observations = chlamydiaPatient.getObservations();
        Map<String, DiagnosticReport> diagnosticReports = chlamydiaPatient.getDiagnosticReports();
        Map<String, DiagnosticOrder> diagnosticOrders = chlamydiaPatient.getDiagnosticOrders();
        Map<String, MedicationPrescription> medicationPrescriptions = chlamydiaPatient.getMedicationPrescriptions();
        Map<String, MedicationTreatment> medicationTreatments = chlamydiaPatient.getMedicationTreatments();
        List rawTypesAreSoBadIknow = new ArrayList();
        Field[] declaredFields = ChlamydiaPatient.class.getDeclaredFields();

        rawTypesAreSoBadIknow.add(gender);
        rawTypesAreSoBadIknow.add(birthDate);
        rawTypesAreSoBadIknow.add(conditions);
        rawTypesAreSoBadIknow.add(observations);
        rawTypesAreSoBadIknow.add(diagnosticReports);
        rawTypesAreSoBadIknow.add(diagnosticOrders);
        rawTypesAreSoBadIknow.add(medicationPrescriptions);
        rawTypesAreSoBadIknow.add(medicationTreatments);
        for (int i = 0; i < rawTypesAreSoBadIknow.size(); i++) {
            if (Objects.isNull(rawTypesAreSoBadIknow.get(i))) {
                if (qr != null && qr.item.get(0) != null) {
                    declaredFields[i].setAccessible(true);
                    try {
                        declaredFields[i].set(chlamydiaPatient, qr.item.get(0).getAnswer().get(0));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return Optional.of(new Questionnaire(ChlamydiaPatient.questionsMap.get(i).get(0),
                            Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(i).get(0),
                                    ChlamydiaPatient.questionsMap.get(i).get(1)))));
                }
            }
        }
        return Optional.empty();
    }
}
