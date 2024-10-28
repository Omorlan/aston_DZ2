package ru.aston.dz2.dtos;


import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.service.TravelServiceCreateDto;

import static org.assertj.core.api.Assertions.assertThat;

class TravelServiceCreateDtoTest {

    @Test
    void testTravelServiceCreateDtoFields() {
        String name = "name";
        String description = "desc";

        TravelServiceCreateDto dto = new TravelServiceCreateDto();
        dto.setName(name);
        dto.setDescription(description);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getDescription()).isEqualTo(description);
    }

    @Test
    void testTravelServiceCreateDtoEqualsAndHashCode() {
        TravelServiceCreateDto dto1 = new TravelServiceCreateDto();
        dto1.setName("name");
        dto1.setDescription("desc");

        TravelServiceCreateDto dto2 = new TravelServiceCreateDto();
        dto2.setName("name");
        dto2.setDescription("desc");

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);
    }

    @Test
    void testTravelServiceCreateDtoToString() {
        TravelServiceCreateDto dto = new TravelServiceCreateDto();
        dto.setName("name");
        dto.setDescription("desc");

        assertThat(dto.toString()).contains("name", "desc");
    }
}
