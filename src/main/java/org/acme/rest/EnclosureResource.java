package org.acme.rest;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.maps.EnclosureMapper;
import org.acme.services.EnclosureService;
import org.acme.services.SpaceService;
import org.openapi.quarkus.api_yaml.api.EnclosureApi;
import org.openapi.quarkus.api_yaml.model.EnclosureCreationViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureViewModel;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class EnclosureResource implements EnclosureApi {
    private final EnclosureService enclosureService;
    private final SpaceService spaceService;

    private final EnclosureMapper enclosureMapper;

    /**
     * Create an enclosure
     * @param enclosureCreationViewModel the enclosure info
     * @return The created enclosure
     */
    @Override
    public Uni<Response> createEnclosure(EnclosureCreationViewModel enclosureCreationViewModel) {
        return privateCreateEnclosure(enclosureCreationViewModel)
                .map(vm -> Response.ok(vm).status(Response.Status.CREATED).build());
    }

    private Uni<EnclosureViewModel> privateCreateEnclosure(EnclosureCreationViewModel enclosureCreationViewModel) {
        return spaceService.getSingle(enclosureCreationViewModel.getSpace())
                .map(space ->
                        enclosureMapper.map(enclosureCreationViewModel, space))
                .flatMap(enclosureService::create)
                .map(enclosureMapper::mapToVm);
    }

    /**
     * Fetches all enclosures
     * @return a list of all the enclosures
     */
    @Override
    public Uni<Response> getAllEnclosures() {
        return privateGetAllEnclosures()
                .map(vm -> Response.ok(vm).build());
    }

    public Uni<List<EnclosureViewModel>> privateGetAllEnclosures() {
        return enclosureService.getAll()
                .map(enclosureMapper::mapToVm);
    }

    /**
     * Fetches an enclosure based on an ID
     * @param id The ID of the enclosure
     * @return The enclosure object found
     */
    @Override
    public Uni<Response> getSingleEnclosure(UUID id) {
        return privateGetSingleEnclosure(id)
                .map(enclosure -> enclosure != null ?
                        Response.ok(enclosure)
                        : Response.status(Response.Status.NOT_FOUND))
                .map(Response.ResponseBuilder::build);
    }

    public Uni<EnclosureViewModel> privateGetSingleEnclosure(UUID id) {
        return enclosureService.getSingle(id)
                .map(enclosureMapper::mapToVm);
    }

    /**
     * Fetches a zookeeper responsible for an enclosure of a specific ID
     * @param id the ID of the enclosure
     * @return The zookeeper information
     */
    @Override
    public Uni<Response> getEnclosureZookeepers(UUID id) {
        return enclosureService.getEnclosureZookeepers(id)
                .map(zookeeper -> Response.ok(zookeeper).status(Response.Status.FOUND).build());
    }
}
