package com.eway.payment.rapid.sdk.message.process.customer;

import com.eway.payment.rapid.sdk.entities.DirectCustomerSearchRequest;
import com.eway.payment.rapid.sdk.entities.DirectCustomerSearchResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.response.DirectCustomerToQueryCustomerConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * Query customer message process
 */
public class QueryCustomerMsgProcess extends AbstractMakeRequestMessageProcess<String, QueryCustomerResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public QueryCustomerMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(String tokenCustomerID) throws RapidSdkException {
        DirectCustomerSearchRequest request = new DirectCustomerSearchRequest();
        request.setTokenCustomerID(tokenCustomerID);
        return request;
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, DirectCustomerSearchResponse.class);
    }

    @Override
    protected QueryCustomerResponse makeResult(Response res) throws RapidSdkException {
        DirectCustomerSearchResponse response = (DirectCustomerSearchResponse) res;
        BeanConverter<DirectCustomerSearchResponse, QueryCustomerResponse> convert = new DirectCustomerToQueryCustomerConverter();
        return convert.doConvert(response);
    }

}
