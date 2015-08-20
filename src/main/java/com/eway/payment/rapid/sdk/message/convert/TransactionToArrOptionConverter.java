package com.eway.payment.rapid.sdk.message.convert;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Option;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import java.util.ArrayList;
import java.util.List;

public class TransactionToArrOptionConverter implements BeanConverter<Transaction, Option[]> {

    public Option[] doConvert(Transaction u) throws RapidSdkException {
        if (u.getOptions() != null) {
            List<Option> listOption = new ArrayList<Option>();
            for (String op : u.getOptions()) {
                Option option = new Option();
                option.setValue(op);
                listOption.add(option);
            }
            return listOption.toArray(new Option[listOption.size()]);
        }
        return new Option[3];
    }

}
