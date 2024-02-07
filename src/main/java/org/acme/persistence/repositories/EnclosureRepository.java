package org.acme.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.persistence.enitities.Enclosure;

import java.util.UUID;
@ApplicationScoped
@WithSession
public class EnclosureRepository implements PanacheRepositoryBase<Enclosure, UUID> {
}
