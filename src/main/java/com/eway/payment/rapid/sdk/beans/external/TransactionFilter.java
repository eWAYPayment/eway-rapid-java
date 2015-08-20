package com.eway.payment.rapid.sdk.beans.external;

import org.apache.commons.lang3.StringUtils;
import java.util.BitSet;

/**
 * Defines a set of parameters used to search for a transaction. Only one of the 
 * properties should be provided:
 * <ul>
 * <li>transactionId</li>
 * <li>accessCode</li>
 * <li>invoiceNumber</li>
 * <li>invoiceReference</li>
 * </ul>
 */
public class TransactionFilter {

    public static final int TRANSACTION_ID_INDEX = 1;
    private Integer transactionId;

    public static final int ACCESS_CODE_INDEX = 2;
    private String accessCode;

    public static final int INVOICE_NUMBER_INDEX = 3;
    private String invoiceNumber;

    public static final int INVOICE_REFERENCE_INDEX = 4;
    private String invoiceReference;

    /**
     * Return the eWAY transaction ID to search for
     *
     * @return The eWAY transaction ID
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * Set an eWAY transaction ID to search for
     *
     * @param transactionId An eWAY transaction ID
     */
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Return the access code to search for
     *
     * @return The access code
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * Set an eWAY Access Code to search for
     *
     * @param accessCode The access code to search for
     */
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    /**
     * Get Merchant's Invoice Number to search
     *
     * @return The invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Set Merchant's Invoice Number for the transaction to search
     *
     * @param invoiceNumber Merchant's Invoice Number
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Get Merchant's Invoice Reference to search
     *
     * @return Merchant's invoice reference
     */
    public String getInvoiceReference() {
        return invoiceReference;
    }

    /**
     * Set Merchant's Invoice Reference to search
     *
     * @param invoiceReference Merchant's invoice reference
     */
    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    /**
     * Calculate valid index value
     *
     * @return The filter index status
     */
    public Integer calculateIndexOfValue() {
        BitSet bit = new BitSet(4);
        if (getTransactionId() != null) {
            bit.set(TRANSACTION_ID_INDEX);
        }

        if (!StringUtils.isBlank(getAccessCode())) {
            bit.set(ACCESS_CODE_INDEX);
        }

        if (!StringUtils.isBlank(getInvoiceNumber())) {
            bit.set(INVOICE_NUMBER_INDEX);
        }
        if (!StringUtils.isBlank(getInvoiceReference())) {
            bit.set(INVOICE_REFERENCE_INDEX);
        }
        if (bit.cardinality() != 1) {
            return null;
        }
        return bit.nextSetBit(1);
    }

}
