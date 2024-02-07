package org.acme.api.hr.viewmodels;

import lombok.Data;

import java.util.UUID;

@Data
public class PersonViewModel {
    private UUID id;
    private String forename;
    private String surname;
}
