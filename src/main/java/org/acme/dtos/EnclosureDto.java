package org.acme.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.acme.persistence.enitities.Animal;
import org.acme.persistence.enitities.Space;

import java.util.Set;

@Data
@AllArgsConstructor
public class EnclosureDto {
    private String name;
    private SpaceDto space;
    private Set<AnimalDto> animals;
}
