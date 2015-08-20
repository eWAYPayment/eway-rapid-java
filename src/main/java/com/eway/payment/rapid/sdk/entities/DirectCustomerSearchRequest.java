package com.eway.payment.rapid.sdk.entities;

import org.codehaus.jackson.annotate.JsonProperty;

public class DirectCustomerSearchRequest extends Request {

    @JsonProperty("TokenCustomerID")
    private String tokenCustomerID;

    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }
}
