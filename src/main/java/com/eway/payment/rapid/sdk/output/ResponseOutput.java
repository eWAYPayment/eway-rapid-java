package com.eway.payment.rapid.sdk.output;

import java.util.ArrayList;
import java.util.List;

public class ResponseOutput {

    private List<String> errors = new ArrayList<String>();

    /**
     * List of all validation, processing, fraud or system errors that occurred
     * when processing this request. Empty/null if no errors occurred. This
     * member combines all errors related to the request
     *
     * @return List error of errors, or null if none
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Set list error
     *
     * @param errors List of errors
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
