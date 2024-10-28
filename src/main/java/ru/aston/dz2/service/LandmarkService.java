package ru.aston.dz2.service;

import ru.aston.dz2.dtos.landmark.LandmarkCreateDto;
import ru.aston.dz2.dtos.landmark.LandmarkDto;
import ru.aston.dz2.dtos.landmark.LandmarkUpdateDto;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.util.List;

public interface LandmarkService {
    LandmarkDto addLandmark(LandmarkCreateDto landmarkCreateDto);
    List<LandmarkDto> getAllLandmarks(String sortBy, LandmarkType type);
    List<LandmarkDto> getLandmarksByTown(Long townId);
    LandmarkDto updateLandmark(Long id, LandmarkUpdateDto landmarkUpdateDto);
    void deleteLandmark(Long id);
}
