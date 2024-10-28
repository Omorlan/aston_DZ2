package ru.aston.dz2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.model.landmark.Landmark;



@Mapper(componentModel = "spring")
public interface LandmarkMapper {
    @Mapping(source = "townId", target = "town.id")
    Landmark toEntity(LandmarkCreateDto dto);

    @Mapping(source = "town.id", target = "townId")
    LandmarkDto toDto(Landmark entity);
}
