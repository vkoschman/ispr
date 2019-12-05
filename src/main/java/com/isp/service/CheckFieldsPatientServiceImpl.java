package com.isp.service;

import com.isp.dto.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CheckFieldsPatientServiceImpl implements CheckFieldsPatientService {
    @SneakyThrows
    public Optional<Questionnaire> checkFields(ChlamydiaPatient chlamydiaPatient, QuestionnaireResponse qr) {

        boolean isChosen = false; // TODO not first, search by id in questionaryResponseItems
        chlamydiaPatient.fieldsToArray();
        List<Object> listFields = chlamydiaPatient.getFields();

        for (int i= 0; i < listFields.size(); i++) {
            if (Objects.isNull(listFields.get(i))) {
                if (qr != null && qr.item.get(0) != null && !isChosen) { // TODO get first item
                    Answer answer = qr.item.get(0).getAnswer().get(0);

                    if (Objects.nonNull(answer.getValueString())) {
                        listFields.set(i, answer);
                    } else {
                        if (Objects.nonNull(answer.getValueBoolean())) {
                            listFields.set(i, answer);
                        } else {
                            throw new IllegalArgumentException("Answer must not be null");
                        }
                    }
                    isChosen = true;
                } else {
                    return Optional.of(new Questionnaire("fields ".concat(String.valueOf(i)), // TODO name of fields
                            Collections.singletonList(new Item(ChlamydiaPatient.questionsMap.get(i).get(0),
                                    ChlamydiaPatient.questionsMap.get(i).get(1)))));
                }
            }
        }

        return Optional.empty();
    }
}
