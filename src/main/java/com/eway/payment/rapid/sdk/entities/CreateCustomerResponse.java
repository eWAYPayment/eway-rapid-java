package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.output.ResponseOutput;

/**
 * The response from creating a customer
 */
public class CreateCustomerResponse extends ResponseOutput {

    private Customer customer;
    private String sharedPaymentUrl;
    private String formActionUrl;
    private String accessCode;

    /**
     * Get the Customer created by the method call. This will echo back the
     * properties of the Customer adding the TokenCustomerID for the created
     * customer
     *
     * @return The customer's information
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the customer's information
     *
     * @param customer Customer information
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * URL to the Responsive Shared Page that the cardholder's browser should be
     * redirected to to capture the card to save with the new customer
     *
     * @return : URL to the Responsive Shared Page
     */
    public String getSharedPaymentUrl() {
        return sharedPaymentUrl;
    }

    /**
     * Set shared payment URL
     *
     * @param sharedPaymentUrl Shared payment URL
     */
    public void setSharedPaymentUrl(String sharedPaymentUrl) {
        this.sharedPaymentUrl = sharedPaymentUrl;
    }

    /**
     * URL That the merchant's credit card collection form should post to to
     * capture the card to be saved with the new customer
     *
     * @return URL That the merchant's credit card collection
     */
    public String getFormActionUrl() {
        return formActionUrl;
    }

    /**
     * Set form action URL
     *
     * @param formActionUrl Form action URL
     */
    public void setFormActionUrl(String formActionUrl) {
        this.formActionUrl = formActionUrl;
    }

    /**
     * The AccessCode for this transaction (can be used with the customer query
     * method call for searching before and after the card capture is completed)
     *
     * @return The AccessCode for this transaction
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * Set the access code for this transaction
     *
     * @param accessCode Access code
     */
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}
