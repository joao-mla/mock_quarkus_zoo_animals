package org.openapi.quarkus.api_yaml.api;

import org.openapi.quarkus.api_yaml.model.EnclosureCreationViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureViewModel;
import java.util.UUID;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkiverse.openapi.generator.annotations.GeneratedClass;
import io.quarkiverse.openapi.generator.annotations.GeneratedMethod;
import io.quarkiverse.openapi.generator.annotations.GeneratedParam;

/**
  * ZooQuarkus Service API
  * <p>ZooQuarkus Service API</p>
  */
@Path("/v1/enclosures")
@RegisterRestClient( configKey="api_yaml")
@GeneratedClass(value="api.yaml", tag = "Enclosure")
@ApplicationScoped
public interface EnclosureApi {

    /**
     * Create an enclosure
     *
     * Create an enclosure
     *
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("createEnclosure")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> createEnclosure(
        EnclosureCreationViewModel enclosureCreationViewModel
    );

    /**
     * Get all enclosures
     *
     * Get all enclosures
     *
     */
    @GET
    @Produces({"application/json"})
    @GeneratedMethod ("getAllEnclosures")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getAllEnclosures(
    );

    /**
     * Get enclosure's zookeepers
     *
     * Get enclosure's zookeepers
     *
     */
    @GET
    @Path("/{id}/zookeepers")
    @Produces({"application/json"})
    @GeneratedMethod ("getEnclosureZookeepers")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getEnclosureZookeepers(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

    /**
     * Get enclosure
     *
     * Get enclosure
     *
     */
    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("getSingleEnclosure")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getSingleEnclosure(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

}
