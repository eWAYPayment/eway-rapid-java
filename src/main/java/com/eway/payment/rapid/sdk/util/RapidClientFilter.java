package com.eway.payment.rapid.sdk.util;

import com.eway.payment.rapid.sdk.RapidClient;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import javax.ws.rs.core.HttpHeaders;

/**
 * Filter for WebResource to add Rapid headers
 */
public class RapidClientFilter extends ClientFilter {
    
    private String apiVersion;
    private static final Logger LOGGER = LoggerFactory.getLogger(RapidClient.class);
    
    public void setVersion(String version) {
        this.apiVersion = version;
    }
    
    @Override
    public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
        String userAgent = "";
        try {
            Properties prop = ResourceUtil.loadProperiesOnResourceFolder(Constant.RAPID_API_RESOURCE);
            userAgent = prop.getProperty(Constant.RAPID_SDK_USER_AGENT_PARAM);
            if (StringUtils.isBlank(userAgent)) {
                throw new Exception("Resource file " + Constant.RAPID_API_RESOURCE + " is invalid.");
            }
        } catch (Exception e) {
            LOGGER.error("User Agent could not be loaded", e);
        }
        
        request.getHeaders().putSingle(HttpHeaders.USER_AGENT, userAgent);
        if (this.apiVersion != null) {
            request.getHeaders().putSingle("X-EWAY-APIVERSION", this.apiVersion);
        }
        return getNext().handle(request);
    }
}
