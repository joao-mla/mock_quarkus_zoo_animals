package org.acme.maps;

import org.acme.dtos.ZoneDto;
import org.acme.persistence.enitities.Zone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapi.quarkus.api_yaml.model.ZoneCreationViewModel;
import org.openapi.quarkus.api_yaml.model.ZoneViewModel;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ZoneMapper {

    ZoneDto mapToDto(Zone zone);

    List<ZoneDto> mapToDto(List<Zone> zones);

    ZoneDto mapToDto(ZoneCreationViewModel zoneCreationViewModel);

    Zone map(ZoneDto zoneDto);

    ZoneViewModel mapToVm(ZoneDto zoneDto);
    List<ZoneViewModel> mapToVm(List<ZoneDto> zoneDtos);
}
