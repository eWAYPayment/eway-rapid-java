package com.eway.payment.rapid.sdk.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CancelAuthorisationRequest extends Request {

    @JsonProperty("TransactionId")
    public String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
