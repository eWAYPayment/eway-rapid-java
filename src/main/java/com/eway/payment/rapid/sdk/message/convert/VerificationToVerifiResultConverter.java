package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.VerificationResult;
import com.eway.payment.rapid.sdk.beans.external.VerifyStatus;
import com.eway.payment.rapid.sdk.beans.internal.Verification;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class VerificationToVerifiResultConverter implements BeanConverter<Verification, VerificationResult> {

    public VerificationResult doConvert(Verification ver) throws RapidSdkException {
        VerificationResult result = new VerificationResult();
        if (ver != null) {
            result.setAddress(getVerifyStatus(ver.getAddress()));
            result.setCVN(getVerifyStatus(ver.getCVN()));
            result.setEmail(getVerifyStatus(ver.getEmail()));
            result.setMobile(getVerifyStatus(ver.getMobile()));
            result.setPhone(getVerifyStatus(ver.getPhone()));
        }
        return result;
    }

    private VerifyStatus getVerifyStatus(String status) {
        try {
            int vStatus = Integer.parseInt(status);
            for (VerifyStatus v : VerifyStatus.values()) {
                if (v.getCode() == vStatus) {
                    return v;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
