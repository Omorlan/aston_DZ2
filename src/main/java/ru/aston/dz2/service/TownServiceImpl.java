package ru.aston.dz2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.dz2.dtos.town.TownCreateDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.dtos.town.TownUpdateDto;
import ru.aston.dz2.mapper.TownMapper;
import ru.aston.dz2.model.Town;
import ru.aston.dz2.repository.TownRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing towns.
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final TownMapper townMapper;

    /**
     * Adds a new town.
     *
     * @param townCreateDto DTO containing the town information.
     * @return The created town as a DTO.
     */
    @Override
    public TownDto addTown(TownCreateDto townCreateDto) {
        log.info("Adding new town with data: {}", townCreateDto);

        Town town = townMapper.toEntity(townCreateDto);
        TownDto savedTown = townMapper.toDto(townRepository.save(town));

        log.info("Town created successfully with ID: {}", savedTown.getId());
        return savedTown;
    }

    /**
     * Retrieves all towns.
     *
     * @return A list of all towns as DTOs.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TownDto> getAllTowns() {
        log.info("Fetching all towns");

        List<TownDto> towns = townRepository.findAll().stream()
                .map(townMapper::toDto)
                .toList();

        log.info("Total towns fetched: {}", towns.size());
        return towns;
    }

    /**
     * Updates an existing town.
     *
     * @param id              The ID of the town to update.
     * @param townUpdateDto   DTO containing the updated town information.
     * @return The updated town as a DTO.
     */
    @Override
    public TownDto updateTown(Long id, TownUpdateDto townUpdateDto) {
        log.info("Updating town with ID: {}", id);

        Town town = townRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Town not found"));

        town.setPopulation(townUpdateDto.getPopulation());
        town.setHasMetro(townUpdateDto.getHasMetro());

        TownDto updatedTown = townMapper.toDto(townRepository.save(town));
        log.info("Town updated successfully with ID: {}", updatedTown.getId());
        return updatedTown;
    }

    /**
     * Deletes a town by its ID.
     *
     * @param id The ID of the town to delete.
     */
    @Override
    public void deleteTown(Long id) {
        log.info("Deleting town with ID: {}", id);
        townRepository.deleteById(id);
        log.info("Town deleted successfully with ID: {}", id);
    }
}
