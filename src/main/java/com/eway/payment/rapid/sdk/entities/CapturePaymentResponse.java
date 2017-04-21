package com.eway.payment.rapid.sdk.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object from capturing a payment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CapturePaymentResponse extends Response {

    @JsonProperty("ResponseCode")
    private String responseCode;
    
    @JsonProperty("ResponseMessage")
    private String responseMessage;
    
    @JsonProperty("TransactionID")
    private String transactionID;
    
    @JsonProperty("TransactionStatus")
    private Boolean transactionStatus;
    
    @JsonProperty("Errors")
    private String errors;

    /**
     * The response code from the bank/gateway
     * 
     * @return The response code
     */
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Get the Response messages from the transaction.
     * These can be translated using RapidSDK.userDisplayMessage()
     * 
     * @return The response message(s)
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * The eWAY Transaction ID
     * 
     * @return The eWAY Transaction ID
     */
    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * Whether the transaction succeeded or not
     * 
     * @return The transaction status
     */
    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * Any errors that occurred processing the transaction
     * 
     * @return Errors
     */
    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
