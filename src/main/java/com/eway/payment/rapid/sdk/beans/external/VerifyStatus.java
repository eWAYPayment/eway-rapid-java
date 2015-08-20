package com.eway.payment.rapid.sdk.beans.external;

/**
 * Possible values returned from the payment providers with regards to
 * verification of card/user details
 */
public enum VerifyStatus {

    Unchecked("unchecked", 0),
    Valid("valid", 1),
    Invalid("invalid", 2);

    private int code;
    private String name;

    VerifyStatus(String name, int code) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
