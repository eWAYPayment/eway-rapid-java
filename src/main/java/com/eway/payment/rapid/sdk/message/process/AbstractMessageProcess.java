package com.eway.payment.rapid.sdk.message.process;

import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.AuthenticationFailureException;
import com.eway.payment.rapid.sdk.exception.CommunicationFailureException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.exception.SystemErrorException;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.MapperFeature;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;

import javax.ws.rs.core.MediaType;

/**
 * The abstract class to defines message process work flows
 *
 * @param <T> : Input generic class
 * @param <V> : Output generic class
 */
public abstract class AbstractMessageProcess<T, V> implements MessageProcess<T, V> {

    private WebResource webResource;
    private T t;
    private final List<String> listRequestPath = new ArrayList<String>();

    public String requestJson;

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public AbstractMessageProcess(WebResource resource, String... requestPath) {
        this.webResource = resource;
        if (requestPath != null) {
            listRequestPath.addAll(Arrays.asList(requestPath));
        }
    }

    public final V doWork(T input) throws RapidSdkException {
        this.t = input;
        Response response = processPostMsg(input);
        if (response != null) {
            return makeResult(response);
        }
        throw new SystemErrorException("Response object is null");
    }

    /**
     * Call Rapid API with a POST request
     *
     * @param <U> Request class
     * @param <K> Response class
     * @param request Request object
     * @param responseClass The response class used for a successful result
     * @return Instance of response class
     * @throws RapidSdkException base SDK exception
     */
    protected final <U, K> U doPost(K request, Class<U> responseClass) throws RapidSdkException {
        try {
            WebResource resource = getWebResource();
            for (String path : getRequestPath()) {
                if (!StringUtils.isBlank(path)) {
                    resource = resource.path(path);
                }
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            requestJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);

            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null,null,null);
            SSLContext oldContext = SSLContext.getDefault();
            SSLContext.setDefault(context);

            U response = resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(responseClass, request);

            SSLContext.setDefault(oldContext);

            return response;
        } catch (ClientHandlerException e) {
            throw new CommunicationFailureException("Internal system error communicating with Rapid API", e);
        } catch (UniformInterfaceException e) {
            if (e.getResponse().getStatus() == Status.UNAUTHORIZED.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.FORBIDDEN.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.NOT_FOUND.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else {
                throw new SystemErrorException(e.getMessage(), e);
            }
        } catch (IOException e) {
            throw new SystemErrorException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: no such algorithm", e);
        } catch (KeyManagementException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: key management", e);
        }
    }

    /**
     * Call Rapid API with a PUT request
     *
     * @param <U> Request class
     * @param <K> Response class
     * @param request Request object
     * @param responseClass The response class used for a successful result
     * @return Instance of response class
     * @throws RapidSdkException base SDK exception
     */
    protected final <U, K> U doPut(K request, Class<U> responseClass) throws RapidSdkException {
        try {
            WebResource resource = getWebResource();
            for (String path : getRequestPath()) {
                if (!StringUtils.isBlank(path)) {
                    resource = resource.path(path);
                }
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            requestJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);

            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null,null,null);
            SSLContext oldContext = SSLContext.getDefault();
            SSLContext.setDefault(context);

            U response = resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).put(responseClass, request);

            SSLContext.setDefault(oldContext);

            return response;

        } catch (ClientHandlerException e) {
            throw new CommunicationFailureException("Internal system error communicating with Rapid API", e);
        } catch (UniformInterfaceException e) {
            if (e.getResponse().getStatus() == Status.UNAUTHORIZED.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.FORBIDDEN.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.NOT_FOUND.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else {
                throw new SystemErrorException(e.getMessage(), e);
            }
        } catch (IOException e) {
            throw new SystemErrorException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: no such algorithm", e);
        } catch (KeyManagementException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: key management", e);
        }
    }

    /**
     * Call Rapid API with a GET request
     *
     * @param <U> Response class
     * @param request Request object
     * @param responseClass The response class used for a successful result
     * @return Instance of response class
     * @throws RapidSdkException base SDK exception
     */
    protected final <U> U doGet(String request, Class<U> responseClass) throws RapidSdkException {
        WebResource resouce = getWebResource();
        for (String p : getRequestPath()) {
            if (!StringUtils.isBlank(p)) {
                resouce = resouce.path(p);
            }
        }
        try {

            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null,null,null);
            SSLContext oldContext = SSLContext.getDefault();
            SSLContext.setDefault(context);

            U response = resouce.path(request).get(responseClass);

            SSLContext.setDefault(oldContext);

            return response;
        } catch (ClientHandlerException e) {
            throw new CommunicationFailureException("Internal system error communicating with Rapid API", e);
        } catch (UniformInterfaceException e) {
            if (e.getResponse().getStatus() == Status.UNAUTHORIZED.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.FORBIDDEN.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else if (e.getResponse().getStatus() == Status.NOT_FOUND.getStatusCode()) {
                throw new AuthenticationFailureException("Authentication failed on the endpoint", e);
            } else {
                throw new SystemErrorException(e.getMessage(), e);
            }

        } catch (NoSuchAlgorithmException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: no such algorithm", e);
        } catch (KeyManagementException e) {
            throw new CommunicationFailureException("Error using TLS 1.2 to connect to Rapid: key management", e);
        }
    }

    /**
     * Get input object
     *
     * @return Instance of input class
     */
    protected final T getInput() {
        return t;
    }

    /**
     * Get web resource request path
     *
     * @return Path of web resource
     */
    protected final List<String> getRequestPath() {
        return listRequestPath;
    }

    /**
     * Set web resource request path
     *
     * @param requestPath String to add to request path
     */
    protected final void addRequestPath(String... requestPath) {
        if (requestPath != null) {
            for (String path : requestPath) {
                if (!StringUtils.isBlank(path)) {
                    listRequestPath.add(path);
                }
            }
        }
    }

    /**
     * Post message to web service and return response object
     *
     * @param req Request object(instance of input class)
     * @return Instance of response class
     * @throws RapidSdkException base SDK exception
     */
    protected abstract Response processPostMsg(T req) throws RapidSdkException;

    /**
     * Create result from web service response object
     *
     * @param res Response object
     * @return Instance of output class
     * @throws RapidSdkException base SDK exception
     */
    protected abstract V makeResult(Response res) throws RapidSdkException;

    /**
     * Get web resource object to connect to Rapid API
     *
     * @return Web resource
     */
    protected final WebResource getWebResource() {
        return webResource;
    }

}
