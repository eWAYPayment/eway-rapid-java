package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.internal.Payment;
import org.codehaus.jackson.annotate.JsonProperty;

public class CapturePaymentRequest extends Request {

    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("Payment")
    public Payment payment;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
