package ru.aston.dz2.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aston.dz2.dtos.service.TravelServiceCreateDto;
import ru.aston.dz2.dtos.service.TravelServiceDto;
import ru.aston.dz2.dtos.service.TravelServiceUpdateDto;
import ru.aston.dz2.service.TravelServiceService;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class TravelServiceController {

    private final TravelServiceService travelServiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelServiceDto addService(@RequestBody TravelServiceCreateDto travelServiceCreateDto) {
        return travelServiceService.addService(travelServiceCreateDto);
    }

    @GetMapping
    public List<TravelServiceDto> getAllServices() {
        return travelServiceService.getAllServices();
    }

    @PutMapping("/{id}")
    public TravelServiceDto updateService(@PathVariable Long id, @RequestBody TravelServiceUpdateDto serviceUpdateDto) {
        return travelServiceService.updateService(id, serviceUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteService(@PathVariable Long id) {
        travelServiceService.deleteService(id);
    }
}
