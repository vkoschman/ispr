package com.isp.dto;

import java.util.Collections;
import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public static Cards cardsResponse(String summary, String detail) {
        return new Cards(Collections.singletonList(new Card(summary, detail)));
    }
}
