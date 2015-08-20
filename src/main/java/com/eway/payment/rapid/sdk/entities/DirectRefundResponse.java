package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The response from completing a refund
 */
public class DirectRefundResponse extends Response {

    @JsonProperty("AuthorisationCode")
    private String authorisationCode;

    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("ResponseMessage")
    private String responseMessage;

    @JsonProperty("TransactionID")
    private String transactionID;

    @JsonProperty("TransactionStatus")
    private Boolean transactionStatus;

    @JsonProperty("Verification")
    private String verification;

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("Refund")
    private RefundDetails refund;

    @JsonProperty("Errors")
    private String errors;

    /**
     * The bank authorisation code
     * 
     * @return The authorisation code
     */
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    /**
     * The two digit response code returned from the bank
     * 
     * @return The Response Code
     */
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * One or more response messages that describes the result of the action performed.
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
     * @return Transaction ID
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
     * @return Transaction Status
     */
    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /** 
     * Get the verification details for the transaction
     * 
     * @return Transaction verification details
     */
    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    /**
     * Get the Customer details associated with the transaction
     * 
     * @return The customer's details
     */
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * The refund details of the transaction (such as amount and currency)
     * 
     * @return Refund details
     */
    public RefundDetails getRefund() {
        return refund;
    }

    public void setRefund(RefundDetails refund) {
        this.refund = refund;
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
