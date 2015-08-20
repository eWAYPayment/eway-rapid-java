package com.eway.payment.rapid.sdk.beans.external;

/**
 * Combines together all the bank/gateway specific status information for a
 * transaction
 */
public class ProcessingDetails {

    private String authorisationCode;

    private String responseCode;

    private String responseMessage;

    /**
     * Return the Bank Authorisation Code for the transaction
     *
     * @return Authorisation Code
     */
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    /**
     * Set the Bank Authorisation Code for the transaction
     *
     * @param authorisationCode Authorisation Code
     */
    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    /**
     * Return the bank/gateway response code
     *
     * @return The bank/gateway response code
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Set the bank/gateway response code
     *
     * @param responseCode the bank/gateway response code
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Return the bank/gateway response message.
     * Use RapidSDK.userDisplayMessage() to translate.
     *
     * @return response the bank/gateway response message
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Get the bank/gateway response message.
     * @param responseMessage the bank/gateway response message
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
