package ru.aston.dz2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.model.landmark.Landmark;

import java.util.List;

/**
 * Entity representing a travel service.
 */
@Entity
@Table(name = "services")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TravelService {

    /** The unique identifier for the travel service. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /** The name of the travel service. */
    @Column(name = "name", nullable = false)
    String name;

    /** The description of the travel service. */
    @Column(name = "description", length = 500)
    String description;

    /** The list of landmarks associated with this travel service. */
    @ManyToMany(mappedBy = "travelServices")
    @JsonBackReference
    List<Landmark> landmarks;

    @Override
    public String toString() {
        return "TravelService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
