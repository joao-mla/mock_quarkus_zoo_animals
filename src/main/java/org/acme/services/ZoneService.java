package org.acme.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.dtos.ZoneDto;
import org.acme.maps.ZoneMapper;
import org.acme.persistence.repositories.ZoneRepository;

import java.util.List;
import java.util.UUID;

import static org.acme.utils.Constants.ZONE_CODE_LENGTH;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class ZoneService {
    private final ZoneRepository zoneRepository;
    private final ZoneMapper zoneMapper;

    /**
     * Fetches a single Zone based on its ID
     * @param id The ID of the zone
     * @return The found zone
     */
    public Uni<ZoneDto> getSingleZone(UUID id) {
        log.info("Fetching zone of ID [{}]", id);
        return zoneRepository.findById(id)
                .map(zoneMapper::mapToDto);
    }

    /**
     * Creates a zone
     * @param zone The zone to be created
     * @return The created zone
     */
    public Uni<ZoneDto> create(ZoneDto zone) {
        if (!validateZoneCreation(zone)) {
            log.error("Zone is invalid");
            return Uni.createFrom().failure(new ValidationException("Invalid zone"));
        }

        log.info("Creating zone");
        return Uni.createFrom().item(zone)
                .map(zoneMapper::map)
                .flatMap(entity ->
                    Panache.withTransaction(() -> zoneRepository.persist(entity)))
                .invoke(createdZone -> log.info("Zone created. ID: [{}]", createdZone.getId()))
                .map(zoneMapper::mapToDto);
    }

    /**
     * Fetches all zones
     * @return A list of all the zones
     */
    public Uni<List<ZoneDto>> getAll() {
        log.info("Getting all zones");
        return zoneRepository.listAll(Sort.by("name"))
                .invoke(list -> log.info("Fetched [{}] zone(s)", list.size()))
                .map(zoneMapper::mapToDto);
    }

    /**
     * Validates zone
     * @param zone The zone to be validated
     * @return true if valid; false otherwise
     */
    private boolean validateZoneCreation(ZoneDto zone) {
        if(zone.getInternalCode().length() != ZONE_CODE_LENGTH) {
            log.error("Zone with invalid internal code. Length should be {}", ZONE_CODE_LENGTH);
            return false;
        }

        return true;
    }
}
