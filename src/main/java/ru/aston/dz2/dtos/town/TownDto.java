package ru.aston.dz2.dtos.town;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.dtos.landmark.LandmarkDto;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TownDto {
    Long id;
    String name;
    Integer population;
    Boolean hasMetro;
    List<LandmarkDto> landmarks;
}
