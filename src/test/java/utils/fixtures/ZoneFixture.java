package utils.fixtures;

import org.acme.persistence.enitities.Zone;

import java.util.UUID;

public class ZoneFixture {

    public static final UUID zoneId;
    public static final String zoneInternalCode = "321";
    public static final String zoneName = "Name";

    static {
        zoneId = UUID.randomUUID();
    }

    public static Zone createDefaultZone() {
        Zone zone = new Zone();
        zone.setId(zoneId);
        zone.setInternalCode(zoneInternalCode);
        zone.setName(zoneName);

        return zone;
    }
}
