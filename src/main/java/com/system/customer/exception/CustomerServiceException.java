package com.system.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomerServiceException extends Exception {

    public CustomerServiceException(Throwable e, String message) {
        super(message, e);
    }

}
