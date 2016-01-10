package com.eway.payment.rapid.sdk;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentMethod;
import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionFilter;
import com.eway.payment.rapid.sdk.entities.CreateCustomerResponse;
import com.eway.payment.rapid.sdk.exception.APIKeyInvalidException;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.process.MessageProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustDirectPaymentMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustDirectUpdateMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustResponsiveSharedMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustResponsiveUpdateMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustTransparentRedirectMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.CustTransparentUpdateMsgProcess;
import com.eway.payment.rapid.sdk.message.process.customer.QueryCustomerMsgProcess;
import com.eway.payment.rapid.sdk.message.process.refund.CancelAuthorisationMsgProcess;
import com.eway.payment.rapid.sdk.message.process.refund.CapturePaymentMsgProcess;
import com.eway.payment.rapid.sdk.message.process.refund.RefundMsgProcess;
import com.eway.payment.rapid.sdk.message.process.transaction.TransDirectPaymentMsgProcess;
import com.eway.payment.rapid.sdk.message.process.transaction.TransQueryMsgProcess;
import com.eway.payment.rapid.sdk.message.process.transaction.TransResponsiveSharedMsgProcess;
import com.eway.payment.rapid.sdk.message.process.transaction.TransTransparentRedirectMsgProcess;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;
import com.eway.payment.rapid.sdk.output.RefundResponse;
import com.eway.payment.rapid.sdk.output.ResponseOutput;
import com.eway.payment.rapid.sdk.util.Constant;
import com.eway.payment.rapid.sdk.util.ResourceUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RapidClientImpl implements RapidClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RapidClient.class);
    private String APIKey;
    private String password;
    private String webUrl;
    private String rapidEndpoint;
    private boolean debug;

    private boolean isValid;
    private List<String> listError;

    /**
     * Get the Rapid API Key
     *
     * @return API Key
     */
    protected String getAPIKey() {
        return APIKey;
    }

    /**
     * Set and validate the client parameters
     * @param APIKey Rapid API key
     * @param password Rapid API password
     * @param rapidEndpoint Rapid API endpoint
     */
    protected RapidClientImpl(String APIKey, String password, String rapidEndpoint) {
        LOGGER.info("Initiate client with end point:" + rapidEndpoint);
        this.APIKey = APIKey;
        this.password = password;
        this.rapidEndpoint = rapidEndpoint;
        this.debug = false;
        validateAPIParam();
    }

    public void setCredentials(String APIKey, String password) {
        this.APIKey = APIKey;
        this.password = password;
        validateAPIParam();
    }

    public void setEndpoint(String endpoint) {
        this.rapidEndpoint = endpoint;
        validateAPIParam();
    }

    public void setDebug(boolean debug) {
        LOGGER.info("eWAY Rapid SDK debug mode set to " + debug);
        this.debug = debug;
    }

    /**
     * Checks the API credentials are present and valid
     */
    private void validateAPIParam() {
        isValid = true;
        if (StringUtils.isBlank(APIKey) || StringUtils.isBlank(password)) {
            addErrorCode(Constant.API_KEY_INVALID_ERROR_CODE);
            isValid = false;
        }
        if (StringUtils.isBlank(rapidEndpoint)) {
            addErrorCode(Constant.LIBRARY_NOT_HAVE_ENDPOINT_ERROR_CODE);
            isValid = false;
        }
        if (isValid) {
            try {
                parserRapidEnpointToGetWebUrl();
                if (listError != null) {
                    listError.clear();
                }
                isValid = true;
                LOGGER.info("Initiate client[" + rapidEndpoint + "] successful!");
            } catch (Exception e) {
                LOGGER.error("Error loading or connecting to endpoint", e);
                isValid = false;
                addErrorCode(Constant.LIBRARY_NOT_HAVE_ENDPOINT_ERROR_CODE);
            }
        } else {
            LOGGER.warn("Rapid client [" + rapidEndpoint + "] has invalid credentials");
        }
    }

    /**
     * Load Rapid endpoint URL
     *
     * @throws Exception if loading properties fails
     */
    private void parserRapidEnpointToGetWebUrl() throws Exception {
        String propName = null;
        if (Constant.RAPID_ENDPOINT_PRODUCTION.equalsIgnoreCase(rapidEndpoint)) {
            propName = Constant.GLOBAL_RAPID_PRODUCTION_REST_URL_PARAM;
        } else if (Constant.RAPID_ENDPOINT_SANDBOX.equalsIgnoreCase(rapidEndpoint)) {
            propName = Constant.GLOBAL_RAPID_SANDBOX_REST_URL_PARAM;
        }
        if (StringUtils.isBlank(propName)) {
            webUrl = rapidEndpoint;
        } else {
            Properties prop = ResourceUtil.loadProperiesOnResourceFolder(Constant.RAPID_API_RESOURCE);
            webUrl = prop.getProperty(propName);
            if (StringUtils.isBlank(webUrl)) {
                throw new Exception("The endpoint " + propName + " is invalid.");
            }
        }
        verifyEndpointUrl(webUrl);
    }

    /**
     * Check Rapid end point URL
     *
     * @param endpointUrl the URL to check
     * @throws Exception if connection check fails
     */
    private void verifyEndpointUrl(String endpointUrl) throws Exception {
        URL url = new URL(endpointUrl);
        URLConnection conn = url.openConnection();
        conn.connect();
    }

    public CreateTransactionResponse create(PaymentMethod paymentMethod, Transaction transaction) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    CreateTransactionResponse.class);
        }
        try {
            MessageProcess<Transaction, CreateTransactionResponse> process = null;
            switch (paymentMethod) {
                case Direct:
                    process = new TransDirectPaymentMsgProcess(getEwayWebResource(), Constant.DIRECT_PAYMENT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case ResponsiveShared:
                    process = new TransResponsiveSharedMsgProcess(getEwayWebResource(), Constant.RESPONSIVE_SHARED_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case TransparentRedirect:
                    process = new TransTransparentRedirectMsgProcess(getEwayWebResource(), Constant.TRANSPARENT_REDIRECT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case Wallet:
                    if (transaction.isCapture()) {
                        process = new TransDirectPaymentMsgProcess(getEwayWebResource(), Constant.DIRECT_PAYMENT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                        break;
                    } else {
                        process = new CapturePaymentMsgProcess(getEwayWebResource(), Constant.CAPTURE_PAYMENT_METHOD);
                        break;
                    }
                case Authorisation:
                    process = new CapturePaymentMsgProcess(getEwayWebResource(), Constant.CAPTURE_PAYMENT_METHOD);
                    break;
                default:
                    return makeResponseWithException(new ParameterInvalidException("Unsupported Payment Method"), CreateTransactionResponse.class);
            }
            return process.doWork(transaction);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, CreateTransactionResponse.class);
        }
    }

    public CreateCustomerResponse create(PaymentMethod PaymentMethod, Customer customer) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    CreateCustomerResponse.class);
        }
        try {
            MessageProcess<Customer, CreateCustomerResponse> process = null;
            switch (PaymentMethod) {
                case Direct:
                    process = new CustDirectPaymentMsgProcess(getEwayWebResource(), Constant.DIRECT_PAYMENT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case ResponsiveShared:
                    process = new CustResponsiveSharedMsgProcess(getEwayWebResource(), Constant.RESPONSIVE_SHARED_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case TransparentRedirect:
                    process = new CustTransparentRedirectMsgProcess(getEwayWebResource(), Constant.TRANSPARENT_REDIRECT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                default:
                    return makeResponseWithException(new ParameterInvalidException("Unsupported Payment Method"), CreateCustomerResponse.class);
            }
            return process.doWork(customer);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, CreateCustomerResponse.class);
        }
    }

    public CreateCustomerResponse update(PaymentMethod paymentMethod, Customer customer) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("APIKey, password or rapid endpoint param had been null or empty"),
                    CreateCustomerResponse.class);
        }
        try {
            MessageProcess<Customer, CreateCustomerResponse> process = null;
            switch (paymentMethod) {
                case Direct:
                    process = new CustDirectUpdateMsgProcess(getEwayWebResource(), Constant.DIRECT_PAYMENT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case ResponsiveShared:
                    process = new CustResponsiveUpdateMsgProcess(getEwayWebResource(), Constant.RESPONSIVE_SHARED_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                case TransparentRedirect:
                    process = new CustTransparentUpdateMsgProcess(getEwayWebResource(), Constant.TRANSPARENT_REDIRECT_METHOD_NAME.concat(Constant.JSON_SUFIX));
                    break;
                default:
                    return makeResponseWithException(new ParameterInvalidException("Not support this payment type"), CreateCustomerResponse.class);
            }
            return process.doWork(customer);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, CreateCustomerResponse.class);
        }
    }

    public QueryTransactionResponse queryTransaction(int transactionId) {
        return queryTransaction(String.valueOf(transactionId));
    }

    public QueryTransactionResponse queryTransaction(String accessCode) {
        return queryTransactionWithPath(accessCode, Constant.TRANSACTION_METHOD);
    }

    /**
     * Completes the query transaction request
     *
     * @param request The transaction ID or Access Code
     * @param requestPath The request path
     * @return The transaction query response
     */
    private QueryTransactionResponse queryTransactionWithPath(String request, String... requestPath) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    QueryTransactionResponse.class);
        }
        try {
            MessageProcess<String, QueryTransactionResponse> process = new TransQueryMsgProcess(getEwayWebResource(), requestPath);
            return process.doWork(request);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, QueryTransactionResponse.class);
        }
    }

    public QueryTransactionResponse queryTransaction(TransactionFilter filter) {
        Integer indexOfValue = filter.calculateIndexOfValue();
        if (indexOfValue == null) {
            return makeResponseWithException(new APIKeyInvalidException("Invalid transaction filter input"), QueryTransactionResponse.class);
        }

        switch (indexOfValue) {
            case TransactionFilter.TRANSACTION_ID_INDEX:
                return queryTransaction(String.valueOf(filter.getTransactionId()));
            case TransactionFilter.ACCESS_CODE_INDEX:
                return queryTransaction(filter.getAccessCode());
            case TransactionFilter.INVOICE_NUMBER_INDEX:
                return queryTransactionWithPath(filter.getInvoiceNumber(), Constant.TRANSACTION_METHOD, Constant.TRANSACTION_QUERY_WITH_INVOICE_NUM_METHOD);
            case TransactionFilter.INVOICE_REFERENCE_INDEX:
                return queryTransactionWithPath(filter.getInvoiceReference(), Constant.TRANSACTION_METHOD, Constant.TRANSACTION_QUERY_WITH_INVOICE_REF_METHOD);
        }
        return makeResponseWithException(new APIKeyInvalidException("Unsupported transaction filter"), QueryTransactionResponse.class);
    }

    public QueryCustomerResponse queryCustomer(long tokenCustomerID) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    QueryCustomerResponse.class);
        }
        try {
            MessageProcess<String, QueryCustomerResponse> process = new QueryCustomerMsgProcess(getEwayWebResource(),
                    Constant.DIRECT_CUSTOMER_SEARCH_METHOD.concat(Constant.JSON_SUFIX));
            return process.doWork(String.valueOf(tokenCustomerID));
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, QueryCustomerResponse.class);
        }

    }

    public RefundResponse refund(Refund refund) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    RefundResponse.class);
        }
        try {
            MessageProcess<Refund, RefundResponse> process = null;
            process = new RefundMsgProcess(getEwayWebResource(), Constant.TRANSACTION_METHOD);
            return process.doWork(refund);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, RefundResponse.class);
        }
    }

    public RefundResponse cancel(Refund refund) {
        if (!isValid()) {
            return makeResponseWithException(new APIKeyInvalidException("API Key, Password or Rapid endpoint is invalid"),
                    RefundResponse.class);
        }
        try {
            MessageProcess<Refund, RefundResponse> process = new CancelAuthorisationMsgProcess(getEwayWebResource(), Constant.CANCEL_AUTHORISATION_METHOD);
            return process.doWork(refund);
        } catch (RapidSdkException e) {
            LOGGER.error(e.getMessage());
            return makeResponseWithException(e, RefundResponse.class);
        }
    }

    public String getRapidEndpoint() {
        return rapidEndpoint;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrors() {
        return listError != null ? listError : new ArrayList<String>();
    }

    /**
     * Fetches and configures a Web Resource to connect to eWAY
     *
     * @return A WebResource
     */
    private WebResource getEwayWebResource() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        client.addFilter(new HTTPBasicAuthFilter(APIKey, password));
        if (this.debug) {
            client.addFilter(new LoggingFilter(System.out));
        }
        WebResource resource = client.resource(webUrl);
        String userAgent = "";
        try {
            Properties prop = ResourceUtil.loadProperiesOnResourceFolder(Constant.RAPID_API_RESOURCE);
            userAgent = prop.getProperty(Constant.RAPID_SDK_USER_AGENT_PARAM);
            if (StringUtils.isBlank(userAgent)) {
                throw new Exception("Resource file " + Constant.RAPID_API_RESOURCE + " is invalid.");
            }
        } catch (Exception e) {
            LOGGER.error("User Agent could not be loaded", e);
        }
        resource.header("UserAgent", userAgent);
        return resource;
    }

    /**
     * Add an error code to the client
     *
     * @param errCode The error code to add
     */
    private void addErrorCode(String errCode) {
        if (errCode == null) {
            return;
        }
        if (listError == null) {
            listError = new ArrayList<String>();
            listError.add(errCode);
        } else {
            if (!listError.contains(errCode)) {
                listError.add(errCode);
            }
        }
    }

    /**
     * Generates a response with an exception
     *
     * @param <T> The response class
     * @param e A Rapid exception
     * @param c The response class
     * @return The response with an exception
     */
    private <T extends ResponseOutput> T makeResponseWithException(RapidSdkException e, Class<T> c) {

        if (this.debug) {
            e.printStackTrace();
        }

        try {
            T t;
            t = c.newInstance();
            t.getErrors().add(e.getErrorCode());
            return t;
        } catch (InstantiationException e1) {
            LOGGER.error(e1.getMessage(), e1);
        } catch (IllegalAccessException e1) {
            LOGGER.error(e1.getMessage(), e1);
        }
        return null;
    }

}
