package com.eway.payment.rapid.sdk.beans.external;

/**
 * Transaction type
 * One of:
 * <ul>
 * <li>{@link #Purchase}</li>
 * <li>{@link #Recurring}</li>
 * <li>{@link #MOTO}</li>
 * </ul>
 */
public enum TransactionType {
    
    /**
     * Used for a single purchase where the card is present. 
     * This will require that the CVN details are supplied.
     */
    Purchase("Purchase"),
    
    /**
     * Used for a recurring transaction where the card details have been
     * stored. This transaction type should be used when charging with a Token
     * Customer
     */
    Recurring("Recurring"),
    
    /**
     * Mail order or Telephone Transaction - used when the card is
     * not present. Can also be used when charging a Token customer.
     */
    MOTO("MOTO");

    private final String name;

    TransactionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
