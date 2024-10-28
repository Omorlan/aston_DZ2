package ru.aston.dz2.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.aston.dz2.dtos.town.TownCreateDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.dtos.town.TownUpdateDto;
import ru.aston.dz2.mapper.TownMapper;
import ru.aston.dz2.model.Town;
import ru.aston.dz2.repository.TownRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TownServiceImplTest {

    @InjectMocks
    private TownServiceImpl townService;

    @Mock
    private TownRepository townRepository;

    @Mock
    private TownMapper townMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTown() {
        TownCreateDto createDto = new TownCreateDto();
        Town town = new Town();
        TownDto townDto = new TownDto();

        when(townMapper.toEntity(createDto)).thenReturn(town);
        when(townRepository.save(town)).thenReturn(town);
        when(townMapper.toDto(town)).thenReturn(townDto);

        TownDto result = townService.addTown(createDto);

        assertNotNull(result);
        verify(townMapper).toEntity(createDto);
        verify(townRepository).save(town);
        verify(townMapper).toDto(town);
    }

    @Test
    void testGetAllTowns() {
        Town town = new Town();
        TownDto townDto = new TownDto();
        List<Town> towns = Collections.singletonList(town);
        List<TownDto> townDtos = Collections.singletonList(townDto);

        when(townRepository.findAll()).thenReturn(towns);
        when(townMapper.toDto(town)).thenReturn(townDto);

        List<TownDto> result = townService.getAllTowns();

        assertEquals(1, result.size());
        assertSame(townDto, result.get(0));
        verify(townRepository).findAll();
    }

    @Test
    void testUpdateTown() {
        Long townId = 1L;
        TownUpdateDto updateDto = new TownUpdateDto();
        updateDto.setPopulation(100000);
        updateDto.setHasMetro(true);

        Town town = mock(Town.class);
        TownDto townDto = new TownDto();

        when(townRepository.findById(townId)).thenReturn(Optional.of(town));
        when(townRepository.save(town)).thenReturn(town);
        when(townMapper.toDto(town)).thenReturn(townDto);

        TownDto result = townService.updateTown(townId, updateDto);

        assertNotNull(result);
        assertSame(townDto, result);
        verify(townRepository).findById(townId);
        verify(town).setPopulation(updateDto.getPopulation());
        verify(town).setHasMetro(updateDto.getHasMetro());
        verify(townRepository).save(town);
        verify(townMapper).toDto(town);
    }


    @Test
    void testDeleteTown() {
        Long townId = 1L;

        doNothing().when(townRepository).deleteById(townId);

        townService.deleteTown(townId);

        verify(townRepository).deleteById(townId);
    }
}
