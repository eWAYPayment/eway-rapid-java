package com.eway.payment.rapid.sdk.exception;

import com.eway.payment.rapid.sdk.util.Constant;

/**
 * API Key invalid exception
 */
public class APIKeyInvalidException extends RapidSdkException {

    private static final long serialVersionUID = 550808787239714509L;

    public APIKeyInvalidException(String message) {
        super(Constant.API_KEY_INVALID_ERROR_CODE, message);
    }

}
