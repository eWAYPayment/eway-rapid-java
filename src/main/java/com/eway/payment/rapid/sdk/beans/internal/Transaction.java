package com.eway.payment.rapid.sdk.beans.internal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("Customer")
    private Customer customer;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

    @JsonProperty("BeagleVerification")
    private BeagleVerification beagleVerification;

    @JsonProperty("errors")
    private String errors;

    @JsonProperty("TransactionDateTime")
    private String transactionDateTime;

    @JsonProperty("FraudAction")
    private String fraudAction;

    @JsonProperty("TransactionCaptured")
    private boolean transactionCaptured;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Source")
    private int source;

    @JsonProperty("MaxRefund")
    private String maxRefund;

    @JsonProperty("OriginalTransactionId")
    private String originalTransactionId;


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

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getFraudAction() {
        return fraudAction;
    }

    public void setFraudAction(String fraudAction) {
        this.fraudAction = fraudAction;
    }

    public boolean getTransactionCaptured() {
        return transactionCaptured;
    }

    public void setTransactionCaptured(boolean transactionCaptured) {
        this.transactionCaptured = transactionCaptured;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getMaxRefund() {
        return maxRefund;
    }

    public void setMaxRefund(String maxRefund) {
        this.maxRefund = maxRefund;
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

}
