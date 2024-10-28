package ru.aston.dz2.dtos.town;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TownCreateDto {
    String name;
    Integer population;
    Boolean hasMetro;
}
