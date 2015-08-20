package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class TransactionToPaymentConverter implements BeanConverter<Transaction, Payment> {

    public Payment doConvert(Transaction transaction) throws RapidSdkException {
        Payment payment = new Payment();
        PaymentDetails paymentDetails = transaction.getPaymentDetails();
        if (paymentDetails != null) {
            payment.setCurrencyCode(paymentDetails.getCurrencyCode());
            payment.setInvoiceDescription(paymentDetails.getInvoiceDescription());
            payment.setInvoiceNumber(paymentDetails.getInvoiceNumber());
            payment.setInvoiceReference(paymentDetails.getInvoiceReference());
            payment.setTotalAmount(paymentDetails.getTotalAmount());
        }
        return payment;
    }

}
