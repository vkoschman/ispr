package com.isp.service;

import com.isp.dto.Request;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChlamydiaServiceImpl implements ChlamydiaService {

    //TODO: проверка "ну такое": говорит, что инфы больше не нужно в том случае,
    // если все поля заполнены уже приходят
    @Override
    public boolean checkPresenceOfFields(Request request) {
        boolean allPresent = request.getPrefetch().getQuestionnaireResponse().item.stream()
                .allMatch(answerItem -> Objects.nonNull(answerItem.getAnswer()) &&
                        Objects.nonNull(answerItem.getLinkId()) &&
                        Objects.nonNull(answerItem.getText()));
        return allPresent;
    }

    //TODO: implement decision-making logic
    @Override
    public Object makeDecision(Request request) {
        return null;
    }
}
