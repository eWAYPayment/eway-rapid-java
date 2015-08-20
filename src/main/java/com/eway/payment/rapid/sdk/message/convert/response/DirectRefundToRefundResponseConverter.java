package com.eway.payment.rapid.sdk.message.convert.response;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.entities.DirectRefundResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.DirectRefundToTransStatusConverter;
import com.eway.payment.rapid.sdk.message.convert.InternalCustomerToCustomerConverter;
import com.eway.payment.rapid.sdk.output.RefundResponse;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;

public class DirectRefundToRefundResponseConverter implements BeanConverter<DirectRefundResponse, RefundResponse> {

    public RefundResponse doConvert(DirectRefundResponse response) throws RapidSdkException {
        Refund refund = new Refund();
        refund.setRefundDetails(response.getRefund());
        com.eway.payment.rapid.sdk.beans.internal.Customer innerCust = response.getCustomer();
        BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Customer, Customer> custConvert = new InternalCustomerToCustomerConverter();
        refund.setCustomer(custConvert.doConvert(innerCust));

        RefundResponse refundResponse = new RefundResponse();
        if (!StringUtils.isBlank(response.getErrors())) {
            refundResponse.setErrors(Arrays.asList(response.getErrors().split("\\s*,\\s*")));
        }
        refundResponse.setRefund(refund);

        BeanConverter<DirectRefundResponse, TransactionStatus> transStatusConvert = new DirectRefundToTransStatusConverter();
        refundResponse.setTransactionStatus(transStatusConvert.doConvert(response));
        return refundResponse;
    }

}
