package com.eway.payment.rapid.sdk.beans.external;

/**
 * Contains customer's address
 */
public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    /**
     * Returns the first line of the street address
     *
     * @return First line of the street address, e.g. "Unit 1"
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Set the first line of the street address
     *
     * @param street1 The first line of the street address
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Returns the second line of the street address
     *
     * @return Second line of the street address. e.g. "6 Money St"
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Set the second line of the street address
     *
     * @param street2 The second line of the street address
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Return city or suburb of the address
     *
     * @return City or Suburb of the address. e.g. "Sydney"
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city or suburb of the address
     *
     * @param city City or Suburb of the address. e.g. "Sydney"
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return state or province code
     *
     * @return State or province code. e.g. "NSW"
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state or province code
     * 
     * @param state State or province code
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Return two digit Country Code
     *
     * @return Two digit Country Code. e.g. "au"
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the two digit country code
     *
     * @param country Two digit Country Code. e.g. "au"
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Return the postal or zip code
     *
     * @return The postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set the postal or zip code
     *
     * @param postalCode The postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
