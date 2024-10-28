package ru.aston.dz2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.landmark.LandmarkUpdateDto;
import ru.aston.dz2.mapper.LandmarkMapper;
import ru.aston.dz2.model.Town;
import ru.aston.dz2.model.landmark.Landmark;
import ru.aston.dz2.repository.LandmarkRepository;
import ru.aston.dz2.repository.TownRepository;
import ru.aston.dz2.repository.TravelServiceRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LandmarkServiceImplTest {

    @Mock
    private LandmarkRepository landmarkRepository;

    @Mock
    private TownRepository townRepository;

    @Mock
    private TravelServiceRepository travelServiceRepository;

    @Mock
    private LandmarkMapper landmarkMapper;

    @InjectMocks
    private LandmarkServiceImpl landmarkService;

    private Town town;
    private Landmark landmark;
    private LandmarkDto landmarkDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        town = new Town();
        town.setId(1L);
        town.setPopulation(500000);

        landmark = new Landmark();
        landmark.setId(1L);
        landmark.setDescription("desc");

        landmarkDto = new LandmarkDto();
        landmarkDto.setId(landmark.getId());
        landmarkDto.setDescription(landmark.getDescription());
    }

    @Test
    void testAddLandmark() {
        LandmarkCreateDto createDto = new LandmarkCreateDto();
        createDto.setDescription("desc2");
        createDto.setTownId(town.getId());
        createDto.setServiceIds(Collections.emptyList());

        when(townRepository.findById(createDto.getTownId())).thenReturn(Optional.of(town));
        when(landmarkMapper.toEntity(createDto)).thenReturn(landmark);
        when(landmarkRepository.save(landmark)).thenReturn(landmark);
        when(landmarkMapper.toDto(landmark)).thenReturn(landmarkDto);

        LandmarkDto result = landmarkService.addLandmark(createDto);

        assertNotNull(result);
        assertEquals(landmarkDto.getId(), result.getId());
        verify(townRepository).findById(createDto.getTownId());
        verify(landmarkMapper).toEntity(createDto);
        verify(landmarkRepository).save(landmark);
        verify(landmarkMapper).toDto(landmark);
    }

    @Test
    void testGetAllLandmarks() {
        List<Landmark> landmarks = List.of(landmark);
        when(landmarkRepository.findAll()).thenReturn(landmarks);
        when(landmarkMapper.toDto(landmark)).thenReturn(landmarkDto);

        List<LandmarkDto> result = landmarkService.getAllLandmarks(null, null);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(landmarkRepository).findAll();
        verify(landmarkMapper).toDto(landmark);
    }

    @Test
    void testGetLandmarksByTown() {
        List<Landmark> landmarks = List.of(landmark);
        when(landmarkRepository.findByTownId(town.getId())).thenReturn(landmarks);
        when(landmarkMapper.toDto(landmark)).thenReturn(landmarkDto);

        List<LandmarkDto> result = landmarkService.getLandmarksByTown(town.getId());

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(landmarkRepository).findByTownId(town.getId());
        verify(landmarkMapper).toDto(landmark);
    }


    @Test
    void testUpdateLandmark() {
        Landmark landmark = mock(Landmark.class);
        when(landmark.getId()).thenReturn(1L);
        when(landmark.getDescription()).thenReturn("descold");

        LandmarkUpdateDto updateDto = new LandmarkUpdateDto();
        updateDto.setDescription("descnew");

        when(landmarkRepository.findById(anyLong())).thenReturn(Optional.of(landmark));
        when(landmarkRepository.save(any(Landmark.class))).thenReturn(landmark);

        LandmarkDto landmarkDto = new LandmarkDto();
        landmarkDto.setId(landmark.getId());
        landmarkDto.setDescription("descnew");

        when(landmarkMapper.toDto(any(Landmark.class))).thenReturn(landmarkDto);

        LandmarkDto result = landmarkService.updateLandmark(1L, updateDto);

        assertNotNull(result);
        assertEquals("descnew", result.getDescription());

        verify(landmarkRepository).findById(1L);

        verify(landmark).setDescription("descnew");

        verify(landmarkRepository).save(landmark);

        verify(landmarkMapper).toDto(landmark);
    }


    @Test
    void testDeleteLandmark() {
        Long landmarkId = landmark.getId();
        landmarkService.deleteLandmark(landmarkId);
        verify(landmarkRepository).deleteById(landmarkId);
    }
}
