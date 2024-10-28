package ru.aston.dz2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.model.landmark.Landmark;

import java.util.List;

/**
 * Entity representing a town.
 */
@Entity
@Table(name = "towns")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Town {

    /** The unique identifier for the town. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /** The name of the town. */
    @Column(name = "name", nullable = false)
    String name;

    /** The population of the town. */
    @Column(name = "population")
    Integer population;

    /** Indicates if the town has a metro system. */
    @Column(name = "has_metro")
    Boolean hasMetro;

    /** The list of landmarks associated with the town. */
    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Landmark> landmarks;
}
