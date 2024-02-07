package org.acme.maps;

import io.smallrye.mutiny.Uni;
import org.acme.dtos.SpeciesDto;
import org.acme.persistence.enitities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapi.quarkus.api_yaml.model.SpeciesCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpeciesViewModel;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SpeciesMapper {
    SpeciesDto map(Species species);

    List<SpeciesDto> map(List<Species> species);

    SpeciesDto map(SpeciesCreationViewModel vm);

    Species map(SpeciesDto species);

    List<SpeciesViewModel> mapToVm(List<SpeciesDto> speciesDtos);

    SpeciesViewModel mapToVm(SpeciesDto speciesDtos);
}
