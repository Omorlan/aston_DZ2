package ru.aston.dz2.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.landmark.LandmarkUpdateDto;
import ru.aston.dz2.model.landmark.LandmarkType;
import ru.aston.dz2.service.LandmarkService;

import java.util.List;

@RestController
@RequestMapping("/landmarks")
@RequiredArgsConstructor
public class LandmarkController {

    private final LandmarkService landmarkService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LandmarkDto addLandmark(@RequestBody LandmarkCreateDto landmarkCreateDto) {
        return landmarkService.addLandmark(landmarkCreateDto);
    }

    @GetMapping
    public List<LandmarkDto> getAllLandmarks(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) LandmarkType type) {
        return landmarkService.getAllLandmarks(sortBy, type);
    }

    @GetMapping("/town/{townId}")
    public List<LandmarkDto> getLandmarksByTown(@PathVariable Long townId) {
        return landmarkService.getLandmarksByTown(townId);
    }

    @PutMapping("/{id}")
    public LandmarkDto updateLandmark(@PathVariable Long id, @RequestBody LandmarkUpdateDto landmarkUpdateDto) {
        return landmarkService.updateLandmark(id, landmarkUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
    }
}
