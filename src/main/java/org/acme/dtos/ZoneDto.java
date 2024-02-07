package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ZoneDto {
    private UUID id;
    String name;
    String internalCode;
}
