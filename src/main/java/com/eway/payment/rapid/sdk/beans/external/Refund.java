package com.eway.payment.rapid.sdk.beans.external;

import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import java.util.List;

/**
 * Combines all the high level properties required to process a refund (or
 * Authorisation Cancel)
 *
 */
public class Refund {

    private Customer customer;
    private ShippingDetails shippingDetails;
    private RefundDetails refundDetails;
    private List<LineItem> lineItems;
    private List<Option> options;
    private String deviceID;
    private String partnerID;

    /**
     * Return the customer's details
     *
     * @return Customer details
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set customer's information
     *
     * @param customer Customer details
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Return shipping address, name etc for this transaction
     *
     * @return Shipping Details
     */
    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    /**
     * Set shipping detailed information
     *
     * @param shippingDetails detailed shipping information
     */
    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    /**
     * Return details of the transaction (amount, currency and invoice
     * information)
     *
     * @return Refund detail
     */
    public RefundDetails getRefundDetails() {
        return refundDetails;
    }

    /**
     * Set details of the transaction (amount, currency and invoice
     * information)
     *
     * @param refundDetails Refund detail
     */
    public void setRefundDetails(RefundDetails refundDetails) {
        this.refundDetails = refundDetails;
    }

    /**
     * Invoice Line Items for the purchase (optional)
     *
     * @return List of LineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * Set the Invoice Line Items for the purchase (optional)
     * @param lineItems List of LineItems
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Return general options for the transaction (optional)
     *
     * @return List of options
     */
    public List<Option> getOptions() {
        return options;
    }

    /**
     * Set general options for the transaction (optional)
     *
     * @param options List of options
     */
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    /**
     * Return an identifier for the device sending the transaction (optional)
     *
     * @return Device ID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Set an identifier for the device sending the transaction (optional)
     * @param deviceID the Device ID
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Return the ID used by shopping carts/ partners (optional).
     *
     * @return Partner ID
     */
    public String getPartnerID() {
        return partnerID;
    }

    /**
     * Set the ID used by shopping carts/ partners (optional).
     * @param partnerID Partner ID
     */
    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

}
