package com.eway.payment.rapid.sdk.exception;

import com.eway.payment.rapid.sdk.util.Constant;

/**
 * Define invalid parameter exception
 *
 */
public class ParameterInvalidException extends RapidSdkException {

    private static final long serialVersionUID = 8156273343136137656L;

    public ParameterInvalidException(String message) {
        super(Constant.INTERNAL_RAPID_API_ERROR_CODE, message);
    }

    public ParameterInvalidException(String message, Throwable t) {
        super(Constant.INTERNAL_RAPID_API_ERROR_CODE, message, t);
    }

}
