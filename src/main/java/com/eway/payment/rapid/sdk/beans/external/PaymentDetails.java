package com.eway.payment.rapid.sdk.beans.external;

/**
 * Details of the payment
 */
public class PaymentDetails {

    private int totalAmount;

    private String invoiceNumber;

    private String invoiceDescription;

    private String invoiceReference;

    private String currencyCode;

    /**
     * Return the total amount to charge the card holder in this transaction in
     * cents
     *
     * @return The total amount in cents
     */
    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the total amount to charge the card holder in this transaction in
     * cents (e.g. $9.10 is 910)
     *
     * @param totalAmount The total amount in cents
     */
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Return the merchant's invoice number
     *
     * @return The Invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Set invoice number
     *
     * @param invoiceNumber The Invoice number
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Return merchants invoice description
     *
     * @return Invoice description
     */
    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    /**
     * Set the invoice description
     *
     * @param invoiceDescription Invoice description
     */
    public void setInvoiceDescription(String invoiceDescription) {
        this.invoiceDescription = invoiceDescription;
    }

    /**
     * Return the merchant's invoice reference
     *
     * @return Invoice reference
     */
    public String getInvoiceReference() {
        return invoiceReference;
    }

    /**
     * Set invoice reference
     *
     * @param invoiceReference Invoice reference
     */
    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    /**
     * Return the transaction currency
     *
     * @return Currency code
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * The ISO 4217 3 character code that represents the currency that this 
     * transaction is to be processed in. e.g. "AUD"
     *
     * @param currencyCode The currency code
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
