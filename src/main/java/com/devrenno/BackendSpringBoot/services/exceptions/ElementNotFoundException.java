package com.devrenno.BackendSpringBoot.services.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String msg){
        super(msg);
    }
}
