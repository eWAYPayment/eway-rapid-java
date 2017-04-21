package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccessCodeSharedRequest extends Request {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Customer")
    private Customer customer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingMethod")
    private String shippingMethod;

    @JsonProperty("Items")
    private LineItem[] items = new LineItem[0];

    @JsonProperty("Options")
    private Option[] options = new Option[3];

    @JsonProperty("Payment")
    private Payment payment;

    @JsonProperty("RedirectUrl")
    private String redirectUrl;

    @JsonProperty("CancelUrl")
    private String cancelUrl;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CheckoutUrl")
    private String checkoutUrl;

    @JsonProperty("Method")
    private String method;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("DeviceID")
    private String deviceID;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CustomerIP")
    private String customerIP;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LogoUrl")
    private String logoUrl;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("HeaderText")
    private String headerText;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("PartnerID")
    private String partnerID;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Language")
    private String language;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CustomerReadOnly")
    private Boolean customerReadOnly;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CustomView")
    private String customView;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("VerifyCustomerPhone")
    private Boolean verifyCustomerPhone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("VerifyCustomerEmail")
    private Boolean verifyCustomerEmail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CheckoutPayment")
    private Boolean checkoutPayment;

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

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
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
        if (payment == null) {
            payment = new Payment();
        }
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getCustomerReadOnly() {
        return customerReadOnly;
    }

    public void setCustomerReadOnly(Boolean customerReadOnly) {
        this.customerReadOnly = customerReadOnly;
    }

    public String getCustomView() {
        return customView;
    }

    public void setCustomView(String customView) {
        this.customView = customView;
    }

    public Boolean getVerifyCustomerPhone() {
        return verifyCustomerPhone;
    }

    public void setVerifyCustomerPhone(Boolean verifyCustomerPhone) {
        this.verifyCustomerPhone = verifyCustomerPhone;
    }

    public Boolean getVerifyCustomerEmail() {
        return verifyCustomerEmail;
    }

    public void setVerifyCustomerEmail(Boolean verifyCustomerEmail) {
        this.verifyCustomerEmail = verifyCustomerEmail;
    }

    public Boolean getCheckoutPayment() {
        return checkoutPayment;
    }

    public void setCheckoutPayment(Boolean checkoutPayment) {
        this.checkoutPayment = checkoutPayment;
    }

}
