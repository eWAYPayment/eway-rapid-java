package com.eway.payment.rapid.sdk.beans.external;

/**
 * Defines the possible actions that may have been taken when/if an anti-fraud 
 * rule on the account has been triggered.
 * <ul>
 * <li>NotChallenged: Normal Transaction</li>
 * <li>Allow: Transaction was allowed</li>
 * <li>Review: Transaction was held for review</li>
 * <li>PreAuth: Transaction was held for review and pre-authed</li>
 * <li>Processed: Transaction was processed</li>
 * <li>Approved: Transaction was approved when reviewed</li>
 * <li>Block: Transaction was not approved when reviewed</li>
 * </ul>
 */
public enum FraudAction {
    NotChallenged,
    Allow,
    Review,
    PreAuth,
    Processed,
    Approved,
    Block
}

