package com.eway.payment.rapid.sdk.message.process.transaction;

import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.entities.TransactionSearchResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.response.SearchToQueryTransConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMessageProcess;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;

import org.apache.commons.lang3.StringUtils;
import com.sun.jersey.api.client.WebResource;

/**
 * Query transaction message process
 */
public class TransQueryMsgProcess extends AbstractMessageProcess<String, QueryTransactionResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public TransQueryMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Response processPostMsg(String req) throws RapidSdkException {
        return doGet(StringUtils.isBlank(req) ? "0" : req, TransactionSearchResponse.class);
    }

    @Override
    protected QueryTransactionResponse makeResult(Response res) throws RapidSdkException {
        TransactionSearchResponse response = (TransactionSearchResponse) res;
        BeanConverter<TransactionSearchResponse, QueryTransactionResponse> converter = new SearchToQueryTransConverter();
        return converter.doConvert(response);
    }

}
