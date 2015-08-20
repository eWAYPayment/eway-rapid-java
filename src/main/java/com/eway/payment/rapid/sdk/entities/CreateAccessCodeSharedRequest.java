package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateAccessCodeSharedRequest extends Request {

    @JsonProperty("Customer")
    private Customer customer;

    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

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

    @JsonProperty("CheckoutUrl")
    private String checkoutUrl;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("DeviceID")
    private String deviceID;

    @JsonProperty("CustomerIP")
    private String customerIP;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("LogoUrl")
    private String logoUrl;

    @JsonProperty("HeaderText")
    private String headerText;

    @JsonProperty("PartnerID")
    private String partnerID;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("CustomerReadOnly")
    private Boolean customerReadOnly;

    @JsonProperty("CustomView")
    private String customView;

    @JsonProperty("VerifyCustomerPhone")
    private Boolean verifyCustomerPhone;

    @JsonProperty("VerifyCustomerEmail")
    private Boolean verifyCustomerEmail;

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
