package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.Verification;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The response from completing a direct payment
 */
public class DirectPaymentResponse extends Response {

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

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("BeagleScore")
    private Double beagleScore;

    @JsonProperty("Errors")
    private String errors;

    @JsonProperty("TransactionCaptured")
    private String transactionCaptured;

    @JsonProperty("FraudAction")
    private String fraudAction;

    @JsonProperty("Verification")
    private Verification verification;

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("Payment")
    private Payment payment;

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
     * The type of transaction
     * 
     * @return Transaction Type
     */
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Fraud score representing the estimated probability that the order is fraud, 
     * based off analysis of past Beagle Fraud Alerts transactions.
     * 
     * @return The Beagle Fraud score
     */
    public Double getBeagleScore() {
        return beagleScore;
    }

    public void setBeagleScore(Double beagleScore) {
        this.beagleScore = beagleScore;
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

    /**
     * Returns the capture status
     * 
     * @return The transaction captured status
     */
    public String getTransactionCaptured() {
        return transactionCaptured;
    }

    public void setTransactionCaptured(String transactionCaptured) {
        this.transactionCaptured = transactionCaptured;
    }

    /**
     * The Beagle fraud action taken
     * 
     * @return The Beagle Fraud action
     */
    public String getFraudAction() {
        return fraudAction;
    }

    public void setFraudAction(String fraudAction) {
        this.fraudAction = fraudAction;
    }

    /** 
     * Get the verification details for the transaction
     * 
     * @return Transaction verification details
     */
    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
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
     * The payment details of the transaction (such as amount and currency)
     * 
     * @return Payment details
     */
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
