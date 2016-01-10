package com.eway.payment.rapid.sdk;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentMethod;
import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionFilter;
import com.eway.payment.rapid.sdk.entities.CreateCustomerResponse;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;
import com.eway.payment.rapid.sdk.output.RefundResponse;

import java.util.List;

/**
 * The eWAY Rapid Client
 * Access eWAY Rapid functions, including transactions, tokens and refunds.
 *
 */
public interface RapidClient {

    /**
     * Change the API Key and Password the Client is configured to use
     *
     * @param APIKey Rapid API key
     * @param password Password for the API Key
     */
    void setCredentials(String APIKey, String password);
    
    /**
     * Change the eWAY Rapid endpoint. Can be one of "Production", "Sandbox" or
     * a URL.
     * 
     * @param endpoint Rapid endpoint
     */
    void setEndpoint(String endpoint);

    /**
     * Used to enable debug mode. If enabled, any errors will print a stacktrace
     * to.
     *
     * @param debug set to true to enable
     */
    void setDebug(boolean debug);

    /**
     * Create a transaction.
     * Can be an authorisation, a responsive shared page, transparent redirect,
     * or direct as the transaction method.
     *
     * @param paymentMethod Describes where the card details will be coming
     * from for this transaction (Direct, Responsive Shared, Transparent
     * Redirect etc).
     * @param transaction Request containing the transaction details
     * @return The transaction response. This will vary depending on the payment
     * method
     */
    CreateTransactionResponse create(PaymentMethod paymentMethod,
            Transaction transaction);

    /**
     * Creates a token customer to store card details in the secure eWAY Vault
     * for charging later.
     *
     * @param paymentMethod Describes where the card details will be coming
     * from for this transaction (Direct, Responsive Shared, Transparent
     * Redirect etc).
     * @param customer The Customer's information
     * @return The create customer response. This will vary depending on the
     * payment method used.
     */
    CreateCustomerResponse create(PaymentMethod paymentMethod, Customer customer);

    /**
     * Gets transaction information given an eWAY Transaction ID
     *
     * @param id eWAY Transaction ID
     * @return The transaction query response
     */
    QueryTransactionResponse queryTransaction(int id);

    /**
     * Gets transaction information given an access code
     *
     * @param accessCode Access code for the transaction to query
     * @return The transaction query response
     */
    QueryTransactionResponse queryTransaction(String accessCode);

    /**
     * Used to query transaction by one of four properties transaction id, access
     * code, invoice number or invoice reference
     *
     * @param filter A TransactionFilter with the search details
     * @return The transaction query response
     */
    QueryTransactionResponse queryTransaction(TransactionFilter filter);

    /**
     * Get the details of a Token Customer.
     *
     * @param tokenCustomerID The Token Customer ID
     * @return Customer query response
     */
    QueryCustomerResponse queryCustomer(long tokenCustomerID);

    /**
     * Refunds all or part of a transaction.
     *
     * @param refund Contains information of the refund
     * @return The refund transaction response
     */
    RefundResponse refund(Refund refund);

    /**
     * Cancel a non captured transaction (an Authorisation)
     *
     * @param refund Contains information of the authorisation to cancel
     * @return The cancel transaction response
     */
    RefundResponse cancel(Refund refund);

    /**
     * Get the current Rapid endpoint
     *
     * @return Rapid endpoint
     */
    String getRapidEndpoint();

    /**
     * Get valid status of Rapid Client.
     * If the credentials or endpoint are incorrect, this will be false.
     *
     * @return The client validation status
     */
    boolean isValid();

    /**
     * Gets all errors related to the query request of this client
     *
     * @return List of error codes
     */
    List<String> getErrors();

}
