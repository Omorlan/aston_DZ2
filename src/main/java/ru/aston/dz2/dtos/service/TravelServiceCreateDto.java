package ru.aston.dz2.dtos.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TravelServiceCreateDto {
    String name;
    String description;
}
