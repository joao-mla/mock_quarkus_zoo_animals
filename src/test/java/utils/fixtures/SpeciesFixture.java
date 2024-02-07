package utils.fixtures;

import org.acme.persistence.enitities.Species;

import java.util.UUID;

public class SpeciesFixture {

    public static final String speciesName = "Species";
    public static final UUID speciesId;

    static {
        speciesId = UUID.randomUUID();
    }

    public static Species createDefaultSpecies() {
        Species species = new Species();
        species.setName(speciesName);
        species.setId(speciesId);

        return species;
    }
}
