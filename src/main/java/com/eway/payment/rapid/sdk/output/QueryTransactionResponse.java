package com.eway.payment.rapid.sdk.output;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;

/**
 * Contains the response from a Transaction Query
 */
public class QueryTransactionResponse extends ResponseOutput {

    private Transaction transaction;
    private TransactionStatus transactionStatus;
    private String accessCode;

    /**
     * The Request as echoed back by the Rapid API. Where a token customer is
     * created as result of the transaction, then the Customer member in this
     * type will contain the token ID
     *
     * @return The transaction information
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Set transaction information
     *
     * @param transaction Transaction information
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Get the status details of the processed transaction
     *
     * @return The transaction status
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * Get the access code for this transaction
     *
     * @return Access Code
     */
    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}
