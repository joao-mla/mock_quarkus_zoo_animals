package org.acme.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.dtos.SpaceDto;
import org.acme.maps.SpaceMapper;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Space;
import org.acme.persistence.repositories.SpaceRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class SpaceService {
    private final SpaceRepository spaceRepository;

    private final SpaceMapper spaceMapper;

    public Uni<SpaceDto> getSingle(UUID id) {
        log.info("Fetching space with ID [{}]", id);
        return spaceRepository.findById(id)
                .map(spaceMapper::mapToDto);
    }

    public Uni<SpaceDto> create(SpaceDto space) {
        log.info("Creating a space");
        return Uni.createFrom().item(spaceMapper.map(space))
                .flatMap(space1 -> Panache
                        .withTransaction(() -> spaceRepository.persist(space1)))
                .invoke(createdSpace -> log.info("Created space. ID [{}]", createdSpace.getId()))
                .map(spaceMapper::mapToDto);
    }

    public Uni<List<SpaceDto>> getAll() {
        log.info("Fetching all the spaces.");
        return spaceRepository.listAll(Sort.by("name"))
                .invoke(list -> log.info("Fetched {} spaces", list.size()))
                .map(spaceMapper::mapToDto);
    }
}
