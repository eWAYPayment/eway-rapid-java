package com.eway.payment.rapid.sdk.output;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;

/**
 * Contains the response from creating a Transaction
 */
public class CreateTransactionResponse extends ResponseOutput {

    private Transaction transaction;
    private TransactionStatus transactionStatus;
    private String sharedPaymentUrl;
    private String formActionUrl;
    private String accessCode;

    /**
     * Get the Transaction as echoed back by the Rapid API. Where a token
     * customer is created as result of the transaction, then the Customer
     * object in the RequestDetails will contain the token ID
     *
     * @return The transaction's information
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Set transaction's information
     *
     * @param transaction The transaction information
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Get the status details of the processed transaction (Only for Direct
     * payment methods)
     *
     * @return transaction status
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Set transaction status
     *
     * @param transactionStatus Set the status details of the processed transaction
     */
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * Get URL to the Responsive Shared Page that the customer's browser should
     * be redirected to to complete payment (Only for payment method of
     * ResponsiveShared)
     *
     * @return The URL to the Responsive Shared Page
     */
    public String getSharedPaymentUrl() {
        return sharedPaymentUrl;
    }

    /**
     * Set shared payment URL
     *
     * @param sharedPaymentUrl URL to the Responsive Shared Page
     */
    public void setSharedPaymentUrl(String sharedPaymentUrl) {
        this.sharedPaymentUrl = sharedPaymentUrl;
    }

    /**
     * Get URL that the merchant's credit card collection form should post to to
     * complete payment
     *
     * @return The merchant's credit card collection form should post to to
     * complete payment
     */
    public String getFormActionUrl() {
        return formActionUrl;
    }

    /**
     * Set form action URL
     *
     * @param formActionUrl Set the merchant's credit card collection form
     * should post to to complete payment
     */
    public void setFormActionUrl(String formActionUrl) {
        this.formActionUrl = formActionUrl;
    }

    /**
     * Get the AccessCode for this transaction (can be used to call query
     * transaction for searching before the transaction has completed
     * processing)
     *
     * @return The Access Code
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * Set access code
     *
     * @param accessCode The Access Code for this transaction
     */
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}
