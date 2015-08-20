package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.ShippingDetails;
import com.eway.payment.rapid.sdk.beans.external.ShippingMethod;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class ShippingDetailsToAddressConverterTest {

    private BeanConverter<ShippingDetails, ShippingAddress> convert;

    @Before
    public void setup() {
        convert = new ShippingDetailsToAddressConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        ShippingDetails detail = ObjectCreator.createShippingDetails();
        ShippingAddress address = convert.doConvert(detail);
        Assert.assertEquals("John", address.getFirstName());
        Assert.assertEquals("Sydney", address.getCity());
        Assert.assertEquals(ShippingMethod.NextDay.name(), address.getShippingMethod());
    }

    @Test
    public void testNullShippingDetail() throws RapidSdkException {
        ShippingDetails detail = null;
        ShippingAddress address = convert.doConvert(detail);
        Assert.assertNull(address.getFirstName());
    }

    @Test
    public void testNullAddress() throws RapidSdkException {
        ShippingDetails detail = ObjectCreator.createShippingDetails();
        detail.setShippingAddress(null);
        detail.setShippingMethod(null);
        ShippingAddress address = convert.doConvert(detail);
        Assert.assertNull(address.getCity());
    }

    @After
    public void tearDown() {

    }
}
