package org.acme.persistence.enitities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "space", schema = "animal-service")
@Getter
@Setter
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String internalCode;

    @ManyToOne
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Zone zone;

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", internal_code='" + internalCode + '\'' +
                ", zone=" + zone +
                '}';
    }
}
