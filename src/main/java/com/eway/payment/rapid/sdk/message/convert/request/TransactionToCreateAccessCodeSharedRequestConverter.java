package com.eway.payment.rapid.sdk.message.convert.request;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.RequestMethod;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeSharedRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.CustomerToInternalCustomerConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionShippingAddressConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToArrLineItemConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToArrOptionConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToPaymentConverter;

public class TransactionToCreateAccessCodeSharedRequestConverter implements BeanConverter<Transaction, CreateAccessCodeSharedRequest> {

    public CreateAccessCodeSharedRequest doConvert(Transaction input) throws RapidSdkException {
        CreateAccessCodeSharedRequest request = new CreateAccessCodeSharedRequest();
        if (input != null) {
            request.setCancelUrl(input.getCancelURL());
            request.setTransactionType(input.getTransactionType().name());
            request.setDeviceID(input.getDeviceID());
            request.setPartnerID(input.getPartnerID());
            request.setRedirectUrl(input.getRedirectURL());
            request.setCustomView(input.getCustomView());
            request.setHeaderText(input.getHeaderText());
            request.setCustomerIP(input.getCustomer() != null ? input.getCustomer().getCustomerDeviceIP() : null);
            request.setLogoUrl(input.getLogoUrl());
            request.setLanguage(input.getLanguage());
            request.setVerifyCustomerEmail(input.getVerifyCustomerEmail());
            request.setVerifyCustomerPhone(input.getVerifyCustomerPhone());
            request.setCustomerReadOnly(input.getCustomerReadOnly());

            BeanConverter<Customer, com.eway.payment.rapid.sdk.beans.internal.Customer> internalCustConvert = new CustomerToInternalCustomerConverter();
            request.setCustomer(internalCustConvert.doConvert(input.getCustomer()));

            BeanConverter<Transaction, ShippingAddress> shipAddressConvert = new TransactionShippingAddressConverter();
            request.setShippingAddress(shipAddressConvert.doConvert(input));

            BeanConverter<Transaction, Payment> paymentConvert = new TransactionToPaymentConverter();
            request.setPayment(paymentConvert.doConvert(input));

            BeanConverter<Transaction, LineItem[]> lineItemConvert = new TransactionToArrLineItemConverter();
            request.setItems(lineItemConvert.doConvert(input));

            BeanConverter<Transaction, Option[]> optionConverter = new TransactionToArrOptionConverter();
            request.setOptions(optionConverter.doConvert(input));

            request.setMethod(input.isCapture() ? (input.isSaveCustomer() ? RequestMethod.TokenPayment.name() : RequestMethod.ProcessPayment.name()) : RequestMethod.Authorise.name());
        }
        return request;
    }
}
