package ru.aston.dz2.dtos.landmark;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LandmarkUpdateDto {
    String description;
}
