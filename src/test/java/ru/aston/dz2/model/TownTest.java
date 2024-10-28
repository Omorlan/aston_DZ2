package ru.aston.dz2.model;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TownTest {

    @Test
    void testTownFields() {
        Long id = 1L;
        String name = "name";
        Integer population = 15;
        Boolean hasMetro = true;

        Town town = new Town();
        town.setId(id);
        town.setName(name);
        town.setPopulation(population);
        town.setHasMetro(hasMetro);
        town.setLandmarks(List.of());

        assertThat(town.getId()).isEqualTo(id);
        assertThat(town.getName()).isEqualTo(name);
        assertThat(town.getPopulation()).isEqualTo(population);
        assertThat(town.getHasMetro()).isEqualTo(hasMetro);
        assertThat(town.getLandmarks()).isEmpty();
    }

    @Test
    void testTownEqualsAndHashCode() {
        Town town1 = new Town();
        town1.setId(1L);
        town1.setName("name");
        town1.setPopulation(15);
        town1.setHasMetro(true);
        town1.setLandmarks(List.of());

        Town town2 = new Town();
        town2.setId(1L);
        town2.setName("name");
        town2.setPopulation(15);
        town2.setHasMetro(true);
        town2.setLandmarks(List.of());

        assertThat(town1)
                .isEqualTo(town2)
                .hasSameHashCodeAs(town2);

    }

    @Test
    void testTownToString() {
        Town town = new Town();
        town.setName("name");

        assertThat(town.toString()).contains("name");
    }
}
