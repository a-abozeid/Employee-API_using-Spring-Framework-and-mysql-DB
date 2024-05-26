package com.test.testing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFound extends RuntimeException{
    public notFound(String message){
        super(message);
    }
}
