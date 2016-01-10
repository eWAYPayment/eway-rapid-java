package com.eway.payment.rapid.sdk.beans.external;

/**
 * Contains members that define a Rapid customer (and card)
 *
 */
public class Customer {

    private String tokenCustomerID;

    private String reference;

    private String title;

    private String firstName;

    private String lastName;

    private String companyName;

    private String jobDescription;

    private Address address;

    private String phone;

    private String mobile;

    private String fax;

    private String url;

    private String comments;

    private CardDetails cardDetails;

    private String redirectUrl;

    private String cancelUrl;

    private String customerDeviceIP;

    private String email;

    /**
     * Return the IP Address of the customer's computer. (Optional, Used for
     * anti fraud when creating transactions)
     *
     * @return String Customer's IP
     */
    public String getCustomerDeviceIP() {
        return customerDeviceIP;
    }

    /**
     * Set Customer's IP address (Optional, Used for anti fraud when creating
     * transactions)
     *
     * @param customerDeviceIP The Customer's IP
     */
    public void setCustomerDeviceIP(String customerDeviceIP) {
        this.customerDeviceIP = customerDeviceIP;
    }

    /**
     * Return eWAY Token ID identifying this customer
     *
     * @return Token ID identifying this customer
     */
    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    /**
     * Set eWAY Token ID identifying this customer
     *
     * @param tokenCustomerID Token ID identifying this customer
     */
    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }

    /**
     * Return the merchant's reference ID for the customer
     *
     * @return The merchant's reference ID for the customer
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
     * @return The customer's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the customer's title.
     * One of: "Mr.", "Ms.", "Mrs.", "Miss", "Dr.", "Sir.", "Prof."
     *
     * @param title the Customer's title (defaults to "Mr.")
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
     * Set the Customer's first name
     *
     * @param firstName Customer's First Name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the customer's last name
     *
     * @return Customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Customer's last name
     *
     * @param lastName Customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the customer's company name
     *
     * @return customer's company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set the customer's company name
     *
     * @param companyName customer's company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Return the customer's role or job description
     *
     * @return Customer's role or job description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Set the customer's role or job description
     *
     * @param jobDescription Customer's role or job description
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Return the customer's address
     *
     * @return Customer's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the customer's address
     *
     * @param address Customer's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Return the customer's phone number
     *
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the customer's phone number
     *
     * @param phone Customer's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Return the customer's mobile number
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
     * Return customer's fax number
     *
     * @return customer's fax number
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set the customer's fax number
     *
     * @param fax fax number
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Return URL for customer's site.

     *
     * @return URL for customer's site
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL for the customer's site
     * Should be a valid URL e.g. http://example.org
     *
     * @param url URL for customer's site
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return comments attached to this customer
     *
     * @return Comment attached to this customer
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set a comment for the customer
     *
     * @param comments Comment attached to this customer
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Return card details for this customer.
     *
     * @return card details for this customer
     */
    public CardDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Set the card details for the customer. Used only for the Direct payment
     * method.
     *
     * @param cardDetails card details for this customer
     */
    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    /**
     * Return Responsive Shared/Transparent Redirect redirect URL
     *
     * @return redirect URL
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Set the Responsive Shared/Transparent Redirect redirect URL
     * This is where the customer is sent after completing the transaction.
     *
     * @param redirectUrl redirect URL
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * Return Responsive Shared Page cancel URL
     *
     * @return cancel URL
     */
    public String getCancelUrl() {
        return cancelUrl;
    }

    /**
     * Set the Responsive Shared Page cancel URL
     * This is where the customer is sent if they click cancel.
     *
     * @param cancelUrl cancel URL
     */
    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    /**
     * Get the customer's email
     *
     * @return email of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the customer's email
     *
     * @param email Email of the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
