package com.eway.payment.rapid.sdk.beans.internal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Option {

    @JsonProperty("Value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
