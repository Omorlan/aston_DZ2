package ru.aston.dz2.dtos;


import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;

import static org.assertj.core.api.Assertions.assertThat;

class TravelServiceUpdateDtoTest {

    @Test
    void testTravelServiceUpdateDtoFields() {
        String name = "name";
        String description = "desc";

        TravelServiceUpdateDto dto = new TravelServiceUpdateDto();
        dto.setName(name);
        dto.setDescription(description);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getDescription()).isEqualTo(description);
    }

    @Test
    void testTravelServiceUpdateDtoEqualsAndHashCode() {
        TravelServiceUpdateDto dto1 = new TravelServiceUpdateDto();
        dto1.setName("name");
        dto1.setDescription("desc");

        TravelServiceUpdateDto dto2 = new TravelServiceUpdateDto();
        dto2.setName("name");
        dto2.setDescription("desc");

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);
    }

    @Test
    void testTravelServiceUpdateDtoToString() {
        TravelServiceUpdateDto dto = new TravelServiceUpdateDto();
        dto.setName("name");
        dto.setDescription("desc");

        assertThat(dto.toString()).contains("name", "desc");
    }
}
