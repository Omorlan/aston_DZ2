package ru.aston.dz2.service;

import ru.aston.dz2.dtos.town.TownCreateDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.dtos.town.TownUpdateDto;

import java.util.List;

public interface TownService {
    TownDto addTown(TownCreateDto townCreateDto);
    List<TownDto> getAllTowns();
    TownDto updateTown(Long id, TownUpdateDto townUpdateDto);
    void deleteTown(Long id);
}
