package com.isp.dto;

import static com.isp.dto.CDSHooksCardsGeneral.stringLinkId;

public class Item {
    private String linkId;
    private String text;
    private String type;

    public Item(String text, String type) {
        this.linkId = stringLinkId();
        this.text = text;
        this.type = type;
    }

    public String getLinkId() {
        return linkId;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }
}
