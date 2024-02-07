package org.acme.maps;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.acme.dtos.AnimalDto;
import org.acme.dtos.EnclosureDto;
import org.acme.dtos.SpaceDto;
import org.acme.dtos.SpeciesDto;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Space;
import org.acme.persistence.enitities.Species;
import org.openapi.quarkus.api_yaml.model.AnimalCreationViewModel;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureAnimalViewModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T11:36:18+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public List<AnimalViewModel> map(List<Animal> animals) {
        if ( animals == null ) {
            return null;
        }

        List<AnimalViewModel> list = new ArrayList<AnimalViewModel>( animals.size() );
        for ( Animal animal : animals ) {
            list.add( mapToVm( mapToDto( animal ) ) );
        }

        return list;
    }

    @Override
    public Animal map(AnimalDto animal) {
        if ( animal == null ) {
            return null;
        }

        Animal animal1 = new Animal();

        animal1.setId( animal.getId() );
        animal1.setName( animal.getName() );
        animal1.setSpecies( animal.getSpecies() );
        animal1.setEnclosure( animal.getEnclosure() );

        return animal1;
    }

    @Override
    public AnimalDto map(AnimalCreationViewModel vm, SpeciesDto species, EnclosureDto enclosure) {
        if ( vm == null && species == null && enclosure == null ) {
            return null;
        }

        String name = null;
        if ( vm != null ) {
            name = vm.getName();
        }
        UUID id = null;
        if ( species != null ) {
            id = species.getId();
        }

        Species species1 = map(species);
        Enclosure enclosure1 = map(enclosure);

        AnimalDto animalDto = new AnimalDto( id, name, species1, enclosure1 );

        return animalDto;
    }

    @Override
    public Species map(SpeciesDto speciesDto) {
        if ( speciesDto == null ) {
            return null;
        }

        Species species = new Species();

        species.setId( speciesDto.getId() );
        species.setName( speciesDto.getName() );

        return species;
    }

    @Override
    public Enclosure map(EnclosureDto enclosureDto) {
        if ( enclosureDto == null ) {
            return null;
        }

        Enclosure enclosure = new Enclosure();

        enclosure.setName( enclosureDto.getName() );
        enclosure.setSpace( spaceDtoToSpace( enclosureDto.getSpace() ) );
        enclosure.setAnimals( animalDtoSetToAnimalSet( enclosureDto.getAnimals() ) );

        return enclosure;
    }

    @Override
    public List<AnimalDto> mapToDto(List<Animal> animal) {
        if ( animal == null ) {
            return null;
        }

        List<AnimalDto> list = new ArrayList<AnimalDto>( animal.size() );
        for ( Animal animal1 : animal ) {
            list.add( mapToDto( animal1 ) );
        }

        return list;
    }

    @Override
    public AnimalDto mapToDto(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        Species species = null;
        Enclosure enclosure = null;

        id = animal.getId();
        name = animal.getName();
        species = animal.getSpecies();
        enclosure = animal.getEnclosure();

        AnimalDto animalDto = new AnimalDto( id, name, species, enclosure );

        return animalDto;
    }

    @Override
    public List<AnimalViewModel> mapToVm(List<AnimalDto> animalDto) {
        if ( animalDto == null ) {
            return null;
        }

        List<AnimalViewModel> list = new ArrayList<AnimalViewModel>( animalDto.size() );
        for ( AnimalDto animalDto1 : animalDto ) {
            list.add( mapToVm( animalDto1 ) );
        }

        return list;
    }

    @Override
    public AnimalViewModel mapToVm(AnimalDto animalDto) {
        if ( animalDto == null ) {
            return null;
        }

        AnimalViewModel animalViewModel = new AnimalViewModel();

        animalViewModel.id( animalDto.getId() );
        animalViewModel.name( animalDto.getName() );
        animalViewModel.species( map( animalDto.getSpecies() ) );
        animalViewModel.enclosure( enclosureToEnclosureAnimalViewModel( animalDto.getEnclosure() ) );

        return animalViewModel;
    }

    protected Space spaceDtoToSpace(SpaceDto spaceDto) {
        if ( spaceDto == null ) {
            return null;
        }

        Space space = new Space();

        space.setId( spaceDto.getId() );
        space.setName( spaceDto.getName() );
        space.setZone( spaceDto.getZone() );

        return space;
    }

    protected Set<Animal> animalDtoSetToAnimalSet(Set<AnimalDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Animal> set1 = new LinkedHashSet<Animal>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnimalDto animalDto : set ) {
            set1.add( map( animalDto ) );
        }

        return set1;
    }

    protected EnclosureAnimalViewModel enclosureToEnclosureAnimalViewModel(Enclosure enclosure) {
        if ( enclosure == null ) {
            return null;
        }

        EnclosureAnimalViewModel enclosureAnimalViewModel = new EnclosureAnimalViewModel();

        enclosureAnimalViewModel.id( enclosure.getId() );
        enclosureAnimalViewModel.name( enclosure.getName() );

        return enclosureAnimalViewModel;
    }
}
