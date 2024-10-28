package ru.aston.dz2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.aston.dz2.dtos.service.TravelServiceCreateDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;
import ru.aston.dz2.mapper.TravelServiceMapper;
import ru.aston.dz2.model.TravelService;
import ru.aston.dz2.repository.TravelServiceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TravelServiceServiceImplTest {

    @Mock
    private TravelServiceRepository travelServiceRepository;

    @Mock
    private TravelServiceMapper travelServiceMapper;

    @InjectMocks
    private TravelServiceServiceImpl travelServiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddService() {
        TravelServiceCreateDto createDto = new TravelServiceCreateDto();
        TravelService service = new TravelService();
        TravelServiceDto serviceDto = new TravelServiceDto();

        when(travelServiceMapper.toEntity(createDto)).thenReturn(service);
        when(travelServiceRepository.save(service)).thenReturn(service);
        when(travelServiceMapper.toDto(service)).thenReturn(serviceDto);

        TravelServiceDto result = travelServiceService.addService(createDto);

        assertNotNull(result);
        verify(travelServiceMapper).toEntity(createDto);
        verify(travelServiceRepository).save(service);
        verify(travelServiceMapper).toDto(service);
    }

    @Test
    void testGetAllServices() {
        TravelService service1 = new TravelService();
        TravelService service2 = new TravelService();
        TravelServiceDto serviceDto1 = new TravelServiceDto();
        TravelServiceDto serviceDto2 = new TravelServiceDto();

        when(travelServiceRepository.findAll()).thenReturn(Arrays.asList(service1, service2));
        when(travelServiceMapper.toDto(service1)).thenReturn(serviceDto1);
        when(travelServiceMapper.toDto(service2)).thenReturn(serviceDto2);

        List<TravelServiceDto> result = travelServiceService.getAllServices();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(travelServiceRepository).findAll();
    }

    @Test
    void testUpdateService() {
        Long serviceId = 1L;
        TravelServiceUpdateDto updateDto = new TravelServiceUpdateDto();
        updateDto.setDescription("descnew");

        TravelService service = mock(TravelService.class);
        TravelServiceDto serviceDto = new TravelServiceDto();

        when(travelServiceRepository.findById(serviceId)).thenReturn(Optional.of(service));
        when(travelServiceRepository.save(service)).thenReturn(service);
        when(travelServiceMapper.toDto(service)).thenReturn(serviceDto);

        TravelServiceDto result = travelServiceService.updateService(serviceId, updateDto);

        assertNotNull(result);
        verify(travelServiceRepository).findById(serviceId);
        verify(service).setDescription(updateDto.getDescription());
        verify(travelServiceRepository).save(service);
        verify(travelServiceMapper).toDto(service);
    }


    @Test
    void testDeleteService() {
        Long serviceId = 1L;

        travelServiceService.deleteService(serviceId);

        verify(travelServiceRepository).deleteById(serviceId);
    }
}
