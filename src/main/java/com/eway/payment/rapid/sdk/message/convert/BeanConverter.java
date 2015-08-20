package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.exception.RapidSdkException;

/**
 * The convert interface that defines bean convert method
 *
 * @param <U> : Input generic convert class
 * @param <V> : Output generic convert class
 */
public interface BeanConverter<U, V> {

    /**
     * @param u : input bean
     * @return V: output bean
     * @throws RapidSdkException base SDK exception
     */
    V doConvert(U u) throws RapidSdkException;
}
