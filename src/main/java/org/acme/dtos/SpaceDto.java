package org.acme.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.acme.persistence.enitities.Zone;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SpaceDto {
    private UUID id;
    private String name;
    private String internal_code;
    private Zone zone;
}
