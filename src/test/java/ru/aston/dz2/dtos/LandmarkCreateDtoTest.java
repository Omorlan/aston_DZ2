package ru.aston.dz2.dtos;


import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LandmarkCreateDtoTest {

    @Test
    void testLandmarkCreateDtoFields() {

        String name = "name1";
        LocalDate creationDate = LocalDate.of(1889, 3, 31);
        String description = "desc";
        LandmarkType type = LandmarkType.PARK;
        Long townId = 1L;
        List<Long> serviceIds = List.of(2L, 3L);

        LandmarkCreateDto dto = new LandmarkCreateDto();
        dto.setName(name);
        dto.setCreationDate(creationDate);
        dto.setDescription(description);
        dto.setType(type);
        dto.setTownId(townId);
        dto.setServiceIds(serviceIds);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getCreationDate()).isEqualTo(creationDate);
        assertThat(dto.getDescription()).isEqualTo(description);
        assertThat(dto.getType()).isEqualTo(type);
        assertThat(dto.getTownId()).isEqualTo(townId);
        assertThat(dto.getServiceIds()).containsExactlyElementsOf(serviceIds);
    }

    @Test
    void testLandmarkCreateDtoEqualsAndHashCode() {
        LandmarkCreateDto dto1 = new LandmarkCreateDto();
        dto1.setName("name1");
        dto1.setCreationDate(LocalDate.of(1889, 3, 31));
        dto1.setDescription("desc1");
        dto1.setType(LandmarkType.PARK);
        dto1.setTownId(1L);
        dto1.setServiceIds(List.of(2L, 3L));

        LandmarkCreateDto dto2 = new LandmarkCreateDto();
        dto2.setName("name1");
        dto2.setCreationDate(LocalDate.of(1889, 3, 31));
        dto2.setDescription("desc1");
        dto2.setType(LandmarkType.PARK);
        dto2.setTownId(1L);
        dto2.setServiceIds(List.of(2L, 3L));

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);

    }

    @Test
    void testLandmarkCreateDtoToString() {
        LandmarkCreateDto dto = new LandmarkCreateDto();
        dto.setName("name1");
        dto.setDescription("desc1");
        assertThat(dto.toString()).contains("name1", "desc1");
    }
}
