package com.eway.payment.rapid.sdk.beans.external;

/**
 * Payment method enumeration. 
 * The method that a transaction is completed with. One of:
 * <ul>
 * <li>{@link #Direct} - Direct Payment</li>
 * <li>{@link #ResponsiveShared} - Responsive Shared Page</li>
 * <li>{@link #TransparentRedirect} - Transparent Redirect</li>
 * <li>{@link #Wallet} - Wallet (Visa Checkout)</li>
 * <li>{@link #Authorisation} - Capture authorisation</li>
 * </ul>
 */
public enum PaymentMethod {
    /**
     * Direct Payment - The transaction is sent directly to eWAY Rapid and the
     * result returned immediately.
     */
    Direct,
    
    /**
     * Responsive Shared Page - Creating a transaction will supply a URL to redirect
     * the customer to to complete the transaction.
     */
    ResponsiveShared,
    
    /**
     * Transparent Redirect - Creating a transaction will supply a Form URL and 
     * to Access Code send customer's card data to directly.
     */
    TransparentRedirect,
    
    /**
     * Wallet - Currently used to pass the Visa Checkout ID.
     */
    Wallet,
    
    /**
     * Authorisation - capture the funds held by a previous pre-auth transaction
     */
    Authorisation
}
