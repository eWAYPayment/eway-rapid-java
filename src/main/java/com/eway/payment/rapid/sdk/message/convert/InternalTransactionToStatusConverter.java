package com.eway.payment.rapid.sdk.message.convert;

import org.apache.commons.lang3.StringUtils;

import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.beans.internal.Transaction;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.beans.external.ProcessingDetails;
import com.eway.payment.rapid.sdk.beans.external.BeagleVerifyStatus;
import com.eway.payment.rapid.sdk.beans.external.FraudAction;
import com.eway.payment.rapid.sdk.beans.external.VerificationResult;
import com.eway.payment.rapid.sdk.beans.internal.BeagleVerification;
import com.eway.payment.rapid.sdk.beans.internal.Verification;

public class InternalTransactionToStatusConverter implements BeanConverter<Transaction, TransactionStatus> {

    public TransactionStatus doConvert(Transaction transaction) throws RapidSdkException {
        TransactionStatus transactionStatus = new TransactionStatus();
        if (transaction.getBeagleScore() != null) {
            transactionStatus.setBeagleScore(transaction.getBeagleScore());
        }
        transactionStatus.setStatus(transaction.getTransactionStatus());
        transactionStatus.setTotal(transaction.getTotalAmount());
        transactionStatus.setCaptured(transaction.getTransactionCaptured());

        transactionStatus.setProcessingDetails(getProcessingDetails(transaction));
        
       try {
                if (transaction.getFraudAction() == null || transaction.getFraudAction().equalsIgnoreCase("0")|| transaction.getFraudAction() == "")
                {
                    transactionStatus.setFraudAction(FraudAction.valueOf(FraudAction.NotChallenged.name()));
                }
                else{

                    transactionStatus.setFraudAction(FraudAction.valueOf(transaction.getFraudAction()));
                }

            } catch (Exception e) {
                throw new ParameterInvalidException("Invalid Transaction Fraud Action: " + transaction.getFraudAction());
         }

        if (!StringUtils.isBlank(transaction.getTransactionID())) {
            try {
                transactionStatus.setTransactionID(Integer.parseInt(transaction.getTransactionID()));
            } catch (Exception e) {
                throw new ParameterInvalidException("Invalid Transaction ID");
            }
        }

        BeanConverter<Verification, VerificationResult> converter = new VerificationToVerifiResultConverter();
        VerificationResult result = converter.doConvert(transaction.getVerification());

        BeagleVerification beagleVerification = transaction.getBeagleVerification();
        if (beagleVerification != null) {
            String email = beagleVerification.getEmail();
            String phone = beagleVerification.getPhone();
            result.setBeagleEmail(getBeagleVerification(email));
            result.setBeaglePhone(getBeagleVerification(phone));
        }
        transactionStatus.setVerificationResult(result);

        return transactionStatus;
    }

    private ProcessingDetails getProcessingDetails(Transaction response) {
        ProcessingDetails processingDetails = new ProcessingDetails();
        processingDetails.setAuthorisationCode(response.getAuthorisationCode());
        processingDetails.setResponseCode(response.getResponseCode());
        processingDetails.setResponseMessage(response.getResponseMessage());
        return processingDetails;
    }

    private BeagleVerifyStatus getBeagleVerification(String code) {
        if ("0".equalsIgnoreCase(code)) {
                return BeagleVerifyStatus.NotVerified;
        } else if ("1".equalsIgnoreCase(code)) {
                return BeagleVerifyStatus.Attempted;
        } else if ("2".equalsIgnoreCase(code)) {
                return BeagleVerifyStatus.Verified;
        } else if ("3".equalsIgnoreCase(code)) {
                return BeagleVerifyStatus.Failed;
        }
        return null;
    }

}
