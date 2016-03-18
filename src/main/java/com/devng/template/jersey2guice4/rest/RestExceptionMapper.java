package com.devng.template.jersey2guice4.rest;

import com.devng.template.jersey2guice4.dto.ErrorDto;
import com.owlike.genson.Genson;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestExceptionMapper implements ExceptionMapper<Exception> {

    private final Genson objectMapper;

    public RestExceptionMapper() {
        objectMapper = new Genson();
    }

    @Override
    public Response toResponse(final Exception ex) {
        System.err.println("Exception in REST interface:");
        ex.printStackTrace(System.err);

        if (ex instanceof IllegalArgumentException) {
            return errorResponse(400, "Malformed REST request.");
        }

        if (ex instanceof WebApplicationException) {
            WebApplicationException waex = (WebApplicationException) ex;
            return errorResponse(waex.getResponse().getStatus(), waex.getMessage());
        }

        // TODO add more exception handling here
        return errorResponse(500, "Unexpected error in the REST interface.");
    }


    /**
     * Build a JSON error response based on a HTTP status code.
     *
     * @param statusCode HTTP status code.
     * @param errorValue optional error message.
     * @return
     */
    private Response errorResponse(final int statusCode, final String errorValue) {
        final ErrorDto errorDto = new ErrorDto(statusCode, errorValue);

        return Response.status(statusCode).entity(toJson(errorDto)).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    private String toJson(ErrorDto errorDto) {
        String errorJson = null;
        try {
            errorJson = objectMapper.serialize(errorDto);
        } catch (Exception e) {
            System.err.println("Could not create error JSON: " + e);
        }
        return errorJson;
    }
}
