package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from creating a transaction using the Responsive Shared Page. Use
 * the SharedPaymentUrl to send the customer to the Shared Page to complete the
 * transaction.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccessCodeSharedResponse extends Response {

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("Payment")
    private Payment payment;

    @JsonProperty("AccessCode")
    private String accessCode;

    @JsonProperty("FormActionURL")
    private String formActionURL;

    @JsonProperty("Errors")
    private String errors;

    @JsonProperty("SharedPaymentUrl")
    private String sharedPaymentUrl;

    @JsonProperty("CompleteCheckoutURL")
    private String completeCheckoutURL;

    /**
     * The customer details for the transaction
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
     * Fetch the payment details (such as amount, currency and invoice details)
     *
     * @return Payment details
     */
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Get the Access Code - this is used to query the result.
     *
     * @return The Access Code
     */
    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    /**
     * This is unused with the Responsive Shared Page.
     *
     * @return The Form Action URL
     */
    public String getFormActionURL() {
        return formActionURL;
    }

    public void setFormActionURL(String formActionURL) {
        this.formActionURL = formActionURL;
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
     * This is the URL to redirect the customer to to complete the transaction.
     *
     * @return The Shares Page URL
     */
    public String getSharedPaymentUrl() {
        return sharedPaymentUrl;
    }

    public void setSharedPaymentUrl(String sharedPaymentUrl) {
        this.sharedPaymentUrl = sharedPaymentUrl;
    }

    /**
     * Get the PayPal Checkout URL
     *
     * @return The PayPal Checkout URL
     */
    public String getCompleteCheckoutURL() {
        return completeCheckoutURL;
    }

    public void setCompleteCheckoutURL(String completeCheckoutURL) {
        this.completeCheckoutURL = completeCheckoutURL;
    }

}
