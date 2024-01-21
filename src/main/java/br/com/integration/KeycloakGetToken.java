package br.com.integration;

import br.com.domain.AccessTokenResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8180")
public interface KeycloakGetToken {

    @POST
    @Path("/realms/quarkus/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    AccessTokenResponse getToken(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("grant_type") String grantType,
            @HeaderParam("Authorization") String authorization
    );

}
