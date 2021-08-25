package com.zup.desafio.handler;

public class BadRequestException extends Exception {

    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
