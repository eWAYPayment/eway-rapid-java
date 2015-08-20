package com.eway.payment.rapid.sdk.exception;

import com.eway.payment.rapid.sdk.util.Constant;

public class SystemErrorException extends RapidSdkException {

    private static final long serialVersionUID = 852475063038180563L;

    public SystemErrorException(String message) {
        super(Constant.INTERNAL_RAPID_SERVER_ERROR_CODE, message);
    }

    public SystemErrorException(String message, Throwable t) {
        super(Constant.INTERNAL_RAPID_SERVER_ERROR_CODE, message, t);
    }

}
