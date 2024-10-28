package ru.aston.dz2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.aston.dz2.dtos.service.TravelServiceCreateDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;
import ru.aston.dz2.model.TravelService;

@Mapper(componentModel = "spring")
public interface TravelServiceMapper {

    @Mapping(target = "id", ignore = true)
    TravelService toEntity(TravelServiceCreateDto travelServiceCreateDto);

    TravelServiceDto toDto(TravelService travelService);

    TravelService toEntity(TravelServiceUpdateDto travelServiceUpdateDto);
}
