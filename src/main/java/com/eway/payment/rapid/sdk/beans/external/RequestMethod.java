package com.eway.payment.rapid.sdk.beans.external;

/**
 * Request methods to use for a transaction. One of:
 * <ul>
 * <li>{@link #ProcessPayment}</li>
 * <li>{@link #CreateTokenCustomer}</li>
 * <li>{@link #UpdateTokenCustomer}</li>
 * <li>{@link #TokenPayment}</li>
 * <li>{@link #Authorise}</li>
 * </ul>
 */
public enum RequestMethod {

    /**
     * Process a standard payment
     */
    ProcessPayment,

    /**
     * Create a token customer
     */
    CreateTokenCustomer,

    /**
     * Update a token customer
     */
    UpdateTokenCustomer,

    /**
     * Process a payment with a Token Customer.
     * Using Responsive Shared or Transparent Redirect, this can also
     * create a new token customer.
     */
    TokenPayment,

    /**
     * Complete a pre-auth transaction - funds are only held on the customer's
     * card.
     * Not currently available in the UK or NZ.
     */
    Authorise
}
