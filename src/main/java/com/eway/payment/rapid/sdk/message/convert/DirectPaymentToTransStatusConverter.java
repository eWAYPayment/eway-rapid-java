package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.FraudAction;
import com.eway.payment.rapid.sdk.beans.external.ProcessingDetails;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.beans.external.VerificationResult;
import com.eway.payment.rapid.sdk.beans.internal.Verification;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import org.apache.commons.lang3.StringUtils;

public class DirectPaymentToTransStatusConverter implements BeanConverter<DirectPaymentResponse, TransactionStatus> {

    public TransactionStatus doConvert(DirectPaymentResponse response) throws RapidSdkException {
        TransactionStatus status = new TransactionStatus();
        status.setBeagleScore(response.getBeagleScore() != null ? response.getBeagleScore() : 0.0);
        status.setCaptured(Boolean.parseBoolean(response.getTransactionCaptured()));
        if (response.getFraudAction() == "0" || response.getFraudAction() == null) {
            status.setFraudAction(FraudAction.valueOf(FraudAction.NotChallenged.name()));
        } 
        else {
            status.setFraudAction(FraudAction.valueOf(response.getFraudAction()));
        }

        status.setProcessingDetails(getProcessingDetails(response));

        if (response.getTransactionStatus() != null) {
            status.setStatus(response.getTransactionStatus());
        }
        if (response.getPayment() != null) {
            status.setTotal(response.getPayment().getTotalAmount());
        }

        if (!StringUtils.isBlank(response.getTransactionID())) {
            try {
                status.setTransactionID(Integer.parseInt(response.getTransactionID()));
            } catch (Exception e) {
                throw new ParameterInvalidException("Invalid Transaction ID");
            }
        }
        BeanConverter<Verification, VerificationResult> verifiConvert = new VerificationToVerifiResultConverter();
        status.setVerificationResult(verifiConvert.doConvert(response.getVerification()));

        return status;
    }

    private ProcessingDetails getProcessingDetails(DirectPaymentResponse response) {
        ProcessingDetails processingDetails = new ProcessingDetails();
        processingDetails.setAuthorisationCode(response.getAuthorisationCode());
        processingDetails.setResponseCode(response.getResponseCode());
        processingDetails.setResponseMessage(response.getResponseMessage());
        return processingDetails;
    }
}
