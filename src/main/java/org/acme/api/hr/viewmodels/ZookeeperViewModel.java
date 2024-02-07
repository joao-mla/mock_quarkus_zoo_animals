package org.acme.api.hr.viewmodels;

import lombok.Data;

import java.util.UUID;

@Data
public class ZookeeperViewModel {
    private UUID id;
    private PersonViewModel person;
}
