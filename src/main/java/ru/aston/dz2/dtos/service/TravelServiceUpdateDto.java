package ru.aston.dz2.dtos.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TravelServiceUpdateDto {
    String name;
    String description;
}
