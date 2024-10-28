package ru.aston.dz2.service;

import ru.aston.dz2.dtos.service.TravelServiceCreateDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;

import java.util.List;

public interface TravelServiceService {
    TravelServiceDto addService(TravelServiceCreateDto travelServiceCreateDto);
    List<TravelServiceDto> getAllServices();
    TravelServiceDto updateService(Long id, TravelServiceUpdateDto travelServiceUpdateDto);
    void deleteService(Long id);
}
