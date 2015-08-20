package com.eway.payment.rapid.sdk.message.convert.response;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.entities.CreateCustomerResponse;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.InternalCustomerToCustomerConverter;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;

public class DirectPaymentToCreateCustConverter implements BeanConverter<DirectPaymentResponse, CreateCustomerResponse> {

    public CreateCustomerResponse doConvert(DirectPaymentResponse response) throws RapidSdkException {
        CreateCustomerResponse customerResponse = new CreateCustomerResponse();
        BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Customer, Customer> custConvert = new InternalCustomerToCustomerConverter();
        customerResponse.setCustomer(custConvert.doConvert(response.getCustomer()));
        if (!StringUtils.isBlank(response.getErrors())) {
            customerResponse.setErrors(Arrays.asList(response.getErrors().split("\\s*,\\s*")));
        }
        return customerResponse;
    }

}
