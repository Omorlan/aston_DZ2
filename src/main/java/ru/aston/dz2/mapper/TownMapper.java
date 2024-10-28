package ru.aston.dz2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aston.dz2.dtos.town.TownCreateDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.dtos.town.TownUpdateDto;
import ru.aston.dz2.model.Town;

@Mapper(componentModel = "spring")
public interface TownMapper {

    @Mapping(target = "id", ignore = true)
    Town toEntity(TownCreateDto townCreateDto);

    TownDto toDto(Town town);

    Town toEntity(TownUpdateDto townUpdateDto);
}
