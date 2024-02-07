package org.acme.maps;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.acme.dtos.SpaceDto;
import org.acme.persistence.enitities.Space;
import org.acme.persistence.enitities.Zone;
import org.openapi.quarkus.api_yaml.model.SpaceCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T11:36:17+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class SpaceMapperImpl implements SpaceMapper {

    @Override
    public SpaceDto mapToDto(Space space) {
        if ( space == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        Zone zone = null;

        id = space.getId();
        name = space.getName();
        zone = space.getZone();

        String internal_code = null;

        SpaceDto spaceDto = new SpaceDto( id, name, internal_code, zone );

        return spaceDto;
    }

    @Override
    public Space map(SpaceDto space) {
        if ( space == null ) {
            return null;
        }

        Space space1 = new Space();

        space1.setId( space.getId() );
        space1.setName( space.getName() );
        space1.setZone( space.getZone() );

        return space1;
    }

    @Override
    public List<SpaceDto> mapToDto(List<Space> spaces) {
        if ( spaces == null ) {
            return null;
        }

        List<SpaceDto> list = new ArrayList<SpaceDto>( spaces.size() );
        for ( Space space : spaces ) {
            list.add( mapToDto( space ) );
        }

        return list;
    }

    @Override
    public SpaceDto mapToDto(SpaceCreationViewModel spaceCreationViewModel) {
        if ( spaceCreationViewModel == null ) {
            return null;
        }

        String name = null;

        name = spaceCreationViewModel.getName();

        UUID id = null;
        String internal_code = null;
        Zone zone = null;

        SpaceDto spaceDto = new SpaceDto( id, name, internal_code, zone );

        return spaceDto;
    }

    @Override
    public SpaceViewModel mapToVm(SpaceDto spaceDto) {
        if ( spaceDto == null ) {
            return null;
        }

        SpaceViewModel spaceViewModel = new SpaceViewModel();

        spaceViewModel.id( spaceDto.getId() );
        spaceViewModel.name( spaceDto.getName() );

        return spaceViewModel;
    }

    @Override
    public List<SpaceViewModel> mapToVm(List<SpaceDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<SpaceViewModel> list = new ArrayList<SpaceViewModel>( dtos.size() );
        for ( SpaceDto spaceDto : dtos ) {
            list.add( mapToVm( spaceDto ) );
        }

        return list;
    }
}
