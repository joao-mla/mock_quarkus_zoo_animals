package org.acme.maps;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.acme.dtos.SpeciesDto;
import org.acme.persistence.enitities.Species;
import org.openapi.quarkus.api_yaml.model.SpeciesCreationViewModel;
import org.openapi.quarkus.api_yaml.model.SpeciesViewModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T11:36:18+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class SpeciesMapperImpl implements SpeciesMapper {

    @Override
    public SpeciesDto map(Species species) {
        if ( species == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = species.getId();
        name = species.getName();

        SpeciesDto speciesDto = new SpeciesDto( id, name );

        return speciesDto;
    }

    @Override
    public List<SpeciesDto> map(List<Species> species) {
        if ( species == null ) {
            return null;
        }

        List<SpeciesDto> list = new ArrayList<SpeciesDto>( species.size() );
        for ( Species species1 : species ) {
            list.add( map( species1 ) );
        }

        return list;
    }

    @Override
    public SpeciesDto map(SpeciesCreationViewModel vm) {
        if ( vm == null ) {
            return null;
        }

        String name = null;

        name = vm.getName();

        UUID id = null;

        SpeciesDto speciesDto = new SpeciesDto( id, name );

        return speciesDto;
    }

    @Override
    public Species map(SpeciesDto species) {
        if ( species == null ) {
            return null;
        }

        Species species1 = new Species();

        species1.setId( species.getId() );
        species1.setName( species.getName() );

        return species1;
    }

    @Override
    public List<SpeciesViewModel> mapToVm(List<SpeciesDto> speciesDtos) {
        if ( speciesDtos == null ) {
            return null;
        }

        List<SpeciesViewModel> list = new ArrayList<SpeciesViewModel>( speciesDtos.size() );
        for ( SpeciesDto speciesDto : speciesDtos ) {
            list.add( mapToVm( speciesDto ) );
        }

        return list;
    }

    @Override
    public SpeciesViewModel mapToVm(SpeciesDto speciesDtos) {
        if ( speciesDtos == null ) {
            return null;
        }

        SpeciesViewModel speciesViewModel = new SpeciesViewModel();

        speciesViewModel.id( speciesDtos.getId() );
        speciesViewModel.name( speciesDtos.getName() );

        return speciesViewModel;
    }
}
