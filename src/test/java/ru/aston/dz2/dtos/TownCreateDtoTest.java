package ru.aston.dz2.dtos;


import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.town.TownCreateDto;

import static org.assertj.core.api.Assertions.assertThat;

class TownCreateDtoTest {

    @Test
    void testTownCreateDtoFields() {
        String name = "name";
        Integer population = 11920000;
        Boolean hasMetro = true;

        TownCreateDto dto = new TownCreateDto();
        dto.setName(name);
        dto.setPopulation(population);
        dto.setHasMetro(hasMetro);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getPopulation()).isEqualTo(population);
        assertThat(dto.getHasMetro()).isEqualTo(hasMetro);
    }

    @Test
    void testTownCreateDtoEqualsAndHashCode() {
        TownCreateDto dto1 = new TownCreateDto();
        dto1.setName("name");
        dto1.setPopulation(11920000);
        dto1.setHasMetro(true);

        TownCreateDto dto2 = new TownCreateDto();
        dto2.setName("name");
        dto2.setPopulation(11920000);
        dto2.setHasMetro(true);

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);

    }

    @Test
    void testTownCreateDtoToString() {
        TownCreateDto dto = new TownCreateDto();
        dto.setName("name");
        dto.setPopulation(11920000);
        dto.setHasMetro(true);

        assertThat(dto.toString()).contains("name");
    }
}
