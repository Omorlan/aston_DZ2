package ru.aston.dz2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.dz2.dtos.service.TravelServiceCreateDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;
import ru.aston.dz2.mapper.TravelServiceMapper;
import ru.aston.dz2.model.TravelService;
import ru.aston.dz2.repository.TravelServiceRepository;

import java.util.List;


/**
 * Service implementation for managing travel services.
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TravelServiceServiceImpl implements TravelServiceService {

    private final TravelServiceRepository travelServiceRepository;
    private final TravelServiceMapper travelServiceMapper;

    /**
     * Adds a new travel service.
     *
     * @param travelServiceCreateDto DTO containing the service information.
     * @return The created travel service as a DTO.
     */
    @Override
    public TravelServiceDto addService(TravelServiceCreateDto travelServiceCreateDto) {
        log.info("Adding new travel service with data: {}", travelServiceCreateDto);

        TravelService service = travelServiceMapper.toEntity(travelServiceCreateDto);
        TravelServiceDto savedService = travelServiceMapper.toDto(travelServiceRepository.save(service));

        log.info("Travel service created successfully with ID: {}", savedService.getId());
        return savedService;
    }

    /**
     * Retrieves all travel services.
     *
     * @return A list of all travel services as DTOs.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TravelServiceDto> getAllServices() {
        log.info("Fetching all travel services");

        List<TravelServiceDto> services = travelServiceRepository.findAll().stream()
                .map(travelServiceMapper::toDto)
                .toList();

        log.info("Total travel services fetched: {}", services.size());
        return services;
    }

    /**
     * Updates an existing travel service.
     *
     * @param id                     The ID of the service to update.
     * @param travelServiceUpdateDto DTO containing the updated service information.
     * @return The updated travel service as a DTO.
     */


    @Override
    public TravelServiceDto updateService(Long id, TravelServiceUpdateDto travelServiceUpdateDto) {
        log.info("Updating travel service with ID: {}", id);

        TravelService service = travelServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        service.setDescription(travelServiceUpdateDto.getDescription());
        TravelServiceDto updatedService = travelServiceMapper.toDto(travelServiceRepository.save(service));

        log.info("Travel service updated successfully with ID: {}", updatedService.getId());
        return updatedService;
    }

    /**
     * Deletes a travel service by its ID.
     *
     * @param id The ID of the service to delete.
     */
    @Override
    public void deleteService(Long id) {
        log.info("Deleting travel service with ID: {}", id);
        travelServiceRepository.deleteById(id);
        log.info("Travel service deleted successfully with ID: {}", id);
    }
}
