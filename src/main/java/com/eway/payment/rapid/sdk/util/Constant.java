package com.eway.payment.rapid.sdk.util;

public class Constant {

    // Json suffix
    public static final String JSON_SUFIX = ".json";

    // Internal error code
    public static final String LIBRARY_NOT_HAVE_ENDPOINT_ERROR_CODE = "S9990";
    public static final String API_KEY_INVALID_ERROR_CODE = "S9991";
    public static final String COMMUNICATION_FAILURE_ERROR_CODE = "S9992";
    public static final String AUTHENTICATION_FAILURE_ERROR_CODE = "S9993";
    public static final String INTERNAL_RAPID_API_ERROR_CODE = "S9995";
    public static final String INTERNAL_RAPID_SERVER_ERROR_CODE = "S9996";

    //Property file details
    public static final String ERROR_CODE_RESOURCE_EN = "err_code_resource_en.properties";
    public static final String RAPID_API_RESOURCE = "rapid-api.properties";
    public static final String RAPID_SDK_USER_AGENT_PARAM = "rapid.sdk.user.agent";
    public static final String GLOBAL_RAPID_PRODUCTION_REST_URL_PARAM = "global.rapid.rest.production.url";
    public static final String GLOBAL_RAPID_SANDBOX_REST_URL_PARAM = "global.rapid.rest.sandbox.url";
    public static final String RAPID_ENDPOINT_SANDBOX = "Sandbox";
    public static final String RAPID_ENDPOINT_PRODUCTION = "Production";

    // End point request path 
    public static final String DIRECT_PAYMENT_METHOD_NAME = "DirectPayment";
    public static final String RESPONSIVE_SHARED_METHOD_NAME = "CreateAccessCodeShared";
    public static final String TRANSPARENT_REDIRECT_METHOD_NAME = "CreateAccessCode";
    public static final String DIRECT_REFUND_METHOD_NAME = "DirectRefund";
    public static final String CANCEL_AUTHORISATION_METHOD_NAME = "CancelAuthorisation";
    public static final String CREATE_TOKEN_CUSTOMER_METHOD = "CreateTokenCustomer";
    public static final String CANCEL_AUTHORISATION_METHOD = "CancelAuthorisation";
    public static final String TRANSACTION_METHOD = "Transaction";
    public static final String DIRECT_CUSTOMER_SEARCH_METHOD = "DirectCustomerSearch";
    public static final String TRANSACTION_QUERY_WITH_INVOICE_NUM_METHOD = "InvoiceNumber";
    public static final String TRANSACTION_QUERY_WITH_INVOICE_REF_METHOD = "InvoiceRef";
    public static final String REFUND_SUBPATH_METHOD = "Refund";
    public static final String CAPTURE_PAYMENT_METHOD = "CapturePayment";

}
