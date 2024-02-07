package org.acme.rest;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.maps.SpeciesMapper;
import org.acme.persistence.enitities.Species;
import org.acme.services.SpeciesService;
import org.openapi.quarkus.api_yaml.api.SpeciesApi;
import org.openapi.quarkus.api_yaml.model.SpeciesCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpeciesViewModel;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class SpeciesResource implements SpeciesApi {
    private final SpeciesService speciesService;

    private final SpeciesMapper speciesMapper;

    /**
     * Create a species
     * @param speciesCreationViewModel The species to create
     * @return The created species
     */
    @Override
    public Uni<Response> createSpecies(SpeciesCreationViewModel speciesCreationViewModel) {
        return privateCreateSpecies(speciesCreationViewModel)
                .map(saved -> Response.ok(saved).status(Response.Status.CREATED).build());
    }

    private Uni<SpeciesViewModel> privateCreateSpecies(SpeciesCreationViewModel speciesCreationViewModel) {
        return Uni.createFrom().item(speciesMapper.map(speciesCreationViewModel))
                .flatMap(speciesService::create)
                .map(speciesMapper::mapToVm);
    }

    /**
     * Fetches all species
     * @return A list of all the species
     */
    @Override
    public Uni<Response> getAllSpecies() {
        return privateGetAllSpecies()
                .map(species -> Response.ok(species).build());
    }

    private Uni<List<SpeciesViewModel>> privateGetAllSpecies() {
        return speciesService.getAll()
                .map(speciesMapper::mapToVm);
    }

    /**
     * Fetches a single species based on its ID
     * @param id The ID of the species
     * @return The species object
     */
    @Override
    public Uni<Response> getSingleSpecies(UUID id) {
        return privateGetSpecies(id)
                .map(species -> species != null ?
                        Response.ok(species)
                        : Response.status(Response.Status.NOT_FOUND))
                .map(Response.ResponseBuilder::build);
    }

    private Uni<SpeciesViewModel> privateGetSpecies(UUID id) {
        return speciesService.getSingle(id)
                .map(speciesMapper::mapToVm);
    }
}