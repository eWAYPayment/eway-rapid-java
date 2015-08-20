package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The response from creating an AccessCode for a Transparent Redirect
 * transaction.
 */
public class CreateAccessCodeResponse extends Response {

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

    @JsonProperty("CompleteCheckoutURL")
    private String completeCheckoutURL;

    @JsonProperty("TotalAmount")
    private Integer totalAmount;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("InvoiceDescription")
    private String invoiceDescription;

    @JsonProperty("InvoiceReference")
    private String invoiceReference;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("TokenCustomerID")
    private String tokenCustomerID;

    @JsonProperty("Reference")
    private String reference;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("CompanyName")
    private String companyName;

    @JsonProperty("JobDescription")
    private String jobDescription;

    @JsonProperty("Street1")
    private String street1;

    @JsonProperty("Street2")
    private String street2;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("Mobile")
    private String mobile;

    @JsonProperty("Comments")
    private String comments;

    @JsonProperty("Fax")
    private String fax;

    @JsonProperty("Url")
    private String url;

    @JsonProperty("CardNumber")
    private String cardNumber;

    @JsonProperty("CardName")
    private String cardName;

    @JsonProperty("CardExpiryMonth")
    private String cardExpiryMonth;

    @JsonProperty("CardExpiryYear")
    private String cardExpiryYear;

    @JsonProperty("CardStartMonth")
    private String cardStartMonth;

    @JsonProperty("CardStartYear")
    private String cardStartYear;

    @JsonProperty("CardIssueNumber")
    private String cardIssueNumber;

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
     * Get the Access Code - this is used when submitting the card details to
     * eWAY and to query the result.
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
     * This is the URL that the card details form should be submitted to from
     * the merchant's site
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

    /**
     * Get the total amount for the transaction in cents
     *
     * @return The total amount
     */
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the Invoice Number
     *
     * @return Invoice Number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Get the Invoice Description
     *
     * @return Invoice Description
     */
    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    public void setInvoiceDescription(String invoiceDescription) {
        this.invoiceDescription = invoiceDescription;
    }

    /**
     * Get the Invoice Reference
     *
     * @return The Invoice Reference
     */
    public String getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    /**
     * Get the currency code for the transaction
     *
     * @return The currency code
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Get the Token Customer ID to be used for the transaction
     *
     * @return The Token Customer ID
     */
    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }

    /**
     * Get the Customer Reference
     *
     * @return the Customer Reference
     */
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Get the customer's title
     *
     * @return The customer's title
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the customer's first name
     * 
     * @return The customer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the customer's last name
     * 
     * @return The customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the customer's company
     * 
     * @return The customer's company
     */
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get the customer's job description / role
     * 
     * @return The customer's job description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Get the customer's street address
     * 
     * @return The customer's street address
     */
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Get the second part of the customer's street address
     * 
     * @return The customer's street address
     */
    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Get the customer's suburb or city
     * 
     * @return The customer's suburb or city
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the customer's state
     * 
     * @return The customer's state
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the customer's postcode
     * 
     * @return The customer's postcode
     */
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Get the customer's country
     * 
     * @return The customer's country
     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the customer's email
     * 
     * @return The customer's email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the customer's phone
     * 
     * @return The customer's 
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the customer's mobile
     * 
     * @return The customer's mobile
     */
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get any comments attached to the customer
     * 
     * @return The customer's comments
     */
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Get the customer's fax
     * 
     * @return The customer's fax
     */
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Get the customer's URL
     * 
     * @return The customer's URL
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the customer's masked card number
     * 
     * @return The customer's masked card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Get the customer's card name
     * 
     * @return The customer's name
     */
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Get the customer's card expiry month
     * 
     * @return The customer's card expiry month
     */
    public String getCardExpiryMonth() {
        return cardExpiryMonth;
    }

    public void setCardExpiryMonth(String cardExpiryMonth) {
        this.cardExpiryMonth = cardExpiryMonth;
    }

    /**
     * Get the customer's card expiry year
     * 
     * @return The customer's expiry year
     */
    public String getCardExpiryYear() {
        return cardExpiryYear;
    }

    public void setCardExpiryYear(String cardExpiryYear) {
        this.cardExpiryYear = cardExpiryYear;
    }

    /**
     * Get the customer's card start month
     * 
     * @return The customer's 
     */
    public String getCardStartMonth() {
        return cardStartMonth;
    }

    public void setCardStartMonth(String cardStartMonth) {
        this.cardStartMonth = cardStartMonth;
    }

    /**
     * Get the customer's card start year
     * 
     * @return The customer's card start year
     */
    public String getCardStartYear() {
        return cardStartYear;
    }

    public void setCardStartYear(String cardStartYear) {
        this.cardStartYear = cardStartYear;
    }

    /**
     * Get the customer's card issue number
     * 
     * @return The customer's card issue number
     */
    public String getCardIssueNumber() {
        return cardIssueNumber;
    }

    public void setCardIssueNumber(String cardIssueNumber) {
        this.cardIssueNumber = cardIssueNumber;
    }

}
