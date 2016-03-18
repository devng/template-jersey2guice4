package com.devng.template.jersey2guice4.rest;


import com.devng.template.jersey2guice4.dto.HelloDto;

import javax.annotation.Nonnull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public interface RestService {

    @GET
    @Path("/hello")
    @Nonnull
    @Produces(MediaType.APPLICATION_JSON)
    HelloDto sayHello();

    @POST
    @Path("/hello")
    @Nonnull
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    HelloDto newHello(HelloDto hello);
}
