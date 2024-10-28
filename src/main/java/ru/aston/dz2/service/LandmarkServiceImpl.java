package ru.aston.dz2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.landmark.LandmarkUpdateDto;
import ru.aston.dz2.mapper.LandmarkMapper;
import ru.aston.dz2.model.Town;
import ru.aston.dz2.model.TravelService;
import ru.aston.dz2.model.landmark.Landmark;
import ru.aston.dz2.model.landmark.LandmarkType;
import ru.aston.dz2.repository.LandmarkRepository;
import ru.aston.dz2.repository.TownRepository;
import ru.aston.dz2.repository.TravelServiceRepository;

import java.util.Comparator;
import java.util.List;

/**
 * Service implementation for managing landmarks.
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LandmarkServiceImpl implements LandmarkService {

    private final LandmarkRepository landmarkRepository;
    private final TownRepository townRepository;
    private final TravelServiceRepository travelServiceRepository;
    private final LandmarkMapper landmarkMapper;

    /**
     * Adds a new landmark.
     *
     * @param landmarkCreateDto DTO containing the landmark information.
     * @return The created landmark as a DTO.
     */
    @Override
    public LandmarkDto addLandmark(LandmarkCreateDto landmarkCreateDto) {
        log.info("Adding new landmark with data: {}", landmarkCreateDto);

        Landmark landmark = landmarkMapper.toEntity(landmarkCreateDto);
        Town town = townRepository.findById(landmarkCreateDto.getTownId())
                .orElseThrow(() -> new IllegalArgumentException("Town not found"));
        landmark.setTown(town);

        List<TravelService> travelServices = travelServiceRepository.findAllById(landmarkCreateDto.getServiceIds());
        landmark.setTravelServices(travelServices);

        travelServices.forEach(service -> service.getLandmarks().add(landmark));

        log.info("Landmark to be saved: {}", landmark);
        return landmarkMapper.toDto(landmarkRepository.save(landmark));
    }

    /**
     * Retrieves all landmarks, optionally filtered by type and sorted by a specified field.
     *
     * @param sortBy Optional parameter to sort landmarks by a specified field.
     * @param type   Optional parameter to filter landmarks by type.
     * @return A list of landmarks as DTOs.
     */
    @Override
    @Transactional(readOnly = true)
    public List<LandmarkDto> getAllLandmarks(String sortBy, LandmarkType type) {
        log.info("Fetching all landmarks with sort by: {}, and type: {}", sortBy, type);

        List<Landmark> landmarks;
        if (type != null) {
            landmarks = landmarkRepository.findByType(type);
        } else {
            landmarks = landmarkRepository.findAll();
        }

        if ("name".equals(sortBy)) {
            landmarks = landmarks.stream()
                    .sorted(Comparator.comparing(Landmark::getName))
                    .toList();
        }

        log.info("Total landmarks fetched: {}", landmarks.size());
        return landmarks.stream()
                .map(landmarkMapper::toDto)
                .toList();
    }

    /**
     * Retrieves all landmarks associated with a specific town.
     *
     * @param townId The ID of the town.
     * @return A list of landmarks associated with the town as DTOs.
     */
    @Override
    @Transactional(readOnly = true)
    public List<LandmarkDto> getLandmarksByTown(Long townId) {
        log.info("Fetching landmarks for town with ID: {}", townId);
        return landmarkRepository.findByTownId(townId).stream()
                .map(landmarkMapper::toDto)
                .toList();
    }

    /**
     * Updates an existing landmark.
     *
     * @param id                The ID of the landmark to update.
     * @param landmarkUpdateDto DTO containing the updated landmark information.
     * @return The updated landmark as a DTO.
     */
    @Override
    public LandmarkDto updateLandmark(Long id, LandmarkUpdateDto landmarkUpdateDto) {
        log.info("Updating landmark with ID: {}", id);

        Landmark landmark = landmarkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Landmark not found"));
        landmark.setDescription(landmarkUpdateDto.getDescription());

        log.info("Landmark updated: {}", landmark);
        return landmarkMapper.toDto(landmarkRepository.save(landmark));
    }

    /**
     * Deletes a landmark by its ID.
     *
     * @param id The ID of the landmark to delete.
     */
    @Override
    public void deleteLandmark(Long id) {
        log.info("Deleting landmark with ID: {}", id);
        landmarkRepository.deleteById(id);
    }
}
