package com.eway.payment.rapid.sdk.output;

import com.eway.payment.rapid.sdk.beans.external.CardDetails;

/**
 * Contains the response from a Customer Query
 */
public class QueryCustomerResponse extends ResponseOutput {

    private String state;
    private String postalCode;
    private String email;
    private String reference;
    private String title;
    private String firstName;
    private String lastName;
    private String companyName;
    private String jobDescription;
    private String street1;
    private String street2;
    private String city;
    private String phone;
    private String mobile;
    private String url;
    private CardDetails cardDetail;
    private String country;
    private String comments;
    private String fax;

    /**
     * Return two digit Country Code
     *
     * @return Two digit Country Code. e.g. "au"
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set country code
     *
     * @param country Two digit Country Code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Return comments attached to this customer
     *
     * @return Comments attached to this customer
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set comments
     *
     * @param comments Comments attached to this customer
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Return customer's fax number
     *
     * @return The customer's fax number
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set the customer's fax number
     *
     * @param fax Fax number
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Return state or city
     *
     * @return State or city. e.g. "NSW"
     */
    public String getState() {
        return state;
    }

    /**
     * Set state or city
     *
     * @param state State or city
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Return the postal code
     *
     * @return The postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set the postal code
     *
     * @param postalCode The postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Return customer's email
     *
     * @return Email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email address
     *
     * @param email Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return merchant's reference ID for the customer
     *
     * @return Merchant's reference ID for the customer
     */
    public String getReference() {
        return reference;
    }

    /**
     * Set merchant's reference ID for the customer
     *
     * @param reference Merchant's reference ID for the customer
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Return the customer's title
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the customer's title
     *
     * @param title Customer's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the customer's first name
     *
     * @return Customer's First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set customer's first name
     *
     * @param firstName Customer's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return customer's last name
     *
     * @return Customer last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set customer's last name
     *
     * @param lastName Customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the name of company
     *
     * @return Name of company
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set customer's company name
     *
     * @param companyName Customer's company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Return role or job description
     *
     * @return Job Description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Set the job description
     *
     * @param jobDescription Job description
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Return first line of the street address, e.g. "Unit 1"
     *
     * @return First line of the street address
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Set the first street address value
     *
     * @param street1 The first street address value
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Return second line of the street address, e.g. "6 Money st"
     *
     * @return Second line of the street address
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Set the second street address value
     *
     * @param street2 The second street address value
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Return city or suburb for the address, e.g. "Sydney"
     *
     * @return City for the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set city for the address
     *
     * @param city City for the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return customer's phone number
     *
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set customer's phone number
     *
     * @param phone Customer Phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Return customer's mobile number
     *
     * @return Mobile number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set the customer's mobile number
     *
     * @param mobile Mobile number
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Return URL for customer's site
     *
     * @return URL for customer's site
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the customer's URL
     *
     * @param url The customer's URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return masked card details for this customer.
     *
     * @return Card details for this customer (Used for Direct PaymentMethods)
     */
    public CardDetails getCardDetail() {
        return cardDetail;
    }

    /**
     * Set card detail
     *
     * @param cardDetail Card information
     */
    public void setCardDetail(CardDetails cardDetail) {
        this.cardDetail = cardDetail;
    }

}
