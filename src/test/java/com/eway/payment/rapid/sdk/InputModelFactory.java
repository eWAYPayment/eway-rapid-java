package com.eway.payment.rapid.sdk;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.*;
import com.eway.payment.rapid.sdk.beans.internal.*;
import com.eway.payment.rapid.sdk.entities.*;

import java.util.ArrayList;
import java.util.List;

public class InputModelFactory {

    public static Customer initCustomer() {
        Customer customer = new Customer();
        customer.setTitle("Mr.");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setCompanyName("eWay");
        customer.setJobDescription("Java Developer");
        customer.setPhone("0123456789");
        customer.setMobile("0123456789");
        customer.setUrl("http://www.ewaypayments.com");
        customer.setRedirectUrl("http://www.eway.com.au");
        customer.setEmail("test@example.org");
        return customer;
    }

    public static Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setPartnerID("9889897");
        transaction.setCancelURL("");
        transaction.setCapture(true);
        transaction.setCheckoutPayment(true);
        transaction.setRedirectURL("http://www.eway.com.au");
        transaction.setDeviceID("546545");
        transaction.setTransactionType(TransactionType.Purchase);
        List<Option> listOption = new ArrayList<Option>();
        Option option1 = new Option();
        option1.setValue("Option 1");
        Option option2 = new Option();
        option2.setValue("Option 2");
        listOption.add(option1);
        listOption.add(option2);
        transaction.setOptions(listOption);
        List<LineItem> listItem = new ArrayList<LineItem>();
        LineItem item = new LineItem();
        item.setSku("12345678901234567890");
        item.setDescription("Item Description 1");
        item.setQuantity(1);
        item.setUnitCost(400);
        item.setTotalTax(100);
        item.setTotal(500);
        listItem.add(item);
        transaction.setLineItems(listItem);
        return transaction;
    }

    public static List<LineItem> createLineItem() {
        List<LineItem> items = new ArrayList<LineItem>();
        LineItem item = new LineItem();
        item.setDescription("My item");
        item.setQuantity(10);
        item.setSku("SKU");
        item.setTotal(1000);
        item.setTotalTax(100);
        items.add(item);
        return items;
    }

    public static List<String> createOptions() {
        List<String> options = new ArrayList<String>();
        options.add("Option1");
        options.add("Option2");
        return options;
    }

    public static ShippingDetails createShippingDetail() {
        ShippingDetails detail = new ShippingDetails();
        detail.setShippingMethod(ShippingMethod.LowCost);
        detail.setEmail("test@example.org");
        detail.setFax("12345689");
        detail.setFirstName("Dave");
        detail.setLastName("David");
        detail.setPhone("0936101022");
        return detail;
    }

    public static ShippingAddress createShippingAddress() {
        ShippingAddress shipAddress = new ShippingAddress();
        shipAddress.setCity("Sydney");
        shipAddress.setCountry("Australia");
        shipAddress.setEmail("test@example.org");
        shipAddress.setFax("12345689");
        shipAddress.setPostalCode("10xxxx");
        shipAddress.setShippingMethod(ShippingMethod.NextDay.name());
        shipAddress.setStreet1("Street 1");
        shipAddress.setStreet2("Street 2");
        shipAddress.setState("NSW");
        shipAddress.setPhone("0936101022");
        return shipAddress;
    }

    public static com.eway.payment.rapid.sdk.beans.internal.Customer createInternalCustomer() {
        com.eway.payment.rapid.sdk.beans.internal.Customer cust = new com.eway.payment.rapid.sdk.beans.internal.Customer();
        cust.setCardDetails(initCardDetails("12", "25"));
        cust.setCountry("Australia");
        cust.setEmail("test@example.org");
        cust.setFax("12345689");
        cust.setFirstName("Dave");
        cust.setLastName("David");
        cust.setIsActive("true");
        cust.setJobDescription("Dev");
        return cust;
    }

    public static Address initAddress() {
        Address address = new Address();
        address.setCity("Sydney");
        address.setCountry("Au");
        address.setPostalCode("2000");
        address.setStreet1("Level 5");
        address.setStreet2("369 Queen Street");
        address.setState("NSW");
        return address;
    }

    public static Address createAddress(String city, String country, String postalCode, String state) {
        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        address.setState(state);
        return address;
    }

    public static CardDetails initCardDetails(String expiryMonth, String expiryYear) {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("John Smith");
        cardDetails.setNumber("4444333322221111");
        cardDetails.setExpiryMonth(expiryMonth);
        cardDetails.setExpiryYear(expiryYear);
        cardDetails.setCVN("123");
        return cardDetails;
    }

    public static PaymentDetails initPaymentDetails() {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCurrencyCode("AUD");
        paymentDetails.setInvoiceDescription("Individual Invoice Description");
        paymentDetails.setInvoiceNumber("Inv 21540");
        paymentDetails.setInvoiceReference("513456");
        paymentDetails.setTotalAmount(1000);
        return paymentDetails;
    }

    public static PaymentDetails initPaymentDetails(String invoiceNumber, String invoiceReference) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCurrencyCode("AUD");
        paymentDetails.setInvoiceDescription("Individual Invoice Description");
        paymentDetails.setInvoiceNumber(invoiceNumber);
        paymentDetails.setInvoiceReference(invoiceReference);
        paymentDetails.setTotalAmount(1000);
        return paymentDetails;
    }

    public static RefundDetails initRefundDetails() {
        RefundDetails refundDetails = new RefundDetails();
        refundDetails.setCurrencyCode("AUD");
        refundDetails.setInvoiceDescription("Individual Invoice Description");
        refundDetails.setInvoiceNumber("Inv 21540");
        refundDetails.setInvoiceReference("513456");
        refundDetails.setTotalAmount(1000);
        return refundDetails;
    }

    public static Payment initPayment() {
        Payment payment = new Payment();
        payment.setTotalAmount(1000);
        payment.setInvoiceNumber("inv 4444");
        payment.setInvoiceDescription("Individual Invoice Description");
        payment.setInvoiceReference("513456");
        payment.setCurrencyCode("AUD");
        return payment;
    }

    public static CreateAccessCodeSharedResponse createAccessCodeShared() {
        CreateAccessCodeSharedResponse response = new CreateAccessCodeSharedResponse();
        response.setAccessCode("19001009");
        response.setCompleteCheckoutURL("http://www.eway.com.au");
        response.setCustomer(createInternalCustomer());
        response.setErrors("K0000,K1111");
        response.setFormActionURL("http://www.eway.com.au");
        response.setPayment(initPayment());
        response.setSharedPaymentUrl("http://www.eway.com.au");
        return response;
    }

    public static CreateAccessCodeResponse createAccessCodeResponse() {
        CreateAccessCodeResponse response = new CreateAccessCodeResponse();
        response.setAccessCode("19001009");
        response.setCardExpiryMonth("12");
        response.setCardExpiryYear("25");
        response.setCardName("My_Card");
        response.setCardStartMonth("12");
        response.setLastName("Dave");
        response.setFirstName("David");
        response.setCompanyName("Company");
        response.setUrl("http://www.eway.com.au");
        response.setCompleteCheckoutURL("http://www.eway.com.au");
        response.setErrors(null);
        response.setEmail("test@example.org");
        return response;
    }

    public static DirectCustomerSearchResponse createDirectCustomerSearch() {
        DirectCustomerSearchResponse response = new DirectCustomerSearchResponse();
        response.setErrors("");
        response.setCustomers(createListInternalCustomer());
        return response;
    }

    public static List<com.eway.payment.rapid.sdk.beans.internal.Customer> createListInternalCustomer() {
        List<com.eway.payment.rapid.sdk.beans.internal.Customer> listCustomer = new ArrayList<com.eway.payment.rapid.sdk.beans.internal.Customer>();
        listCustomer.add(createInternalCustomer());
        return listCustomer;
    }

    public static DirectPaymentResponse createDirectPaymentResponse() {
        DirectPaymentResponse response = new DirectPaymentResponse();
        response.setBeagleScore(10.0);
        response.setFraudAction("HHHHHH");
        response.setResponseCode("K10000");
        response.setCustomer(createInternalCustomer());
        response.setTransactionID("5654545454");
        response.setTransactionStatus(true);
        response.setResponseMessage("Success");
        response.setVerification(createVerification());
        return response;
    }

    public static Verification createVerification() {
        Verification ver = new Verification();
        ver.setAddress("");
        ver.setCVN("cnv");
        ver.setEmail("test@example.org");
        ver.setMobile("0936101022");
        ver.setPhone("043666333");
        return ver;
    }

    public static DirectRefundResponse createDirectRefundResponse() {
        DirectRefundResponse response = new DirectRefundResponse();
        response.setAuthorisationCode("HHHKKK");
        response.setRefund(initRefundDetails());
        response.setTransactionID("554555");
        return response;
    }

    public static TransactionSearchResponse createTransactionSearchResponse() {
        TransactionSearchResponse response = new TransactionSearchResponse();
        response.setError("");
        com.eway.payment.rapid.sdk.beans.internal.Transaction[] trans = {createInternalTransaction()};
        response.setTransactions(trans);
        return response;
    }

    public static com.eway.payment.rapid.sdk.beans.internal.Transaction createInternalTransaction() {
        com.eway.payment.rapid.sdk.beans.internal.Transaction transaction = new com.eway.payment.rapid.sdk.beans.internal.Transaction();
        transaction.setBeagleScore(10.0d);
        transaction.setCustomer(createInternalCustomer());
        transaction.setBeagleVerification(createBeagleVerification());
        transaction.setInvoiceNumber("fsksfkkfs");
        transaction.setOptions(createOptionsObj());
        return transaction;
    }

    public static Option[] createOptionsObj() {
        Option op = new Option();
        op.setValue("option1");
        Option[] result = {op};
        return result;
    }

    public static BeagleVerification createBeagleVerification() {
        BeagleVerification beagle = new BeagleVerification();
        beagle.setEmail("test@example.org");
        beagle.setPhone("0936101022");
        return beagle;
    }

    public static ShippingDetails initShippingDetail() {
        ShippingDetails detail = new ShippingDetails();
        detail.setFirstName("Mr");
        detail.setEmail("test@example.org");
        detail.setShippingAddress(initAddress());
        detail.setShippingMethod(ShippingMethod.NextDay);
        return detail;
    }

    public static String randomString(int length) {
        return new RandomString(length).nextString();
    }

}
