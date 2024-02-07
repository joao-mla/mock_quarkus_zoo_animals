package org.acme.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.persistence.enitities.Space;

import java.util.UUID;

@ApplicationScoped
@WithSession
public class SpaceRepository implements PanacheRepositoryBase<Space, UUID> {

}
