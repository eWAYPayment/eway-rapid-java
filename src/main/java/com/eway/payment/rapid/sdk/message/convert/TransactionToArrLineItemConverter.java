package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import java.util.List;

public class TransactionToArrLineItemConverter implements BeanConverter<Transaction, LineItem[]> {

    public LineItem[] doConvert(Transaction transation) throws RapidSdkException {
        List<LineItem> lineItems = transation.getLineItems();
        if (lineItems != null) {
            return lineItems.toArray(new LineItem[lineItems.size()]);
        }
        return new LineItem[0];
    }

}
