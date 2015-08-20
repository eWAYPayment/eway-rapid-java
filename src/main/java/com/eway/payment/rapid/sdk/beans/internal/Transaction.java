package com.eway.payment.rapid.sdk.beans.internal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Transaction {

    @JsonProperty("CustomerNote")
    private String customerNote;

    @JsonProperty("AuthorisationCode")
    private String authorisationCode;

    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("ResponseMessage")
    private String responseMessage;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("InvoiceReference")
    private String invoiceReference;

    @JsonProperty("TotalAmount")
    private int totalAmount;

    @JsonProperty("TransactionID")
    private String transactionID;

    @JsonProperty("TransactionStatus")
    private Boolean transactionStatus;

    @JsonProperty("TokenCustomerID")
    private String tokenCustomerID;

    @JsonProperty("BeagleScore")
    private Double beagleScore;

    @JsonProperty("Options")
    private Option[] options = new Option[0];

    @JsonProperty("Verification")
    private Verification verification;

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

    @JsonProperty("BeagleVerification")
    private BeagleVerification beagleVerification;

    @JsonProperty("errors")
    private String errors;

    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public String getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BeagleVerification getBeagleVerification() {
        return beagleVerification;
    }

    public void setBeagleVerification(BeagleVerification beagleVerification) {
        this.beagleVerification = beagleVerification;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Double getBeagleScore() {
        return beagleScore;
    }

    public void setBeagleScore(Double beagleScore) {
        this.beagleScore = beagleScore;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

}
