package com.eway.payment.rapid.sdk.beans.internal;

import com.eway.payment.rapid.sdk.beans.external.CardDetails;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Customer {

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

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardNumber")
    private String cardNumber;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardStartMonth")
    private String cardStartMonth;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardStartYear")
    private String cardStartYear;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardIssueNumber")
    private String cardIssueNumber;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardName")
    private String cardName;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardExpiryMonth")
    private Integer cardExpiryMonth;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardExpiryYear")
    private Integer cardExpiryYear;

    @JsonProperty("IsActive")
    private String isActive;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardDetails")
    private CardDetails cardDetails;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CustomerIP")
    private String customerDeviceIP;

    public String getCustomerDeviceIP() {
        return customerDeviceIP;
    }

    public void setCustomerDeviceIP(String customerDeviceIP) {
        this.customerDeviceIP = customerDeviceIP;
    }

    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String Reference) {
        this.reference = Reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardStartMonth() {
        return cardStartMonth;
    }

    public void setCardStartMonth(String cardStartMonth) {
        this.cardStartMonth = cardStartMonth;
    }

    public String getCardStartYear() {
        return cardStartYear;
    }

    public void setCardStartYear(String cardStartYear) {
        this.cardStartYear = cardStartYear;
    }

    public String getCardIssueNumber() {
        return cardIssueNumber;
    }

    public void setCardIssueNumber(String cardIssueNumber) {
        this.cardIssueNumber = cardIssueNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardExpiryMonth() {
        return cardExpiryMonth;
    }

    public void setCardExpiryMonth(Integer cardExpiryMonth) {
        this.cardExpiryMonth = cardExpiryMonth;
    }

    public Integer getCardExpiryYear() {
        return cardExpiryYear;
    }

    public void setCardExpiryYear(Integer cardExpiryYear) {
        this.cardExpiryYear = cardExpiryYear;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }
}
