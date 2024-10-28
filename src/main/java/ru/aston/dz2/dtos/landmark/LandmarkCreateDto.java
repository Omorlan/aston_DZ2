package ru.aston.dz2.dtos.landmark;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LandmarkCreateDto {
    String name;
    LocalDate creationDate;
    String description;
    LandmarkType type;
    Long townId;
    List<Long> serviceIds;
}
