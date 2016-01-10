package com.eway.payment.rapid.sdk.message.convert.request;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.RequestMethod;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.CustomerToInternalCustomerConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionShippingAddressConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToArrLineItemConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToArrOptionConverter;
import com.eway.payment.rapid.sdk.message.convert.TransactionToPaymentConverter;
import org.apache.commons.lang3.StringUtils;

public class TransactionToCreateAccessCodeRequestConverter implements BeanConverter<Transaction, CreateAccessCodeRequest> {

    public CreateAccessCodeRequest doConvert(Transaction input) throws RapidSdkException {
        CreateAccessCodeRequest request = new CreateAccessCodeRequest();
        if (input != null) {
            request.setTransactionType(input.getTransactionType().name());
            request.setDeviceID(input.getDeviceID());
            request.setPartnerID(input.getPartnerID());
            request.setRedirectUrl(input.getRedirectURL());
            if (input.getPaymentDetails() != null) {
                request.getPayment().setTotalAmount(input.getPaymentDetails().getTotalAmount());
            }
            if (input.getCustomer() != null) {
                CustomerToInternalCustomerConverter internalCustConvert = new CustomerToInternalCustomerConverter(false);
                request.setCustomer(internalCustConvert.doConvert(input.getCustomer()));
            }

            request.setCustomerIP(input.getCustomer() != null ? input.getCustomer().getCustomerDeviceIP() : null);

            BeanConverter<Transaction, ShippingAddress> shipAddressConvert = new TransactionShippingAddressConverter();
            request.setShippingAddress(shipAddressConvert.doConvert(input));

            BeanConverter<Transaction, Payment> paymentConvert = new TransactionToPaymentConverter();
            request.setPayment(paymentConvert.doConvert(input));
            if (!StringUtils.isBlank(input.getCheckoutURL())) {
                request.setCheckoutPayment(input.isCheckoutPayment());
                request.setCheckoutUrl(input.getCheckoutURL());
            }

            BeanConverter<Transaction, LineItem[]> lineItemConvert = new TransactionToArrLineItemConverter();
            request.setItems(lineItemConvert.doConvert(input));

            BeanConverter<Transaction, Option[]> optionConverter = new TransactionToArrOptionConverter();
            request.setOptions(optionConverter.doConvert(input));

            if (input.getShippingDetails() != null && input.getShippingDetails().getShippinhgMethod() != null) {
                request.setShippingMethod(input.getShippingDetails().getShippinhgMethod().name());
            }
            request.setMethod(input.isCapture() ? (input.isSaveCustomer() ? RequestMethod.TokenPayment.name() : RequestMethod.ProcessPayment.name()) : RequestMethod.Authorise.name());
        }
        return request;
    }

}
