package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.ShippingDetails;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class TransactionShippingAddressConverter implements BeanConverter<Transaction, ShippingAddress> {

    public ShippingAddress doConvert(Transaction transaction) throws RapidSdkException {
        ShippingAddress shippingAddress = new ShippingAddress();
        ShippingDetails detail = transaction.getShippingDetails();
        if (detail != null) {
            shippingAddress.setFirstName(detail.getFirstName());
            shippingAddress.setLastName(detail.getLastName());
            shippingAddress.setShippingMethod(detail.getShippinhgMethod() != null ? detail.getShippinhgMethod().name() : null);
            shippingAddress.setEmail(detail.getEmail());
            shippingAddress.setPhone(detail.getPhone());
            shippingAddress.setFax(detail.getFax());
            Address address = detail.getShippingAddress();
            if (address != null) {
                shippingAddress.setCity(address.getCity());
                shippingAddress.setCountry(address.getCountry());
                shippingAddress.setPostalCode(address.getPostalCode());
                shippingAddress.setState(address.getState());
                shippingAddress.setStreet1(address.getStreet1());
                shippingAddress.setStreet2(address.getStreet2());
            }
        }
        return shippingAddress;
    }

}
