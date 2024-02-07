package org.acme.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.dtos.SpeciesDto;
import org.acme.maps.SpeciesMapper;
import org.acme.persistence.enitities.Species;
import org.acme.persistence.repositories.SpeciesRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    private final SpeciesMapper speciesMapper;

    public Uni<List<SpeciesDto>> getAll() {
        log.info("Fetching all species");
        return speciesRepository.listAll(Sort.by("name"))
                .invoke(list -> log.info("Found {} species", list.size()))
                .map(speciesMapper::map);
    }

    public Uni<SpeciesDto> getSingle(UUID id) {
        log.info("Fetching species of ID [{}]", id);
        return speciesRepository.findById(id)
                .map(speciesMapper::map);
    }

    public Uni<SpeciesDto> create(SpeciesDto species) {
        log.info("Creating species");
        return Uni.createFrom().item(speciesMapper.map(species))
                .flatMap(species1 ->
                        Panache.withTransaction(() -> speciesRepository.persist(species1)))
                .invoke(createdSpecies -> log.info("Created species of ID [{}]", createdSpecies.getId()))
                .map(speciesMapper::map);
    }
}
