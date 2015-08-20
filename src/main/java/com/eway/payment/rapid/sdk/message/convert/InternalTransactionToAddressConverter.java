package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.beans.internal.Transaction;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class InternalTransactionToAddressConverter implements BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Transaction, Address> {

    public Address doConvert(Transaction iTransaction) throws RapidSdkException {
        Address address = new Address();
        ShippingAddress shippingAddress = iTransaction.getShippingAddress();
        if (shippingAddress != null) {
            address.setState(shippingAddress.getState());
            address.setStreet1(shippingAddress.getStreet1());
            address.setPostalCode(shippingAddress.getPostalCode());
            address.setCity(shippingAddress.getCity());
            address.setCountry(shippingAddress.getCountry());
            address.setStreet2(shippingAddress.getStreet2());
        }
        return address;
    }

}
