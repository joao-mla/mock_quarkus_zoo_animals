package org.acme.rest;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dtos.AnimalDto;
import org.acme.maps.AnimalMapper;
import org.acme.maps.EnclosureMapper;
import org.acme.maps.SpeciesMapper;
import org.acme.services.AnimalService;
import org.acme.services.EnclosureService;
import org.acme.services.SpeciesService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static utils.fixtures.AnimalFixture.animalId;
import static utils.fixtures.AnimalFixture.createDefaultAnimal;
import static utils.fixtures.AnimalFixture.createDefaultAnimalCreation;
import static utils.fixtures.AnimalFixture.createDefaultUniList;
import static utils.fixtures.AnimalFixture.animalName;
import static utils.fixtures.EnclosureFixture.createDefaultEnclosure;
import static utils.fixtures.SpeciesFixture.createDefaultSpecies;

@QuarkusTest
@RequiredArgsConstructor
class AnimalResourceTest {

    @InjectMock
    AnimalService animalService;

    @InjectMock
    EnclosureService enclosureService;

    @InjectMock
    SpeciesService speciesService;

    private final AnimalMapper animalMapper;
    private final EnclosureMapper enclosureMapper;
    private final SpeciesMapper speciesMapper;

    @Test
    void createAnimal() {
        AnimalDto dto = animalMapper.mapToDto(createDefaultAnimal());
        JsonObject requestBody = new JsonObject()
                .put("name", animalName)
                .put("enclosure", "")
                .put("species", "");

        Uni<AnimalDto> responseDto = Uni.createFrom().item(dto);

        when(animalService.create(any())).thenReturn(responseDto);
        when(enclosureService.getSingle(any())).thenReturn(
                Uni.createFrom().item(enclosureMapper.map(createDefaultEnclosure()))
        );
        when(speciesService.getSingle(any())).thenReturn(
                Uni.createFrom().item(speciesMapper.map(createDefaultSpecies()))
        );

        given()
                .contentType("application/json")
                .body(createDefaultAnimalCreation())
                .when().post("/v1/animals")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .body("name", is(animalName));
    }

    @Test
    void whenGetAllAnimals_thenAllAnimalsFound() {
        Uni<List<AnimalDto>> responseDto = createDefaultUniList().map(animalMapper::mapToDto);
        when(animalService.getAll()).thenReturn(responseDto);

        given()
                .when().get("/v1/animals")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("name", hasItems("Felix", "Canis"));
    }

    @Test
    void getSingleAnimal() {
        when(animalService.getSingle(any())).thenReturn(
                Uni.createFrom().item(animalMapper.mapToDto(createDefaultAnimal()))
        );

        given()
                .pathParam("id", animalId)
                .when().get("/v1/animals/{id}")
                .then()
                .body("name", is(animalName));
    }
}