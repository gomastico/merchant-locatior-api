package com.qless.challenge.merchantlocatorapi.model;


public enum SourceDataType {

    location("location"), merchant("merchant");

    private String value;

    SourceDataType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
