package org.acme.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.acme.persistence.enitities.Enclosure;
import org.acme.persistence.enitities.Species;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AnimalDto {
    private UUID id;
    private String name;
    private Species species;
    private Enclosure enclosure;
}
