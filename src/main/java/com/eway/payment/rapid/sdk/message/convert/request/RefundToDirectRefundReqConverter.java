package com.eway.payment.rapid.sdk.message.convert.request;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.external.ShippingDetails;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.entities.DirectRefundRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.CustomerToInternalCustomerConverter;
import com.eway.payment.rapid.sdk.message.convert.ShippingDetailsToAddressConverter;
import java.util.ArrayList;
import java.util.List;

public class RefundToDirectRefundReqConverter implements BeanConverter<Refund, DirectRefundRequest> {

    public DirectRefundRequest doConvert(Refund refund) throws RapidSdkException {
        DirectRefundRequest request = new DirectRefundRequest();
        if (refund != null) {
            request.setRefund(refund.getRefundDetails());
            BeanConverter<ShippingDetails, ShippingAddress> shippingConvert = new ShippingDetailsToAddressConverter();
            request.setShippingAddress(shippingConvert.doConvert(refund.getShippingDetails()));
            CustomerToInternalCustomerConverter customerConvert = new CustomerToInternalCustomerConverter();
            Customer customer = customerConvert.doConvert(refund.getCustomer());
            if (customer.getCardDetails() == null) {
                customer.setCardDetails(new CardDetails());
            }
            request.setCustomer(customer);
            request.setPartnerID(refund.getPartnerID());
            request.setDeviceID(refund.getDeviceID());
            List<LineItem> lineItems = refund.getLineItems();
            if (lineItems != null) {
                LineItem[] items = lineItems.toArray(new LineItem[lineItems.size()]);
                request.setItems(items);
            }
            List<Option> listOptions = refund.getOptions();
            if (listOptions != null && !listOptions.isEmpty()) {
                List<Option> listConvert = new ArrayList<Option>();
                for (Option value : listOptions) {
                    Option op = new Option();
                    op.setValue(value.getValue());
                    listConvert.add(op);
                }
                request.setOptions(listConvert.toArray(new Option[listConvert.size()]));
            }
        }
        return request;
    }

}
