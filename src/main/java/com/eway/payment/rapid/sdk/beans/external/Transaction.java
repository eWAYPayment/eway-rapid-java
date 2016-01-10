package com.eway.payment.rapid.sdk.beans.external;

import java.util.List;

/**
 * The details of a transaction
 *
 */
public class Transaction {

    private TransactionType transactionType;

    private boolean capture = true;

    private Customer customer;

    private ShippingDetails shippingDetails;

    private PaymentDetails paymentDetails;

    private List<LineItem> lineItems;

    private List<String> options;

    private String tokenCustomerID;

    private String deviceID;

    private String partnerID;

    private String thirdPartyWalletID;

    private Integer authTransactionID;

    private String redirectURL;

    private String cancelURL;

    private String checkoutURL;

    private boolean checkoutPayment;

    private String customView;

    private String headerText;

    private String language;

    private Boolean customerReadOnly;

    private Boolean verifyCustomerPhone;

    private Boolean verifyCustomerEmail;

    private String logoUrl;

    private boolean saveCustomer = false;

    /**
     * Return type of transaction (Purchase, MOTO,etc)
     *
     * @return Transaction type
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Set transaction type (e.g. Purchase, MOTO,etc)
     *
     * @param transactionType Transaction type
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Return capture status of transaction
     *
     * @return Transaction capture status
     */
    public boolean isCapture() {
        return capture;
    }

    /**
     * Set to true to create a regular transaction with immediate capture. Set
     * to false to create an Authorisation transaction that can be used in a
     * subsequent authorisation. Note: authorisation is not available in UK or
     * NZ at this time.
     *
     * @param capture Capture flag (defaults to <code>true</code>)
     */
    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    /**
     * Return customer details (name, address, token etc.)
     *
     * @return Customer details
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set customer details (name, address, token etc.)
     *
     * @param customer Customer details
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Return the Shipping Address, name etc. for the product ordered with this
     * transaction
     *
     * @return Shipping address
     */
    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    /**
     * Set shipping detail
     *
     * @param shippingDetails Shipping Address, name etc for this transaction
     */
    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    /**
     * Return payment details (amount, currency and invoice information)
     *
     * @return payment details
     */
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Set payment details
     *
     * @param paymentDetails Payment details (amount, currency and invoice
     * information)
     */
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * Return Invoice Line Items for the purchase (optional)
     *
     * @return List of LineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * Set a list of invoice Line Items for the purchase (optional)
     *
     * @param lineItems List of LineItems
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Return the options for the transaction
     *
     * @return List of options
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Set the options for the transaction
     *
     * @param options List of Options for the transaction
     */
    public void setOptions(List<String> options) {
        this.options = options;
    }

    /**
     * Return an Token ID for the customer from a transaction
     *
     * @return token customer ID
     */
    public String getTokenCustomerID() {
        return tokenCustomerID;
    }

    /**
     * Set token customer id
     *
     * @param tokenCustomerID The customer's token ID
     */
    public void setTokenCustomerID(String tokenCustomerID) {
        this.tokenCustomerID = tokenCustomerID;
    }

    /**
     * Return an identifier for the device sending the transaction
     *
     * @return Device ID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Set an identifier for the device sending the transaction
     *
     * @param deviceID an identifier for the device
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Return the partner ID
     *
     * @return The partner ID
     */
    public String getPartnerID() {
        return partnerID;
    }

    /**
     * Set partner id
     *
     * @param partnerID Partner ID
     */
    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    /**
     * Return a Third Party Digital wallet which will be supplying the Card
     * Details (optional)
     *
     * @return a Third Party Digital wallet ID
     */
    public String getThirdPartyWalletID() {
        return thirdPartyWalletID;
    }

    /**
     * Set the third party waller ID
     *
     * @param thirdPartyWalletID a Third Party Digital wallet ID
     */
    public void setThirdPartyWalletID(String thirdPartyWalletID) {
        this.thirdPartyWalletID = thirdPartyWalletID;
    }

    /**
     * This specifies the original authorisation transaction ID that funds are
     * to be captured from
     *
     * @return authTransactionID Authorisation Transaction ID
     */
    public Integer getAuthTransactionID() {
        return authTransactionID;
    }

    /**
     * Set the original authorisation transaction ID that funds are to be
     * captured from
     *
     * @param authTransactionID Authorisation Transaction ID
     */
    public void setAuthTransactionID(Integer authTransactionID) {
        this.authTransactionID = authTransactionID;
    }

    /**
     * Return the URL on the merchant's site that the RapidAPI will redirect the
     * customer's browser to after processing the transaction.
     *
     * @return the Redirect URL
     */
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     * Set the URL on the merchant's site that the RapidAPI will redirect the
     * customer's browser to after processing the transaction.
     *
     * @param redirectURL the Redirect URL
     */
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    /**
     * Return the URL on the merchant's site that the RapidAPI will redirect the
     * customer's browser to if they cancel the transaction (Responsive Shared
     * Page only).
     *
     * @return the Cancel URL
     */
    public String getCancelURL() {
        return cancelURL;
    }

    /**
     * Set the URL on the merchant's site that the RapidAPI will redirect the
     * customer's browser to if they cancel the transaction (Responsive Shared
     * Page only).
     *
     * @param cancelURL the Cancel URL
     */
    public void setCancelURL(String cancelURL) {
        this.cancelURL = cancelURL;
    }

    /**
     * Return the URL that used for the integrating PayPal Checkout.
     *
     * @return The PayPal Checkout URL
     */
    public String getCheckoutURL() {
        return checkoutURL;
    }

    /**
     * Set the URL that used for the integrating PayPal Checkout.
     *
     * @param checkoutURL The PayPal Checkout URL
     */
    public void setCheckoutURL(String checkoutURL) {
        this.checkoutURL = checkoutURL;
    }

    /**
     * Return the flag to set if the PayPal Checkout should be used for this
     * transaction
     *
     * @return PayPal Checkout boolean
     */
    public boolean isCheckoutPayment() {
        return checkoutPayment;
    }

    /**
     * Set the flag to set if the PayPal Checkout should be used for this
     * transaction
     *
     * @param checkoutPayment PayPal Checkout boolean
     */
    public void setCheckoutPayment(boolean checkoutPayment) {
        this.checkoutPayment = checkoutPayment;
    }

    /**
     * Get the custom view for the transaction
     *
     * @return the custom view
     */
    public String getCustomView() {
        return customView;
    }

    /**
     * Set the custom view for the Responsive Shared Page.
     * One of: Bootstrap,
     * BootstrapAmelia, BootstrapCerulean, BootstrapCosmo, BootstrapCyborg,
     * BootstrapFlatly, BootstrapJournal, BootstrapReadable, BootstrapSimplex,
     * BootstrapSlate, BootstrapSpacelab, BootstrapUnited
     *
     * @param customView the custom view
     */
    public void setCustomView(String customView) {
        this.customView = customView;
    }

    /**
     * Set the header text to be displayed on the Responsive Shared Page
     *
     * @return the header text
     */
    public String getHeaderText() {
        return headerText;
    }

    /**
     * The header text to be displayed on the Responsive Shared Page
     *
     * @param headerText the header text
     */
    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    /**
     * Get the language code which determines the language that the shared page
     * will be displayed in. One of: "EN" (English, default) or "ES" (Spanish)
     *
     * @return The language code
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the language code which determines the language that the shared page
     * will be displayed in. One of: "EN" (English, default) or "ES" (Spanish)
     *
     * @param language The language code
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * When set to false, customers will be able to edit the information on the
     * Responsive Shared Page, even if it is sent through in the server side
     * request. To fetch the details the customer entered, do a Transaction
     * Query once the transaction is complete.
     *
     * @return the Customer Read Only boolean
     */
    public Boolean getCustomerReadOnly() {
        return customerReadOnly;
    }

    /**
     * When set to false, customers will be able to edit the information on the
     * Responsive Shared Page, even if it is sent through in the server side
     * request. To fetch the details the customer entered, do a Transaction
     * Query once the transaction is complete.
     *
     * @param customerReadOnly the Customer Read Only boolean
     */
    public void setCustomerReadOnly(Boolean customerReadOnly) {
        this.customerReadOnly = customerReadOnly;
    }

    /**
     * Get if the customer's phone number should be confirmed using Beagle
     * Verify
     *
     * @return Beagle Verify Phone boolean
     */
    public Boolean getVerifyCustomerPhone() {
        return verifyCustomerPhone;
    }

    /**
     * Set whether the customer's phone number should be confirmed using Beagle
     * Verify
     *
     * @param verifyCustomerPhone Beagle Verify Phone boolean
     */
    public void setVerifyCustomerPhone(Boolean verifyCustomerPhone) {
        this.verifyCustomerPhone = verifyCustomerPhone;
    }

    /**
     * Get whether the customer's email should be confirmed using Beagle Verify
     *
     * @return Beagle Verify Email boolean
     */
    public Boolean getVerifyCustomerEmail() {
        return verifyCustomerEmail;
    }

    /**
     * Set whether the customer's email should be confirmed using Beagle Verify
     *
     * @param verifyCustomerEmail Beagle Verify Email boolean
     */
    public void setVerifyCustomerEmail(Boolean verifyCustomerEmail) {
        this.verifyCustomerEmail = verifyCustomerEmail;
    }

    /**
     * Get the URL of the merchant's logo to display on the shared page. This
     * must start with https://. If blank or omitted, the logo defined in the
     * Shared Page settings in MYeWAY will be used.
     *
     * @return The URL of the merchant's logo to display on the shared page
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Set the URL of the merchant's logo to display on the shared page. This
     * must start with https://. If blank or omitted, the logo defined in the
     * Shared Page settings in MYeWAY will be used.
     *
     * @param logoUrl The URL of the merchant's logo to display on the shared
     * page
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * Get if a Token Customer should be created when a payment is completed
     * while using the Responsive Shared Page or Transparent Redirect.
     *
     * @return True if a Token Customer should be created
     */
    public boolean isSaveCustomer() {
        return saveCustomer;
    }

    /**
     * Set if a Token Customer should be created when a payment is completed
     * while using the Responsive Shared Page or Transparent Redirect.
     *
     * @param saveCustomer Set to true to create a token after a payment
     */
    public void setSaveCustomer(boolean saveCustomer) {
        this.saveCustomer = saveCustomer;
    }

}
