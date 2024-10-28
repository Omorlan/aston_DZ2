package ru.aston.dz2.model.landmark;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.model.Town;
import ru.aston.dz2.model.TravelService;

import java.time.LocalDate;
import java.util.List;

/**
 * Entity representing a landmark.
 */
@Entity
@Table(name = "landmarks")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate creationDate;

    @Column(name = "description", length = 500)
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    LandmarkType type;

    @ManyToOne
    @JoinColumn(name = "town_id", nullable = false)
    @JsonBackReference
    Town town;

    @ManyToMany
    @JoinTable(
            name = "landmark_services",
            joinColumns = @JoinColumn(name = "landmark_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonManagedReference
    List<TravelService> travelServices;

    @Override
    public String toString() {
        return "Landmark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", town=" + (town != null ? town.getName() : "null") +  // Выводим только имя города
                '}';
    }

}
