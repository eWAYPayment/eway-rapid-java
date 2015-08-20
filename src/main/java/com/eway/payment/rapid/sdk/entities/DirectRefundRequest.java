package com.eway.payment.rapid.sdk.entities;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.internal.Customer;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import org.codehaus.jackson.annotate.JsonProperty;

public class DirectRefundRequest extends Request {

    @JsonProperty("Customer")
    public Customer customer;

    @JsonProperty("ShippingAddress")
    public ShippingAddress shippingAddress;

    @JsonProperty("Refund")
    public RefundDetails refund;

    @JsonProperty("LineItems")
    public LineItem[] items = new LineItem[0];

    @JsonProperty("Options")
    public Option[] options = new Option[0];

    @JsonProperty("DeviceID")
    public String deviceID;

    @JsonProperty("CustomerIP")
    public String customerIP;

    @JsonProperty("PartnerID")
    public String partnerID;

    public RefundDetails getRefund() {
        return refund;
    }

    public void setRefund(RefundDetails refund) {
        this.refund = refund;
    }

    public DirectRefundRequest() {
        customer = new Customer();
        shippingAddress = new ShippingAddress();
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

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }
}
