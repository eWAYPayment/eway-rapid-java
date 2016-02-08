package com.eway.payment.rapid.sdk.beans.internal;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundDetails {

    @JsonProperty("TransactionID")
    private String originalTransactionID;

    @JsonProperty("TotalAmount")
    private int totalAmount;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("InvoiceDescription")
    private String invoiceDescription;

    @JsonProperty("InvoiceReference")
    private String invoiceReference;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    /**
     * Return the ID of either the transaction to refund, or the authorisation
     * to cancel
     *
     * @return : original transaction id
     */
    public String getOriginalTransactionID() {
        if (StringUtils.isBlank(originalTransactionID)) {
            return "0";
        }
        return originalTransactionID;
    }

    /**
     * Set original transaction id
     *
     * @param originalTransactionID : the ID of either the transaction to
     * refund, or the authorisation to cancel
     */
    public void setOriginalTransactionID(String originalTransactionID) {
        this.originalTransactionID = originalTransactionID;
    }

    /**
     * Return the total amount to charge the card holder in this transaction in
     * cents
     *
     * @return : the total amount to charge the card holder
     */
    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount : the total amount to charge the card holder
     */
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Return the merchant's invoice number
     *
     * @return : The merchant's invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber : The merchant's invoice number
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Return merchants invoice description
     *
     * @return : merchants invoice description
     */
    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    /**
     * @param invoiceDescription : merchants invoice description
     */
    public void setInvoiceDescription(String invoiceDescription) {
        this.invoiceDescription = invoiceDescription;
    }

    /**
     * Return the merchant's invoice reference
     *
     * @return : The merchant's invoice reference
     */
    public String getInvoiceReference() {
        return invoiceReference;
    }

    /**
     * @param invoiceReference : The merchant's currency
     */
    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    /**
     * Return the merchant's currency
     *
     * @return : The merchant's currency
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode : The merchant's currency
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
