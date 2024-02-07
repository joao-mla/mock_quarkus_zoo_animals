package org.acme.maps;

import org.acme.dtos.EnclosureDto;
import org.acme.dtos.SpaceDto;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapi.quarkus.api_yaml.model.EnclosureCreationViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureViewModel;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EnclosureMapper {
    EnclosureDto map(Enclosure enclosure);

    List<EnclosureDto> map(List<Enclosure> enclosures);

    Enclosure map(EnclosureDto enclosure);

    @Mapping(target = "name", source = "vm.name")
    @Mapping(target = "space", expression = "java(space)")
    EnclosureDto map(EnclosureCreationViewModel vm, SpaceDto space);

    List<EnclosureViewModel> mapToVm(List<EnclosureDto> enclosureDtos);
    EnclosureViewModel mapToVm(EnclosureDto enclosureDto);

    default String map(Species species) {
        return species.getName();
    }
}
