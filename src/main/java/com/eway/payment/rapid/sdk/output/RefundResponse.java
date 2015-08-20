package com.eway.payment.rapid.sdk.output;

import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;

/**
 * Contains the response from a refund or cancel transaction
 */
public class RefundResponse extends ResponseOutput {

    private Refund refund;
    private TransactionStatus transactionStatus;

    /**
     * Return the Refund details as echoed back by the Rapid API
     *
     * @return The Refund as echoed back by the Rapid API
     */
    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }

    /**
     * Return the status details of the processed refund transaction
     *
     * @return The status of the processed refund transaction
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

}
