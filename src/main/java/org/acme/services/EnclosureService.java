package org.acme.services;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.api.hr.viewmodels.ZookeeperViewModel;
import org.acme.dtos.EnclosureDto;
import org.acme.maps.EnclosureMapper;
import org.acme.persistence.repositories.EnclosureRepository;
import org.acme.api.hr.rest.HRZookeeperService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class EnclosureService {
    private final EnclosureRepository enclosureRepository;

    private final EnclosureMapper enclosureMapper;

    @RestClient
    HRZookeeperService hrZookeeperService;

    public Uni<EnclosureDto> getSingle(UUID id) {
        log.info("Fetching enclosure of ID [{}]", id);
        return enclosureRepository.findById(id)
                .map(enclosureMapper::map);
    }

    public Uni<EnclosureDto> create(EnclosureDto enclosure) {
        log.info("Creating enclosure");
        return Uni.createFrom().item(enclosureMapper.map(enclosure))
                .flatMap(enclosure1 -> Panache
                        .withTransaction(() -> enclosureRepository.persist(enclosure1)))
                .invoke(createdEnclosure -> log.info("Enclosure created. ID [{}]", createdEnclosure))
                .map(enclosureMapper::map);
    }

    public Uni<List<EnclosureDto>> getAll() {
        log.info("Fetching all enclosures");
        return enclosureRepository.listAll(Sort.by("name"))
                .invoke(list -> log.info("Enclosures fetched. [{}] enclosure(s) was/were found", list.size()))
                .map(enclosureMapper::map);
    }

    public Uni<ZookeeperViewModel> getEnclosureZookeepers(UUID id) {
        log.info("Fetching zookeeper of enclosure with ID [{}]", id);
        return Uni.createFrom().item(hrZookeeperService.getSingleZookeeper(id));
    }
}
