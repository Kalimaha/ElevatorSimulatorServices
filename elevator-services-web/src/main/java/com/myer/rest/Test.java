package com.myer.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:guido.barbaglia@gmail.com">Guido Barbaglia</a>
 */
@Component
@Path("/hallo/")
public class Test {

    @GET
    public Response get() {
        return Response.status(200).entity("Hallo, world!").build();
    }
}
