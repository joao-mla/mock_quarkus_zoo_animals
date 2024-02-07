package org.acme.rest;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dtos.AnimalDto;
import org.acme.dtos.EnclosureDto;
import org.acme.dtos.SpaceDto;
import org.acme.maps.EnclosureMapper;
import org.acme.maps.SpaceMapper;
import org.acme.services.EnclosureService;
import org.acme.services.SpaceService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static utils.fixtures.AnimalFixture.animalName;
import static utils.fixtures.AnimalFixture.createDefaultAnimal;
import static utils.fixtures.AnimalFixture.createDefaultAnimalCreation;
import static utils.fixtures.EnclosureFixture.createDefaultEnclosure;
import static utils.fixtures.EnclosureFixture.createDefaultEnclosureCreation;
import static utils.fixtures.EnclosureFixture.createDefaultEnclosureList;
import static utils.fixtures.EnclosureFixture.enclosureId;
import static utils.fixtures.EnclosureFixture.enclosureName;
import static utils.fixtures.SpaceFixture.createDefaultSpace;
import static utils.fixtures.SpeciesFixture.createDefaultSpecies;

@QuarkusTest
@RequiredArgsConstructor
class EnclosureResourceTest {

    @InjectMock
    EnclosureService enclosureService;

    @InjectMock
    SpaceService spaceService;

    private final EnclosureMapper enclosureMapper;
    private final SpaceMapper spaceMapper;

    @Test
    void createEnclosure() {
        EnclosureDto dto = enclosureMapper.map(createDefaultEnclosure());
        Uni<EnclosureDto> responseDto = Uni.createFrom().item(dto);

        SpaceDto spaceDto = spaceMapper.mapToDto(createDefaultSpace());
        Uni<SpaceDto> spaceUni = Uni.createFrom().item(spaceDto);

        when(enclosureService.create(any())).thenReturn(responseDto);
        when(spaceService.getSingle(any())).thenReturn(spaceUni);

        given()
                .contentType("application/json")
                .body(createDefaultEnclosureCreation())
                .when().post("/v1/enclosures")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .body("name", is(enclosureName));
    }

    @Test
    void getAllEnclosures() {
        List<EnclosureDto> dto = enclosureMapper.map(createDefaultEnclosureList());
        Uni<List<EnclosureDto>> responseDto = Uni.createFrom().item(dto);

        when(enclosureService.getAll()).thenReturn(responseDto);

        given()
                .contentType("application/json")
                .when().get("/v1/enclosures")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("name", hasItems(enclosureName, enclosureName + "2"));
    }

    @Test
    void getSingleEnclosure() {
        EnclosureDto dto = enclosureMapper.map(createDefaultEnclosure());
        Uni<EnclosureDto> responseDto = Uni.createFrom().item(dto);

        when(enclosureService.getSingle(any())).thenReturn(responseDto);

        given()
                .contentType("application/json")
                .pathParam("id", enclosureId)
                .when().get("/v1/enclosures/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("name", is(enclosureName));
    }
}