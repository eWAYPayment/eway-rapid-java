package com.eway.payment.rapid.sdk.beans.external;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Card Details
 */
public class CardDetails {

    private String name;
    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String startMonth;
    private String startYear;
    private String issueNumber;
    private String CVN;
    private int cardType;

    /**
     * Return name on the card
     *
     * @return name on the card
     */
    public String getName() {
        return name;
    }

    /**
     * Set name on the card
     *
     * @param name Name on the card
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the credit card number
     *
     * @return : The credit card number (16-21 digits plaintext, Up to 512 chars
     * for eCrypted values)
     */
    public String getNumber() {
        return number;
    }

    /**
     * Set the credit card number
     *
     * @param number Number on the credit card
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("Number")
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Get expiry month of the credit card
     *
     * @return Expiry month of the credit card
     */
    public String getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * Set card's expiry month
     * This can optionally include a leading zero for one digit months.
     *
     * @param expiryMonth Card expiry month
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("ExpiryMonth")
    public void setExpiryMonth(String expiryMonth) {
		if (expiryMonth != null && expiryMonth.length() == 1) {
			expiryMonth = "0" + expiryMonth;
		}
        this.expiryMonth = expiryMonth;
    }

    /**
     * Get expiry year of the credit card
     *
     * @return Expiry year of the credit card
     */
    public String getExpiryYear() {
        return expiryYear;
    }

    /**
     * Set expiry year of the credit card (two digits, e.g. "19")
     *
     * @param expiryYear Card expiry year
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("ExpiryYear")
    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
     * Get start month of credit card
     *
     * @return startMonth Card start month
     */
    public String getStartMonth() {
        return startMonth;
    }

    /**
     * Set the card start month
     *
     * @param startMonth Card start month
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("StartMonth")
    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    /**
     * Get the card start year
     *
     * @return Card start year
     */
    public String getStartYear() {
        return startYear;
    }

    /**
     * Set the card start year (two digits, e.g. "15")
     *
     * @param startYear Card start year
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("StartYear")
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     * Get the card issue number
     *
     * @return Card issue number (required in some countries)
     */
    public String getIssueNumber() {
        return issueNumber;
    }

    /**
     * Set the card issue number
     *
     * @param issueNumber Card issue number
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("IssueNumber")
    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    /**
     * Get the card CVN
     *
     * @return Card CVN
     */
    public String getCVN() {
        return CVN;
    }

    /**
     * Set the card CVN/CVV/CSC
     *
     * @param CVN Card verification number
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CVN")
    public void setCVN(String CVN) {
        this.CVN = CVN;
    }

    /**
     * Get the card type (Rapid v40+ only)
     *
     * @return Card Type
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * Set the card type (Rapid v40+ only)
     *
     * @param cardType Card Type
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("CardType")
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
}
