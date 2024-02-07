package org.openapi.quarkus.api_yaml.api;

import org.openapi.quarkus.api_yaml.model.SpaceCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;
import java.util.UUID;
import org.openapi.quarkus.api_yaml.model.ZoneCreationViewModel;
import org.openapi.quarkus.api_yaml.model.ZoneViewModel;
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
@Path("/v1")
@RegisterRestClient( configKey="api_yaml")
@GeneratedClass(value="api.yaml", tag = "Location")
@ApplicationScoped
public interface LocationApi {

    /**
     * Create a space
     *
     * Create a space
     *
     */
    @POST
    @Path("/spaces")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("createSpace")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> createSpace(
        SpaceCreationViewModel spaceCreationViewModel
    );

    /**
     * Create a zone
     *
     * Create a zone
     *
     */
    @POST
    @Path("/zones")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("createZone")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> createZone(
        ZoneCreationViewModel zoneCreationViewModel
    );

    /**
     * Get all spaces
     *
     * Get all spaces
     *
     */
    @GET
    @Path("/spaces")
    @Produces({"application/json"})
    @GeneratedMethod ("getAllSpaces")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getAllSpaces(
    );

    /**
     * Get all zones
     *
     * Get all zones
     *
     */
    @GET
    @Path("/zones")
    @Produces({"application/json"})
    @GeneratedMethod ("getAllZones")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getAllZones(
    );

    /**
     * Get space
     *
     * Get space
     *
     */
    @GET
    @Path("/spaces/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("getSingleSpace")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getSingleSpace(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

    /**
     * Get zone
     *
     * Get zone
     *
     */
    @GET
    @Path("/zones/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("getSingleZone")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getSingleZone(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

}
