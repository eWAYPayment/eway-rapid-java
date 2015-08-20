package com.eway.payment.rapid.sdk.beans.external;

/**
 * Contains the result of all the Beagle and Payment provider verification (card
 * scheme/bank)
 */
public class VerificationResult {

    private VerifyStatus CVN;
    private VerifyStatus Address;
    private VerifyStatus Email;
    private VerifyStatus Mobile;
    private VerifyStatus Phone;
    private BeagleVerifyStatus BeagleEmail;
    private BeagleVerifyStatus BeaglePhone;

    /**
     * Return result of CVN Verification by card processor (unused)
     *
     * @return Card CVN verification
     */
    public VerifyStatus getCVN() {
        return CVN;
    }

    /**
     * @param CVN Card CVN verification
     */
    public void setCVN(VerifyStatus CVN) {
        this.CVN = CVN;
    }

    /**
     * Return result of Address Verification by card processor (unused)
     *
     * @return Result of Address Verification
     */
    public VerifyStatus getAddress() {
        return Address;
    }

    /**
     * @param address Address verification status
     */
    public void setAddress(VerifyStatus address) {
        Address = address;
    }

    /**
     * Return result of email verification by card processor (unused)
     *
     * @return Result of email verification
     */
    public VerifyStatus getEmail() {
        return Email;
    }

    /**
     * @param email Result of email verification
     */
    public void setEmail(VerifyStatus email) {
        Email = email;
    }

    /**
     * Return result of Mobile verification by card processor (unused)
     *
     * @return Result of Mobile verification
     */
    public VerifyStatus getMobile() {
        return Mobile;
    }

    /**
     * @param mobile Result of Mobile verification
     */
    public void setMobile(VerifyStatus mobile) {
        Mobile = mobile;
    }

    /**
     * Result of phone verification by card processor (unused)
     *
     * @return Result of phone verification
     */
    public VerifyStatus getPhone() {
        return Phone;
    }

    /**
     * @param phone Result of phone verification
     */
    public void setPhone(VerifyStatus phone) {
        Phone = phone;
    }

    /**
     * Return result of Beagle Verify email verification from Responsive Shared
     * Page
     *
     * @return Result of email verification from Responsive Shared Page
     */
    public BeagleVerifyStatus getBeagleEmail() {
        return BeagleEmail;
    }

    /**
     * @param beagleEmail Result of email verification from Responsive Shared
     * Page
     */
    public void setBeagleEmail(BeagleVerifyStatus beagleEmail) {
        BeagleEmail = beagleEmail;
    }

    /**
     * Return result of Beagle Verify phone number verification from Responsive
     * Shared Page
     *
     * @return Result of phone number verification from Responsive Shared Page
     */
    public BeagleVerifyStatus getBeaglePhone() {
        return BeaglePhone;
    }

    /**
     * @param beaglePhone Result of phone number verification from responsive
     * Shared Page
     */
    public void setBeaglePhone(BeagleVerifyStatus beaglePhone) {
        BeaglePhone = beaglePhone;
    }
}
