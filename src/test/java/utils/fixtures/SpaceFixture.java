package utils.fixtures;

import org.acme.persistence.enitities.Space;

import java.util.UUID;

import static utils.fixtures.ZoneFixture.createDefaultZone;

public class SpaceFixture {

    public static final String spaceName = "Space";
    public static final UUID spaceId;
    public static final String spaceInternalCode = "123";

    static {
        spaceId = UUID.randomUUID();
    }

    public static Space createDefaultSpace() {
        Space space = new Space();
        space.setName(spaceName);
        space.setId(spaceId);
        space.setInternalCode(spaceInternalCode);
        space.setZone(createDefaultZone());

        return space;
    }
}