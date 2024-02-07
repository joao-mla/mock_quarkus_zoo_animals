package org.acme.rest;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dtos.EnclosureDto;
import org.acme.dtos.SpeciesDto;
import org.acme.maps.AnimalMapper;
import org.acme.services.AnimalService;
import org.acme.services.EnclosureService;
import org.acme.services.SpeciesService;
import org.openapi.quarkus.api_yaml.api.AnimalsApi;
import org.openapi.quarkus.api_yaml.model.AnimalCreationViewModel;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class AnimalResource implements AnimalsApi {

    private final AnimalService animalService;
    private final EnclosureService enclosureService;
    private final SpeciesService speciesService;

    private final AnimalMapper animalMapper;

    /**
     * Create an animal
     * @param animalCreationViewModel The animal info to create
     * @return The created animal
     */
    @Override
    public Uni<Response> createAnimal(AnimalCreationViewModel animalCreationViewModel) {
        return privateCreateAnimal(animalCreationViewModel)
                .map(animal -> Response.ok(animal).status(Response.Status.CREATED).build());
    }

    private Uni<AnimalViewModel> privateCreateAnimal(AnimalCreationViewModel vm) {
        return Uni.combine().all().unis(
                        enclosureService.getSingle(vm.getEnclosure()),
                        speciesService.getSingle(vm.getSpecies()))
                .asTuple()
                .flatMap(tuple -> {
                    EnclosureDto enclosureDto = tuple.getItem1();
                    SpeciesDto speciesDto = tuple.getItem2();
                    return Uni.createFrom().item(animalMapper.map(vm, speciesDto, enclosureDto));
                })
                .flatMap(animalService::create)
                .map(animalMapper::mapToVm);
    }

    /**
     * Fetches all animals
     * @return A list of all the animals
     */
    @Override
    public Uni<Response> getAllAnimals() {
        return privateGetAllAnimals()
                .map(animals -> Response.ok(animals).build());
    }

    private Uni<List<AnimalViewModel>> privateGetAllAnimals() {
        return animalService.getAll()
                .map(animalMapper::mapToVm);
    }

    /**
     * Fetches an animal based on its ID
     * @param id The ID of the animal
     * @return The animal information
     */
    @Override
    public Uni<Response> getSingleAnimal(UUID id) {
        return privateGetSingleAnimal(id)
                .map(animal -> Response.ok(animal).build());
    }

    private Uni<AnimalViewModel> privateGetSingleAnimal(UUID id) {
        return animalService.getSingle(id)
                .map(animalMapper::mapToVm);
    }
}
