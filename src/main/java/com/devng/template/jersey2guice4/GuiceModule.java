package com.devng.template.jersey2guice4;

import com.devng.template.jersey2guice4.rest.RestExceptionMapper;
import com.devng.template.jersey2guice4.rest.RestService;
import com.devng.template.jersey2guice4.rest.RestServiceImpl;
import com.google.inject.AbstractModule;


public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RestService.class).to(RestServiceImpl.class);
        bind(RestExceptionMapper.class);
    }
}
