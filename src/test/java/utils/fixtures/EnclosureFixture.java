package utils.fixtures;

import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Space;
import org.openapi.quarkus.api_yaml.model.EnclosureCreationViewModel;

import java.util.List;
import java.util.UUID;

import static utils.fixtures.SpaceFixture.createDefaultSpace;

public class EnclosureFixture {
    public static final String enclosureName = "Enclosure";
    public static final UUID enclosureId;

    static {
        enclosureId = UUID.randomUUID();
    }

    public static Enclosure createEnclosure(String enclosureName, UUID enclosureId, Space space) {
        Enclosure enclosure = new Enclosure();
        enclosure.setName(enclosureName);
        enclosure.setSpace(space);
        enclosure.setId(enclosureId);
        return enclosure;
    }

    public static Enclosure createDefaultEnclosure() {
        return createEnclosure(enclosureName, enclosureId, createDefaultSpace());
    }

    public static EnclosureCreationViewModel createDefaultEnclosureCreation() {
        EnclosureCreationViewModel creation = new EnclosureCreationViewModel();
        creation.setName(enclosureName);
        creation.setSpace(SpaceFixture.spaceId);
        return creation;
    }

    public static List<Enclosure> createDefaultEnclosureList() {
        return List.of(
                createDefaultEnclosure(),
                createEnclosure(enclosureName + "2", enclosureId, createDefaultSpace())
        );
    }
}
