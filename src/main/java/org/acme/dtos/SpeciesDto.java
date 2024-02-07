package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SpeciesDto {
    private UUID id;
    private String name;
}
