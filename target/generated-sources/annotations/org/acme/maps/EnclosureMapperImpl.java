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
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Space;
import org.acme.persistence.enitities.Species;
import org.acme.persistence.enitities.Zone;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureAnimalViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureCreationViewModel;
import org.openapi.quarkus.api_yaml.model.EnclosureViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T11:36:18+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class EnclosureMapperImpl implements EnclosureMapper {

    @Override
    public EnclosureDto map(Enclosure enclosure) {
        if ( enclosure == null ) {
            return null;
        }

        String name = null;
        SpaceDto space = null;
        Set<AnimalDto> animals = null;

        name = enclosure.getName();
        space = spaceToSpaceDto( enclosure.getSpace() );
        animals = animalSetToAnimalDtoSet( enclosure.getAnimals() );

        EnclosureDto enclosureDto = new EnclosureDto( name, space, animals );

        return enclosureDto;
    }

    @Override
    public List<EnclosureDto> map(List<Enclosure> enclosures) {
        if ( enclosures == null ) {
            return null;
        }

        List<EnclosureDto> list = new ArrayList<EnclosureDto>( enclosures.size() );
        for ( Enclosure enclosure : enclosures ) {
            list.add( map( enclosure ) );
        }

        return list;
    }

    @Override
    public Enclosure map(EnclosureDto enclosure) {
        if ( enclosure == null ) {
            return null;
        }

        Enclosure enclosure1 = new Enclosure();

        enclosure1.setName( enclosure.getName() );
        enclosure1.setSpace( spaceDtoToSpace( enclosure.getSpace() ) );
        enclosure1.setAnimals( animalDtoSetToAnimalSet( enclosure.getAnimals() ) );

        return enclosure1;
    }

    @Override
    public EnclosureDto map(EnclosureCreationViewModel vm, SpaceDto space) {
        if ( vm == null && space == null ) {
            return null;
        }

        String name = null;
        if ( vm != null ) {
            name = vm.getName();
        }

        SpaceDto space1 = space;
        Set<AnimalDto> animals = null;

        EnclosureDto enclosureDto = new EnclosureDto( name, space1, animals );

        return enclosureDto;
    }

    @Override
    public List<EnclosureViewModel> mapToVm(List<EnclosureDto> enclosureDtos) {
        if ( enclosureDtos == null ) {
            return null;
        }

        List<EnclosureViewModel> list = new ArrayList<EnclosureViewModel>( enclosureDtos.size() );
        for ( EnclosureDto enclosureDto : enclosureDtos ) {
            list.add( mapToVm( enclosureDto ) );
        }

        return list;
    }

    @Override
    public EnclosureViewModel mapToVm(EnclosureDto enclosureDto) {
        if ( enclosureDto == null ) {
            return null;
        }

        EnclosureViewModel enclosureViewModel = new EnclosureViewModel();

        enclosureViewModel.name( enclosureDto.getName() );
        enclosureViewModel.space( spaceDtoToSpaceViewModel( enclosureDto.getSpace() ) );
        enclosureViewModel.animals( animalDtoSetToAnimalViewModelList( enclosureDto.getAnimals() ) );

        return enclosureViewModel;
    }

    protected SpaceDto spaceToSpaceDto(Space space) {
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

    protected AnimalDto animalToAnimalDto(Animal animal) {
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

    protected Set<AnimalDto> animalSetToAnimalDtoSet(Set<Animal> set) {
        if ( set == null ) {
            return null;
        }

        Set<AnimalDto> set1 = new LinkedHashSet<AnimalDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Animal animal : set ) {
            set1.add( animalToAnimalDto( animal ) );
        }

        return set1;
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

    protected Animal animalDtoToAnimal(AnimalDto animalDto) {
        if ( animalDto == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setId( animalDto.getId() );
        animal.setName( animalDto.getName() );
        animal.setSpecies( animalDto.getSpecies() );
        animal.setEnclosure( animalDto.getEnclosure() );

        return animal;
    }

    protected Set<Animal> animalDtoSetToAnimalSet(Set<AnimalDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Animal> set1 = new LinkedHashSet<Animal>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnimalDto animalDto : set ) {
            set1.add( animalDtoToAnimal( animalDto ) );
        }

        return set1;
    }

    protected SpaceViewModel spaceDtoToSpaceViewModel(SpaceDto spaceDto) {
        if ( spaceDto == null ) {
            return null;
        }

        SpaceViewModel spaceViewModel = new SpaceViewModel();

        spaceViewModel.id( spaceDto.getId() );
        spaceViewModel.name( spaceDto.getName() );

        return spaceViewModel;
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

    protected AnimalViewModel animalDtoToAnimalViewModel(AnimalDto animalDto) {
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

    protected List<AnimalViewModel> animalDtoSetToAnimalViewModelList(Set<AnimalDto> set) {
        if ( set == null ) {
            return null;
        }

        List<AnimalViewModel> list = new ArrayList<AnimalViewModel>( set.size() );
        for ( AnimalDto animalDto : set ) {
            list.add( animalDtoToAnimalViewModel( animalDto ) );
        }

        return list;
    }
}
