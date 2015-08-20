package com.eway.payment.rapid.sdk.message.convert.request;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.entities.CapturePaymentRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;

public class TransactionToCapturePaymentConverter implements BeanConverter<Transaction, CapturePaymentRequest> {

    public CapturePaymentRequest doConvert(Transaction u) throws RapidSdkException {
        CapturePaymentRequest request = new CapturePaymentRequest();
        if (u.getAuthTransactionID() != null) {
            request.setTransactionId(String.valueOf(u.getAuthTransactionID()));
        }
        if (u.getPaymentDetails() != null) {
            Payment payment = new Payment();
            payment.setCurrencyCode(u.getPaymentDetails().getCurrencyCode());
            payment.setInvoiceDescription(u.getPaymentDetails().getInvoiceDescription());
            payment.setInvoiceNumber(u.getPaymentDetails().getInvoiceNumber());
            payment.setInvoiceReference(u.getPaymentDetails().getInvoiceReference());
            payment.setTotalAmount(u.getPaymentDetails().getTotalAmount());
            request.setPayment(payment);
        }
        return request;
    }

}
