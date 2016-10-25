# Changelog

All Notable changes will be documented in this file

## 1.2.0

 - Added ability to set the Rapid API version and new associated fields

## 1.1.2

 - Added SecuredCardData field and new messages for Secure Fields
 - Added customer email to the customer response object
 - Created a test jar with ObjectCreator for testing

## 1.1.1

 - Fix for new Rapid fields causing exceptions
 - Changed create and update customer to use MOTO for TransactionType to support not sending the CVN
 - Allow one digit expiry months (thanks @davidwebster48)

## 1.1.0

 - Added ability to update a token customer using client.update()
 - Added SaveCustomer flag to Transactions to create a token when a transaction is completed.
 - Added a debug flag to enable logging of errors

## 1.0.0

 - First release
