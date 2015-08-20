package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.VerificationResult;
import com.eway.payment.rapid.sdk.beans.external.VerifyStatus;
import com.eway.payment.rapid.sdk.beans.internal.Verification;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class VerificationToVerifiResultConverterTest {

    private BeanConverter<Verification, VerificationResult> convert;

    @Before
    public void setup() {
        convert = new VerificationToVerifiResultConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Verification v = ObjectCreator.createVerification();
        VerificationResult vr = convert.doConvert(v);
        Assert.assertEquals(VerifyStatus.Unchecked, vr.getCVN());
    }

    @Test
    public void testInvalidStatus() throws RapidSdkException {
        Verification v = ObjectCreator.createVerification();
        v.setAddress("a");
        VerificationResult result = convert.doConvert(v);
        Assert.assertEquals(result.getAddress(), null);
    }

    @After
    public void tearDown() {

    }
}
