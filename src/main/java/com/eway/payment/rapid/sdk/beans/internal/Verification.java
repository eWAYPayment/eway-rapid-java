package com.eway.payment.rapid.sdk.beans.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification {

    @JsonProperty("CVN")
    private String CVN;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Mobile")
    private String mobile;

    @JsonProperty("Phone")
    private String phone;

    public String getCVN() {
        return CVN;
    }

    @JsonProperty("CVN")
    public void setCVN(String cvn) {
        CVN = cvn;
    }

    public String getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    @JsonProperty("Mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
