package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DirectPaymentRequest extends Request {

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("Customer")
    private Customer customer;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

    @JsonProperty("Items")
    private LineItem[] items = new LineItem[0];

    @JsonProperty("Options")
    private Option[] options = new Option[0];

    @JsonProperty("Payment")
    private Payment payment;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("CustomerIP")
    private String customerIP;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("DeviceID")
    private String deviceID;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("PartnerID")
    private String partnerID;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("RedirectUrl")
    private String redirectUrl;
    
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("SecuredCardData")
    private String securedCardData;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LineItem[] getItems() {
        return items;
    }

    public void setItems(LineItem[] items) {
        this.items = items;
    }

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    public String getSecuredCardData() {
        return securedCardData;
    }

    public void setSecuredCardData(String securedCardData) {
        this.securedCardData = securedCardData;
    }
}
