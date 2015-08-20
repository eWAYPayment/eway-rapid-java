package com.eway.payment.rapid.sdk.message.process;

import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

import com.sun.jersey.api.client.WebResource;

/**
 * Defines the work flow to send and receive web service messages. Before
 * sending a message, create a request object from input
 *
 * @param <T> Input generic class
 * @param <V> Output generic class
 */
public abstract class AbstractMakeRequestMessageProcess<T, V> extends AbstractMessageProcess<T, V> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public AbstractMakeRequestMessageProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected final Response processPostMsg(T t) throws RapidSdkException {
        Request req = createRequest(t);
        if (req != null) {
            return sendRequest(req);
        }
        return null;
    }

    /**
     * The definition method that indicates subclass must override to create
     * request object
     *
     * @param t Input object (Mapping with generic input class)
     * @return The request object to send
     * @throws RapidSdkException base SDK exception
     */
    protected abstract Request createRequest(T t) throws RapidSdkException;

    /**
     * The abstract method defining the sending request message
     *
     * @param req Request object
     * @return Response object
     * @throws RapidSdkException base SDK exception
     */
    protected abstract Response sendRequest(Request req) throws RapidSdkException;
}
