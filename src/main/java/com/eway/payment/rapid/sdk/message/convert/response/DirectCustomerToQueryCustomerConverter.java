package com.eway.payment.rapid.sdk.message.convert.response;

import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.entities.DirectCustomerSearchResponse;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.List;

public class DirectCustomerToQueryCustomerConverter implements BeanConverter<DirectCustomerSearchResponse, QueryCustomerResponse> {

    public QueryCustomerResponse doConvert(DirectCustomerSearchResponse response) {
        QueryCustomerResponse result = new QueryCustomerResponse();

        if (response != null) {
            if (!StringUtils.isBlank(response.getErrors())) {
                result.setErrors(Arrays.asList(response.getErrors()));
            }
            List<Customer> list = response.getCustomers();
            if (list != null && list.size() > 0) {
                for (Customer cust : list) {
                    result.setReference(cust.getReference());
                    result.setTitle(cust.getTitle());
                    result.setFirstName(cust.getFirstName());
                    result.setLastName(cust.getLastName());
                    result.setCompanyName(cust.getCompanyName());
                    result.setJobDescription(cust.getJobDescription());
                    String street = cust.getStreet1();
                    if (!StringUtils.isBlank(street)) {
                        int splitIndex = street.lastIndexOf(",");
                        if (splitIndex > -1) {
                            result.setStreet1(street.substring(0, splitIndex));
                            result.setStreet2(street.substring(splitIndex + 1, street.length()).trim());
                        } else {
                            result.setStreet1(street);
                        }
                    }
                    result.setCity(cust.getCity());
                    result.setState(cust.getState());
                    result.setPostalCode(cust.getPostalCode());
                    result.setPhone(cust.getPhone());
                    result.setMobile(cust.getMobile());
                    result.setEmail(cust.getEmail());
                    result.setUrl(cust.getUrl());
                    result.setCardDetail(cust.getCardDetails());
                    result.setCountry(cust.getCountry());
                    result.setComments(cust.getComments());
                    result.setFax(cust.getFax());
                    return result;
                }
            }
        }
        return result;
    }
}
