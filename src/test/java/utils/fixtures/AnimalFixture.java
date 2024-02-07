package utils.fixtures;

import io.smallrye.mutiny.Uni;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Species;
import org.openapi.quarkus.api_yaml.model.AnimalCreationViewModel;

import java.util.List;
import java.util.UUID;

import static utils.fixtures.EnclosureFixture.createDefaultEnclosure;
import static utils.fixtures.EnclosureFixture.enclosureId;
import static utils.fixtures.SpeciesFixture.createDefaultSpecies;
import static utils.fixtures.SpeciesFixture.speciesId;

public class AnimalFixture {
    public static final String animalName = "Felix";
    public static final UUID animalId;

    static {
        animalId = UUID.randomUUID();
    }

    public static Animal createAnimal(UUID id, String name, Species species, Enclosure enclosure) {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);
        animal.setSpecies(species);
        animal.setEnclosure(enclosure);
        return animal;
    }

    public static Animal createDefaultAnimal() {
        return createAnimal(animalId, animalName, null, null);
    }

    public static List<Animal> createDefaultList() {
        Species species = createDefaultSpecies();
        Enclosure enclosure = createDefaultEnclosure();
        return List.of(
                createAnimal(animalId, animalName, species, enclosure),
                createAnimal(null, "Canis", species, enclosure));
    }

    public static Uni<List<Animal>> createDefaultUniList() {
        return Uni.createFrom().item(createDefaultList());
    }

    public static AnimalCreationViewModel createDefaultAnimalCreation() {
        AnimalCreationViewModel vm = new AnimalCreationViewModel();
        vm.setName(animalName);
        vm.setEnclosure(enclosureId);
        vm.setSpecies(speciesId);
        return vm;
    }
}
