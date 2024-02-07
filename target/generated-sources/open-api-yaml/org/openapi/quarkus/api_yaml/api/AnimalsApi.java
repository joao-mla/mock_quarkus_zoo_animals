package org.openapi.quarkus.api_yaml.api;

import org.openapi.quarkus.api_yaml.model.AnimalCreationViewModel;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;
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
@Path("/v1/animals")
@RegisterRestClient( configKey="api_yaml")
@GeneratedClass(value="api.yaml", tag = "Animals")
@ApplicationScoped
public interface AnimalsApi {

    /**
     * Create an animal
     *
     * Create an animal
     *
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("createAnimal")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> createAnimal(
        AnimalCreationViewModel animalCreationViewModel
    );

    /**
     * Get all animals
     *
     * Get all animals
     *
     */
    @GET
    @Produces({"application/json"})
    @GeneratedMethod ("getAllAnimals")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getAllAnimals(
    );

    /**
     * Get animal
     *
     * Get animal
     *
     */
    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("getSingleAnimal")
    public io.smallrye.mutiny.Uni<jakarta.ws.rs.core.Response> getSingleAnimal(
        @GeneratedParam("id") @PathParam("id") UUID id
    );

}
