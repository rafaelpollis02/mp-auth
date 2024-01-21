package br.com.resource;

import br.com.domain.AccessTokenResponse;
import br.com.integration.KeycloakGetToken;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class KeycloakServiceResource {

    @Inject
    @RestClient
    KeycloakGetToken keycloakGetToken;

    @GET
    @Path("/token")
    public AccessTokenResponse getKeycloakToken() {
        return keycloakGetToken.getToken("developer", "developer", "password", "Basic YmFja2VuZC1zZXJ2aWNlOnNlY3JldA==");
    }

}
