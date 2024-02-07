package org.openapi.quarkus.api_yaml.api;

import org.openapi.quarkus.api_yaml.model.SpeciesCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpeciesViewModel;
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
@Path("/v1/species")
@RegisterRestClient( configKey="api_yaml")
@GeneratedClass(value="api.yaml", tag = "Species")
@ApplicationScoped
public interface SpeciesApi {

    /**
     * Create a species
     *
     * Create a species
     *
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("createSpecies")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> createSpecies(
        SpeciesCreationViewModel speciesCreationViewModel
    );

    /**
     * Get all species
     *
     * Get all species
     *
     */
    @GET
    @Produces({"application/json"})
    @GeneratedMethod ("getAllSpecies")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getAllSpecies(
    );

    /**
     * Get species
     *
     * Get species
     *
     */
    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("getSingleSpecies")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getSingleSpecies(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

}
