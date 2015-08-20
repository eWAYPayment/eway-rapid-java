package com.eway.payment.rapid.sdk.entities;

import org.codehaus.jackson.annotate.JsonProperty;

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
