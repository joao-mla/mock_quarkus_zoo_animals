package org.acme.maps;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.acme.dtos.ZoneDto;
import org.acme.persistence.enitities.Zone;
import org.openapi.quarkus.api_yaml.model.ZoneCreationViewModel;
import org.openapi.quarkus.api_yaml.model.ZoneViewModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T11:36:18+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class ZoneMapperImpl implements ZoneMapper {

    @Override
    public ZoneDto mapToDto(Zone zone) {
        if ( zone == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String internalCode = null;

        id = zone.getId();
        name = zone.getName();
        internalCode = zone.getInternalCode();

        ZoneDto zoneDto = new ZoneDto( id, name, internalCode );

        return zoneDto;
    }

    @Override
    public List<ZoneDto> mapToDto(List<Zone> zones) {
        if ( zones == null ) {
            return null;
        }

        List<ZoneDto> list = new ArrayList<ZoneDto>( zones.size() );
        for ( Zone zone : zones ) {
            list.add( mapToDto( zone ) );
        }

        return list;
    }

    @Override
    public ZoneDto mapToDto(ZoneCreationViewModel zoneCreationViewModel) {
        if ( zoneCreationViewModel == null ) {
            return null;
        }

        String name = null;
        String internalCode = null;

        name = zoneCreationViewModel.getName();
        internalCode = zoneCreationViewModel.getInternalCode();

        UUID id = null;

        ZoneDto zoneDto = new ZoneDto( id, name, internalCode );

        return zoneDto;
    }

    @Override
    public Zone map(ZoneDto zoneDto) {
        if ( zoneDto == null ) {
            return null;
        }

        Zone zone = new Zone();

        zone.setId( zoneDto.getId() );
        zone.setName( zoneDto.getName() );
        zone.setInternalCode( zoneDto.getInternalCode() );

        return zone;
    }

    @Override
    public ZoneViewModel mapToVm(ZoneDto zoneDto) {
        if ( zoneDto == null ) {
            return null;
        }

        ZoneViewModel zoneViewModel = new ZoneViewModel();

        zoneViewModel.id( zoneDto.getId() );
        zoneViewModel.name( zoneDto.getName() );
        zoneViewModel.internalCode( zoneDto.getInternalCode() );

        return zoneViewModel;
    }

    @Override
    public List<ZoneViewModel> mapToVm(List<ZoneDto> zoneDtos) {
        if ( zoneDtos == null ) {
            return null;
        }

        List<ZoneViewModel> list = new ArrayList<ZoneViewModel>( zoneDtos.size() );
        for ( ZoneDto zoneDto : zoneDtos ) {
            list.add( mapToVm( zoneDto ) );
        }

        return list;
    }
}
