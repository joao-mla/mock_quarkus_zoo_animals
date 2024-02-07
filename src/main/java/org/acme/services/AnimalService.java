package org.acme.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.dtos.AnimalDto;
import org.acme.maps.AnimalMapper;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Species;
import org.acme.persistence.repositories.AnimalRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class AnimalService {
    private final SpeciesService speciesService;
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper = Mappers.getMapper(AnimalMapper.class);

    public Uni<AnimalDto> getSingle(UUID id) {
        log.info("Fetching animal of id {}", id);
        return animalRepository.findById(id)
                .map(animalMapper::mapToDto);
    }

    public Uni<AnimalDto> create(AnimalDto animal) {
        log.info("Creating animal.");
        return Uni.createFrom().item(animalMapper.map(animal))
                .flatMap(entity ->
                        Panache.withTransaction(() -> animalRepository.persist(entity)))
                .invoke(createdAnimal -> log.info("Animal created. ID: [{}]", createdAnimal.getId()))
                .map(animalMapper::mapToDto);
    }

    public Uni<List<AnimalDto>> getAll() {
        log.info("Fetching all the animals");
        return animalRepository.listAll(Sort.by("name"))
                .invoke(animals -> log.info("Found " + animals.size() + " animals."))
                .map(animalMapper::mapToDto);
    }
}
