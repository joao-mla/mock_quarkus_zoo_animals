package org.acme.maps;

import io.smallrye.mutiny.Uni;
import org.acme.dtos.AnimalDto;
import org.acme.dtos.EnclosureDto;
import org.acme.dtos.SpeciesDto;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapi.quarkus.api_yaml.model.AnimalCreationViewModel;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AnimalMapper {
    List<AnimalViewModel> map(List<Animal> animals);

    default String map(Species species) {
        return species == null?
                null
                : species.getName();
    }

    Animal map(AnimalDto animal);

    @Mapping(target = "species", expression = "java(map(species))")
    @Mapping(target = "enclosure", expression = "java(map(enclosure))")
    @Mapping(target = "name", source = "vm.name")
    AnimalDto map(AnimalCreationViewModel vm, SpeciesDto species, EnclosureDto enclosure);

    Species map(SpeciesDto speciesDto);
    Enclosure map(EnclosureDto enclosureDto);

    List<AnimalDto> mapToDto(List<Animal> animal);

    AnimalDto mapToDto(Animal animal);

    List<AnimalViewModel> mapToVm(List<AnimalDto> animalDto);

    AnimalViewModel mapToVm(AnimalDto animalDto);
}
