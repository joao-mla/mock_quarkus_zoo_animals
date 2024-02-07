package org.acme.api.hr.rest;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.api.hr.viewmodels.ZookeeperViewModel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(configKey = "hr_api_yaml")
@Path("/v1/zookeepers/{id}")
public interface HRZookeeperService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ZookeeperViewModel getSingleZookeeper(@PathParam("id") UUID id);
}
