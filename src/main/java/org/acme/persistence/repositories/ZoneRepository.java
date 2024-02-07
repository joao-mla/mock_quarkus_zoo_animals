package org.acme.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.persistence.enitities.Zone;

import java.util.UUID;

@ApplicationScoped
@WithSession
public class ZoneRepository implements PanacheRepositoryBase<Zone, UUID> {

}
