package com.devng.template.jersey2guice4.rest;


import com.devng.template.jersey2guice4.dto.HelloDto;
import com.google.inject.Singleton;

@Singleton
public class RestServiceImpl implements RestService {

    private String message = "I just want to say hello.";

    @Override
    public HelloDto sayHello() {
        final HelloDto hello = new HelloDto();

        hello.setMessage(message);
        return hello;
    }

    @Override
    public HelloDto newHello(HelloDto hello) {
        if (hello == null || hello.getMessage() == null || hello.getMessage().isEmpty()) {
            throw new IllegalArgumentException();
        }
        message = hello.getMessage();
        return hello;
    }
}
