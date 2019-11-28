package com.isp.dto;

import java.util.ArrayList;
import java.util.List;

public class AnswerItem {
    private String linkId;
    private String text;
    private List<Answer> answer;

    public AnswerItem(String question, Answer answer) {
        this.linkId = CDSHooksCardsGeneral.stringLinkId();
        this.text = question;
        this.answer = new ArrayList<>();
        this.answer.add(answer);
    }

    public String getLinkId() {
        return linkId;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswer() {
        return answer;
    }
}
