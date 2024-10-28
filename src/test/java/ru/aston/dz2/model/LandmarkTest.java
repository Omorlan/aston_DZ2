package ru.aston.dz2.model;

import org.junit.jupiter.api.Test;
import ru.aston.dz2.model.landmark.Landmark;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LandmarkTest {

    @Test
    void testLandmarkFields() {
        Long id = 1L;
        String name = "name";
        LocalDate creationDate = LocalDate.of(80, 9, 1);
        String description = "desc";
        LandmarkType type = LandmarkType.PARK;
        Town town = new Town();
        town.setId(2L);
        town.setName("name2");
        town.setPopulation(2872800);
        town.setHasMetro(true);

        Landmark landmark = new Landmark();
        landmark.setId(id);
        landmark.setName(name);
        landmark.setCreationDate(creationDate);
        landmark.setDescription(description);
        landmark.setType(type);
        landmark.setTown(town);
        landmark.setTravelServices(List.of());

        assertThat(landmark.getId()).isEqualTo(id);
        assertThat(landmark.getName()).isEqualTo(name);
        assertThat(landmark.getCreationDate()).isEqualTo(creationDate);
        assertThat(landmark.getDescription()).isEqualTo(description);
        assertThat(landmark.getType()).isEqualTo(type);
        assertThat(landmark.getTown()).isEqualTo(town);
        assertThat(landmark.getTravelServices()).isEmpty();
    }

    @Test
    void testLandmarkEqualsAndHashCode() {
        Town town = new Town();
        town.setId(2L);
        town.setName("name2");
        town.setPopulation(2872800);
        town.setHasMetro(true);

        Landmark landmark1 = new Landmark();
        landmark1.setId(1L);
        landmark1.setName("name");
        landmark1.setCreationDate(LocalDate.of(80, 9, 1));
        landmark1.setDescription("desc");
        landmark1.setType(LandmarkType.PARK);
        landmark1.setTown(town);
        landmark1.setTravelServices(List.of());

        Landmark landmark2 = new Landmark();
        landmark2.setId(1L);
        landmark2.setName("name");
        landmark2.setCreationDate(LocalDate.of(80, 9, 1));
        landmark2.setDescription("desc");
        landmark2.setType(LandmarkType.PARK);
        landmark2.setTown(town);
        landmark2.setTravelServices(List.of());

        assertThat(landmark1)
                .isEqualTo(landmark2)
                .hasSameHashCodeAs(landmark2);
    }

    @Test
    void testLandmarkToString() {
        Landmark landmark = new Landmark();
        landmark.setName("name");
        landmark.setDescription("desc");

        assertThat(landmark.toString()).contains("name", "desc");
    }
}
