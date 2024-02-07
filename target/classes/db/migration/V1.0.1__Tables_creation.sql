CREATE TABLE species
(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE zone
(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    internal_code VARCHAR(2)
);

CREATE TABLE space
(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    internal_code VARCHAR(5),
    zone_id UUID,
    CONSTRAINT fk_zone FOREIGN KEY (zone_id) REFERENCES zone(id)
);

CREATE TABLE enclosure
(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    space_id UUID,
    CONSTRAINT fk_space FOREIGN KEY (space_id) REFERENCES space(id)
);

CREATE TABLE animal
(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    species_id UUID,
    enclosure_id UUID,
    CONSTRAINT fk_species FOREIGN KEY (species_id) REFERENCES species(id),
    CONSTRAINT fk_enclosure FOREIGN KEY (enclosure_id) REFERENCES enclosure(id)
);