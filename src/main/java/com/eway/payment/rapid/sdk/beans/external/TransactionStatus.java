package com.eway.payment.rapid.sdk.beans.external;

/**
 * Combines together all the status information for a transaction
 */
public class TransactionStatus {

    private int transactionID;

    private int total;

    private boolean status;

    private boolean captured;

    private double beagleScore;

    private FraudAction fraudAction;

    private VerificationResult verificationResult;

    private ProcessingDetails processingDetails;

    /**
     * Get the eWAY Transaction ID for the transaction
     * 
     * @return eWAY Transaction ID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * Set the transaction ID
     * 
     * @param transactionID the eWAY Transaction ID
     */
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    /** 
     * Get the transaction total amount (in cents)
     * 
     * @return The transaction total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Set the transaction total amount (in cents)
     * 
     * @param total Transaction total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Get if the transaction successfully processed a payment.
     * Note this will be false if the transaction created a token customer (since
     * no payment was made)
     * 
     * @return The transaction status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Set the transaction status
     * 
     * @param status The transaction status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Get if the transaction captured funds from the cusomter's card
     * 
     * @return If the transaction was a capture
     */
    public boolean isCaptured() {
        return captured;
    }

    /** 
     * Set if the transaction was a capture
     * 
     * @param captured The transaction capture status
     */
    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    /**
     * Get the Beagle Score associated with the transaction.
     * 
     * @return The transaction's Beagle Score
     */
    public double getBeagleScore() {
        return beagleScore;
    }

    /**
     * Set the transaction's Beagle Score
     * 
     * @param beagleScore The transaction's Beagle Score
     */
    public void setBeagleScore(double beagleScore) {
        this.beagleScore = beagleScore;
    }

    /**
     * Get the fraud action taken by Beagle
     * 
     * @return The fraud action
     */
    public FraudAction getFraudAction() {
        return fraudAction;
    }

    /**
     * Set the fraud action taken by Beagle
     * 
     * @param fraudAction The fraud action
     */
    public void setFraudAction(FraudAction fraudAction) {
        this.fraudAction = fraudAction;
    }

    /**
     * Get the verification results of the transaction
     * 
     * @return Transaction verification result
     */
    public VerificationResult getVerificationResult() {
        return verificationResult;
    }

    /**
     * Set the verification results of the transaction
     * 
     * @param verificationResult Transaction verification result
     */
    public void setVerificationResult(VerificationResult verificationResult) {
        this.verificationResult = verificationResult;
    }

    /**
     * Get the processing details of the transaction (such as authorisation code
     * and response messages)
     * 
     * @return Processing details
     */
    public ProcessingDetails getProcessingDetails() {
        return processingDetails;
    }

    /**
     * Set the transaction processing details
     * 
     * @param processingDetails Processing details
     */
    public void setProcessingDetails(ProcessingDetails processingDetails) {
        this.processingDetails = processingDetails;
    }
}
