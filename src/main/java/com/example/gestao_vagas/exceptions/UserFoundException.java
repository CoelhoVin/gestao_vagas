package com.example.gestao_vagas.exceptions;

import org.apache.catalina.User;

public class UserFoundException extends RuntimeException{

    public UserFoundException(String message){
        super(message);
    }
}
