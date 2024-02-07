package org.acme.rest;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.maps.SpaceMapper;
import org.acme.maps.ZoneMapper;
import org.acme.services.SpaceService;
import org.acme.services.ZoneService;
import org.openapi.quarkus.api_yaml.api.LocationApi;
import org.openapi.quarkus.api_yaml.model.SpaceCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;
import org.openapi.quarkus.api_yaml.model.ZoneCreationViewModel;
import org.openapi.quarkus.api_yaml.model.ZoneViewModel;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class LocationResource implements LocationApi {
    private final SpaceService spaceService;
    private final ZoneService zoneService;

    private final ZoneMapper zoneMapper;
    private final SpaceMapper spaceMapper;

    /**
     * Creates a space
     * @param spaceCreationViewModel The space info to create
     * @return The created space
     */
    @Override
    public Uni<Response> createSpace(SpaceCreationViewModel spaceCreationViewModel) {
        return privateCreateSpace(spaceCreationViewModel)
                .map(space ->
                        Response.ok(space).status(Response.Status.CREATED).build());
    }

    private Uni<SpaceViewModel> privateCreateSpace(SpaceCreationViewModel spaceCreationViewModel) {
        return Uni.createFrom().item(spaceMapper.mapToDto(spaceCreationViewModel))
                .flatMap(spaceService::create)
                .map(spaceMapper::mapToVm);
    }

    /**
     * Fetches all spaces
     * @return A list of spaces
     */
    @Override
    public Uni<Response> getAllSpaces() {
        return privateGetAllSpaces()
                .map(list -> Response.ok(list).build());
    }

    private Uni<List<SpaceViewModel>> privateGetAllSpaces() {
        return spaceService.getAll()
                .map(spaceMapper::mapToVm);
    }

    /**
     * Fetches a space from its ID
     * @param id The ID of the space
     * @return A Space object
     */
    @Override
    public Uni<Response> getSingleSpace(UUID id) {
        return privateGetSingleSpace(id)
                .map(space -> space == null ?
                        Response.ok(null).status(Response.Status.NOT_FOUND)
                        : Response.ok(space).status(Response.Status.FOUND))
                .map(Response.ResponseBuilder::build);
    }

    private Uni<SpaceViewModel> privateGetSingleSpace(UUID id) {
        return spaceService.getSingle(id)
                .map(spaceMapper::mapToVm);
    }

    /**
     * Creates a zone
     * @param zoneCreationViewModel The zone information
     * @return The created object
     */
    @Override
    public Uni<Response> createZone(ZoneCreationViewModel zoneCreationViewModel) {
        return privateCreateZone(zoneCreationViewModel)
                .map(created ->
                        Response.ok(created).status(Response.Status.CREATED).build());
    }

    private Uni<ZoneViewModel> privateCreateZone(ZoneCreationViewModel zoneCreationViewModel) {
        return Uni.createFrom().item(zoneMapper.mapToDto(zoneCreationViewModel))
                .flatMap(zoneService::create)
                .map(zoneMapper::mapToVm);
    }

    /**
     * Fetches all zones
     * @return A list of all the zones
     */
    @Override
    public Uni<Response> getAllZones() {
        return privateGetAllZones()
                .map(zones ->
                        Response.ok(zones).build());
    }

    private Uni<List<ZoneViewModel>> privateGetAllZones() {
        return zoneService.getAll()
                .map(zoneMapper::mapToVm);
    }

    /**
     * Fetches a zone based on its ID
     * @param id The zone ID
     * @return The Zone
     */
    @Override
    public Uni<Response> getSingleZone(UUID id) {
        return privateGetSingleZone(id)
                .map(zone -> zone == null ?
                        Response.ok().status(Response.Status.NOT_FOUND)
                        : Response.ok(zone).status(Response.Status.FOUND))
                .map(Response.ResponseBuilder::build);
    }

    private Uni<ZoneViewModel> privateGetSingleZone(UUID id) {
        return zoneService.getSingleZone(id)
                .map(zoneMapper::mapToVm);
    }
}
