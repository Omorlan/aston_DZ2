package ru.aston.dz2.dtos;

import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TravelServiceDtoTest {

    @Test
    void testTravelServiceDtoFields() {
        Long id = 1L;
        String name = "name";
        String description = "desc";
        LandmarkDto landmark1 = new LandmarkDto();
        landmark1.setId(1L);
        landmark1.setName("land1");

        LandmarkDto landmark2 = new LandmarkDto();
        landmark2.setId(2L);
        landmark2.setName("land2");

        List<LandmarkDto> landmarks = List.of(landmark1, landmark2);

        TravelServiceDto dto = new TravelServiceDto();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setLandmarks(landmarks);

        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getDescription()).isEqualTo(description);
        assertThat(dto.getLandmarks()).containsExactlyElementsOf(landmarks);
    }

    @Test
    void testTravelServiceDtoEqualsAndHashCode() {
        TravelServiceDto dto1 = new TravelServiceDto();
        dto1.setId(1L);
        dto1.setName("name");
        dto1.setDescription("desc");

        LandmarkDto landmark = new LandmarkDto();
        landmark.setId(1L);
        landmark.setName("land1");
        dto1.setLandmarks(List.of(landmark));

        TravelServiceDto dto2 = new TravelServiceDto();
        dto2.setId(1L);
        dto2.setName("name");
        dto2.setDescription("desc");
        dto2.setLandmarks(List.of(landmark));

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);
    }

    @Test
    void testTravelServiceDtoToString() {
        TravelServiceDto dto = new TravelServiceDto();
        dto.setName("name");
        dto.setDescription("desc");

        assertThat(dto.toString()).contains("name", "desc");
    }
}
