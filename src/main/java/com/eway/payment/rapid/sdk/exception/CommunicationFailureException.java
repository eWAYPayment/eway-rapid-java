package com.eway.payment.rapid.sdk.exception;

import com.eway.payment.rapid.sdk.util.Constant;

public class CommunicationFailureException extends RapidSdkException {

    private static final long serialVersionUID = 8857227165097343287L;

    public CommunicationFailureException(String message, Throwable t) {
        super(Constant.COMMUNICATION_FAILURE_ERROR_CODE, message, t);
    }

}
