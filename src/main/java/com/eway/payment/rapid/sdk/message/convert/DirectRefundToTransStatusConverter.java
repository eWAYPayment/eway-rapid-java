package com.eway.payment.rapid.sdk.message.convert;

import org.apache.commons.lang3.StringUtils;

import com.eway.payment.rapid.sdk.beans.external.ProcessingDetails;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.entities.DirectRefundResponse;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class DirectRefundToTransStatusConverter implements BeanConverter<DirectRefundResponse, TransactionStatus> {

    public TransactionStatus doConvert(DirectRefundResponse response) throws RapidSdkException {
        TransactionStatus status = new TransactionStatus();
        status.setProcessingDetails(getProcessingDetails(response));
        if (response.getTransactionStatus() != null) {
            status.setStatus(response.getTransactionStatus());
        }
        if (!StringUtils.isBlank(response.getTransactionID())) {
            try {
                status.setTransactionID(Integer.parseInt(response.getTransactionID()));
            } catch (Exception e) {
                throw new ParameterInvalidException("Invalid Transaction ID");
            }
        }
        return status;
    }

    private ProcessingDetails getProcessingDetails(DirectRefundResponse response) {
        ProcessingDetails processingDetails = new ProcessingDetails();
        processingDetails.setResponseCode(response.getResponseCode());
        processingDetails.setResponseMessage(response.getResponseMessage());
        processingDetails.setAuthorisationCode(response.getAuthorisationCode());
        return processingDetails;
    }
}
