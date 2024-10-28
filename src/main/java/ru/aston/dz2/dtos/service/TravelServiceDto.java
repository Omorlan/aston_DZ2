package ru.aston.dz2.dtos.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.dtos.landmark.LandmarkDto;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TravelServiceDto {
    Long id;
    String name;
    String description;
    List<LandmarkDto> landmarks;
}
