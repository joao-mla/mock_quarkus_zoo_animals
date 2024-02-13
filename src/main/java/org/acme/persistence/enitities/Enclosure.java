package org.acme.persistence.enitities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "enclosure")
@Getter
@Setter
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "space_id", nullable = false)
    private Space space;

    @OneToMany(mappedBy = "enclosure")
    private Set<Animal> animals;

    @ElementCollection
    private Set<UUID> zookeepers;

    @Override
    public String toString() {
        return "Enclosure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", space=" + space +
                ", animal count=" + animals.size() +
                '}';
    }
}
