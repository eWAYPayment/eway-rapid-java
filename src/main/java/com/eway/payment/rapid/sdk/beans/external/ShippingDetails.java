package com.eway.payment.rapid.sdk.beans.external;

/**
 * Combines all the Shipping related information for a transaction
 *
 */
public class ShippingDetails {

    private String firstName;

    private String lastName;

    private ShippingMethod shippingMethod;

    private Address shippingAddress;

    private String email;

    private String phone;

    private String Fax;

    /**
     * Return first name on the shipping manifest
     *
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name on the shipping manifest
     *
     * @param firstName First name on the shipping manifest
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return last name on the shipping manifest
     *
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name on the shipping manifest
     *
     * @param lastName Last name on the shipping manifest
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the Shipping Method
     *
     * @return Shipping method
     */
    public ShippingMethod getShippinhgMethod() {
        return shippingMethod;
    }

    /**
     * Set shipping method
     *
     * @param shippingMethod ShippingMethod enumeration
     */
    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    /**
     * Return Destination of the sale
     *
     * @return Shipping address
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Set sShipping address
     *
     * @param address Destination of the sale
     */
    public void setShippingAddress(Address address) {
        this.shippingAddress = address;
    }

    /**
     * Return email of the recipient
     *
     * @return Email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email of the recipient
     *
     * @param email Email of the recipient
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the phone number of the recipient
     *
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone number of the recipient
     *
     * @param phone Phone number of the recipient
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Return the fax number of the recipient
     *
     * @return fax number
     */
    public String getFax() {
        return Fax;
    }

    /**
     * Set fax number of the recipient
     *
     * @param fax Fax number of the recipient
     */
    public void setFax(String fax) {
        Fax = fax;
    }
}
