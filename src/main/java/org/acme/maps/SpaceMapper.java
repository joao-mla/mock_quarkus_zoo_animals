package org.acme.maps;

import org.acme.dtos.SpaceDto;
import org.acme.persistence.enitities.Space;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapi.quarkus.api_yaml.model.SpaceCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SpaceMapper {

    SpaceDto mapToDto(Space space);

    Space map(SpaceDto space);

    List<SpaceDto> mapToDto(List<Space> spaces);

    SpaceDto mapToDto(SpaceCreationViewModel spaceCreationViewModel);

    SpaceViewModel mapToVm(SpaceDto spaceDto);

    List<SpaceViewModel> mapToVm(List<SpaceDto> dtos);
}
