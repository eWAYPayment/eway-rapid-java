package com.eway.payment.rapid.sdk.message.convert;

import org.apache.commons.lang3.StringUtils;

import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.beans.internal.Transaction;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.beans.external.ProcessingDetails;

public class InternalTransactionToStatusConverter implements BeanConverter<Transaction, TransactionStatus> {

    public TransactionStatus doConvert(Transaction transaction) throws RapidSdkException {
        TransactionStatus transactionStatus = new TransactionStatus();
        if (transaction.getBeagleScore() != null) {
            transactionStatus.setBeagleScore(transaction.getBeagleScore());
        }
        transactionStatus.setStatus(transaction.getTransactionStatus());
        transactionStatus.setTotal(transaction.getTotalAmount());

        transactionStatus.setProcessingDetails(getProcessingDetails(transaction));

        if (!StringUtils.isBlank(transaction.getTransactionID())) {
            try {
                transactionStatus.setTransactionID(Integer.parseInt(transaction.getTransactionID()));
            } catch (Exception e) {
                throw new ParameterInvalidException("Invalid Transaction ID");
            }
        }

        return transactionStatus;
    }

    private ProcessingDetails getProcessingDetails(Transaction response) {
        ProcessingDetails processingDetails = new ProcessingDetails();
        processingDetails.setAuthorisationCode(response.getAuthorisationCode());
        processingDetails.setResponseCode(response.getResponseCode());
        processingDetails.setResponseMessage(response.getResponseMessage());
        return processingDetails;
    }

}
