package org.acme

import io.smallrye.jwt.build.Jwt
import javax.annotation.security.PermitAll
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@ApplicationScoped
@PermitAll
@Path("/login")
class LoginResource {

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    @POST
    fun login() : Response {

        val token =  Jwt
            .issuer("pms")
            .subject("demo.user")
            .sign()

        return Response.ok(token).build()
    }
}

/*
curl -X 'POST' "http://localhost:8080/login"


 */