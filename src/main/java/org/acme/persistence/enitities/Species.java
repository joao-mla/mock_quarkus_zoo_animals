package org.acme.persistence.enitities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "species", schema = "animal-service")
@Getter
@Setter
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
