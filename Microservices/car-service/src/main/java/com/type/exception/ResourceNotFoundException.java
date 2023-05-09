package com.type.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    //@ResponseStatus(HttpStatus.NOT_FOUND) spring faramework gelen notfound parametre ile bu isi yatik

    public ResourceNotFoundException( String message){
        super(message);
    }
    // constructor araciligiyla

}
