package ru.aston.dz2.dtos;

import org.junit.jupiter.api.Test;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LandmarkDtoTest {

    @Test
    void testLandmarkDtoFields() {
        Long id = 1L;
        String name = "name";
        LocalDate creationDate = LocalDate.of(80, 9, 1);
        String description = "desc1";
        LandmarkType type = LandmarkType.PARK;

        TownDto town = new TownDto();
        town.setId(2L);
        town.setName("town name");
        town.setPopulation(2872800);
        town.setHasMetro(true);

        TravelServiceDto travelService = new TravelServiceDto();
        travelService.setId(1L);
        travelService.setName("Guided Tour");
        List<TravelServiceDto> services = List.of(travelService);

        LandmarkDto dto = new LandmarkDto();
        dto.setId(id);
        dto.setName(name);
        dto.setCreationDate(creationDate);
        dto.setDescription(description);
        dto.setType(type);
        dto.setTownId(town.getId());
        dto.setServices(services);

        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getCreationDate()).isEqualTo(creationDate);
        assertThat(dto.getDescription()).isEqualTo(description);
        assertThat(dto.getType()).isEqualTo(type);
        assertThat(dto.getTownId()).isEqualTo(town.getId());
        assertThat(dto.getServices()).containsExactlyElementsOf(services);
    }

    @Test
    void testLandmarkDtoEqualsAndHashCode() {

        TownDto town1 = new TownDto();
        town1.setId(2L);
        town1.setName("town name");
        town1.setPopulation(2872800);
        town1.setHasMetro(true);

        TravelServiceDto travelService1 = new TravelServiceDto();
        travelService1.setId(1L);
        travelService1.setName("Guided Tour");

        LandmarkDto dto1 = new LandmarkDto();
        dto1.setId(1L);
        dto1.setName("name");
        dto1.setCreationDate(LocalDate.of(80, 9, 1));
        dto1.setDescription("desc1");
        dto1.setType(LandmarkType.PARK);
        dto1.setTownId(town1.getId());
        dto1.setServices(List.of(travelService1));

        TownDto town2 = new TownDto();
        town2.setId(2L);
        town2.setName("town name");
        town2.setPopulation(2872800);
        town2.setHasMetro(true);

        TravelServiceDto travelService2 = new TravelServiceDto();
        travelService2.setId(1L);
        travelService2.setName("Guided Tour");

        LandmarkDto dto2 = new LandmarkDto();
        dto2.setId(1L);
        dto2.setName("name");
        dto2.setCreationDate(LocalDate.of(80, 9, 1));
        dto2.setDescription("desc1");
        dto2.setType(LandmarkType.PARK);
        dto2.setTownId(town2.getId());
        dto2.setServices(List.of(travelService2));

        assertThat(dto1)
                .isEqualTo(dto2)
                .hasSameHashCodeAs(dto2);

    }

    @Test
    void testLandmarkDtoToString() {
        LandmarkDto dto = new LandmarkDto();
        dto.setName("name");
        dto.setDescription("desc1");

        assertThat(dto.toString()).contains("name", "desc1");
    }
}
