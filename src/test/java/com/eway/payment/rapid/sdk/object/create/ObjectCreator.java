package com.eway.payment.rapid.sdk.object.create;

import java.util.ArrayList;
import java.util.List;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.external.ShippingDetails;
import com.eway.payment.rapid.sdk.beans.external.ShippingMethod;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.beans.internal.Verification;

public class ObjectCreator {

    public static Customer createExternalCustomer() {
        Customer customer = new Customer();
        customer.setTitle("Mr.");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setCompanyName("Example");
        customer.setJobDescription("Java Developer");
        customer.setPhone("0123456789");
        customer.setMobile("0123456789");
        customer.setUrl("http://www.ewaypayments.com");
        customer.setReference("A12345");
        customer.setFax("1234");
        customer.setRedirectUrl("http://www.eway.com.au");
        return customer;
    }

    public static Transaction createTransaction() {
        Transaction transaction = new Transaction();
        return transaction;
    }

    public static Payment createPayment() {
        Payment payment = new Payment();
        payment.setTotalAmount(1000);
        payment.setInvoiceNumber("inv 4444");
        payment.setInvoiceDescription("Individual Invoice Description");
        payment.setInvoiceReference("513456");
        payment.setCurrencyCode("AUD");
        return payment;
    }

    public static PaymentDetails createPaymentDetails() {
        PaymentDetails payment = new PaymentDetails();
        payment.setTotalAmount(1000);
        payment.setInvoiceNumber("inv 4444");
        payment.setInvoiceDescription("Individual Invoice Description");
        payment.setInvoiceReference("513456");
        payment.setCurrencyCode("AUD");
        return payment;
    }

    public static Verification createVerification() {
        Verification verification = new Verification();
        verification.setAddress("0");
        verification.setCVN("0");
        verification.setEmail("0");
        verification.setMobile("0");
        verification.setPhone("0");
        return verification;
    }

    public static CardDetails createCardDetails() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("John Smith");
        cardDetails.setNumber("4444333322221111");
        cardDetails.setExpiryMonth("12");
        cardDetails.setExpiryYear("25");
        cardDetails.setCVN("123");
        return cardDetails;
    }

    public static com.eway.payment.rapid.sdk.beans.internal.Customer createInternalCustomer() {
        com.eway.payment.rapid.sdk.beans.internal.Customer customer = new com.eway.payment.rapid.sdk.beans.internal.Customer();
        customer.setTokenCustomerID("123456789");
        customer.setTitle("Mr.");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setCompanyName("Example");
        customer.setJobDescription("Java Developer");
        customer.setPhone("0123456789");
        customer.setMobile("0123456789");
        customer.setUrl("http://www.ewaypayments.com");
        customer.setFax("1234");
        customer.setStreet1("Level 5");
        customer.setStreet2("369 Queen Street");
        customer.setCardDetails(createCardDetails());
        return customer;
    }

    public static com.eway.payment.rapid.sdk.beans.internal.Transaction createInternalTransaction() {

        com.eway.payment.rapid.sdk.beans.internal.Transaction t = new com.eway.payment.rapid.sdk.beans.internal.Transaction();
        t.setBeagleScore(0d);
        t.setTransactionStatus(true);
        t.setTotalAmount(1000);
        t.setTransactionID("123456");
        ShippingAddress shippingAddress = createShippingAddress();

        t.setShippingAddress(shippingAddress);
        return t;
    }

    public static ShippingAddress createShippingAddress() {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity("Sydney");
        shippingAddress.setCountry("Au");
        shippingAddress.setPostalCode("2000");
        shippingAddress.setStreet1("Level 5");
        shippingAddress.setStreet2("369 Queen Street");
        shippingAddress.setState("NSW");
        return shippingAddress;
    }

    public static Address createAddress() {
        Address Address = new Address();
        Address.setCity("Sydney");
        Address.setCountry("Au");
        Address.setPostalCode("2000");
        Address.setStreet1("Level 5");
        Address.setStreet2("369 Queen Street");
        Address.setState("NSW");
        return Address;
    }

    public static ShippingDetails createShippingDetails() {
        ShippingDetails detail = new ShippingDetails();
        Address address = createAddress();
        detail.setShippingAddress(address);
        detail.setFirstName("John");
        detail.setLastName("Smith");
        detail.setFax("1234");
        detail.setPhone("0123456789");
        detail.setEmail("test@example.com");
        detail.setShippingMethod(ShippingMethod.NextDay);
        return detail;
    }

    public static List<LineItem> createLineItems() {
        LineItem item = new LineItem();
        List<LineItem> items = new ArrayList<LineItem>();
        items.add(item);
        return items;
    }

    public static RefundDetails createRefundDetails() {
        RefundDetails refundDetails = new RefundDetails();
        refundDetails.setCurrencyCode("AUD");
        refundDetails.setInvoiceDescription("Individual Invoice Description");
        refundDetails.setInvoiceNumber("Inv 21540");
        refundDetails.setInvoiceReference("513456");
        refundDetails.setTotalAmount(1000);
        return refundDetails;
    }

    public static List<Option> createOptions() {
        List<Option> options = new ArrayList<Option>();
        Option option1 = new Option();
        option1.setValue("Option1");
        Option option2 = new Option();
        option2.setValue("Option2");

        options.add(option1);
        options.add(option2);
        return options;
    }
}
