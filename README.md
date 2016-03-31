# eWAY Rapid Java Library

[![Latest version on Maven Central][ico-version]][link-maven]
[![Software License][ico-license]](LICENSE.md)
[![Build Status][ico-travis]][link-travis]

A Java library to integrate with eWAY's Rapid Payment API.

Sign up with eWAY at:
 - Australia:    https://www.eway.com.au/
 - New Zealand:  https://eway.io/nz/
 - UK:           https://eway.io/uk/
 - Hong Kong:    https://eway.io/hk/
 - Malaysia:     https://eway.io/my/
 - Singapore:    https://eway.io/sg/

For testing, get a free eWAY Partner account: https://www.eway.com.au/developers

## Install

### Include with Maven

The eWAY Rapid Java library can be easily added to your Maven project's pom.xml:

```xml
    <dependency>
      <groupId>com.ewaypayments</groupId>
      <artifactId>eway-rapid-java</artifactId>
      <version>1.1.0</version>
    </dependency>
```

### Building

The eWAY Rapid Java library can also be built with Maven. To do so:

 1. Clone the eWAY Rapid GitHub project or download the zip
 2. Navigate to the folder with the pom.xml file and run
```bash
$ mvn package
```
 3. The compiled jar file will be in the "target" directory

## Usage

See the [eWAY Rapid API Reference](https://eway.io/api-v3/) for usage details.

A simple Direct payment example:

```java
import com.eway.payment.rapid.sdk.*;
import com.eway.payment.rapid.sdk.beans.external.*;
import com.eway.payment.rapid.sdk.output.*;

public class EwayRapid {
    public static void main(String[] args) {
        String apiKey = "Rapid API Key";
        String password = "Rapid API Password";
        String rapidEndpoint = "Sandbox";

        RapidClient client = RapidSDK.newRapidClient(apiKey, password, rapidEndpoint);

        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("John Smith");
        cardDetails.setNumber("4444333322221111");
        cardDetails.setExpiryMonth("12");
        cardDetails.setExpiryYear("25");
        cardDetails.setCVN("123");

        Customer customer = new Customer();
        customer.setCardDetails(cardDetails);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setTotalAmount(1000);

        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setPaymentDetails(paymentDetails);
        transaction.setTransactionType(TransactionType.Purchase);

        PaymentMethod method = PaymentMethod.Direct;
        CreateTransactionResponse response = client.create(method, transaction);

        if (response.getTransactionStatus().isStatus()) {
            System.out.println("Transaction successful! ID: " + response.getTransactionStatus().getTransactionID());
        }
    }
}
```

## Sandbox Certificate 

When using the above example to connect to the sandbox, you might get eway error S9990 _Rapid endpoint not set or invalid_.  If you are confident the _apiKey_ and _password_ are correct, and if you change the connection to the Production URL and you no longer get the error, it probably means you need to install the sandbox certificate into your Java keystore. You can do that by doing the following:

Download the certificate by connecting to api.sandbox.ewaypayments.com in your browser and download the certificate, or by using the following shell command (assuming you have _openssl_ installed)

```
$ openssl s_client -showcerts -connect api.sandbox.ewaypayments.com:443 </dev/null 2>/dev/null | openssl x509 -outform PEM > api.sandbox.ewaypayments.com.pem
```

With the certificate downloaded, you can install it into your local Java keystore using the following command:

```
$ keytool -importcert -v -noprompt -trustcacerts -alias sandboxewaypayments -file api.sandbox.ewaypayments.com.pem -keystore /path/to/cacerts -storepass changeit
```

Once the sandbox certificate is installed, you should be able to connect without error.


## Change log

Please see [CHANGELOG](CHANGELOG.md) for more information what has changed recently.

## Testing

Tests are written with JUnit and can be run using Maven:

```bash
$ mvn test
```

## License

The MIT License (MIT). Please see [License File](LICENSE.md) for more information.

[ico-version]: https://img.shields.io/maven-central/v/com.ewaypayments/eway-rapid-java.svg?style=flat-square
[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square
[ico-travis]: https://img.shields.io/travis/eWAYPayment/eway-rapid-java/master.svg?style=flat-square

[link-maven]: https://search.maven.org/#search%7Cga%7C1%7Ca%3A%22eway-rapid-java%22
[link-travis]: https://travis-ci.org/eWAYPayment/eway-rapid-java
