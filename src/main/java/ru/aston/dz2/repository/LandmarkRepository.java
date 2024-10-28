package ru.aston.dz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.dz2.model.landmark.Landmark;
import ru.aston.dz2.model.landmark.LandmarkType;

import java.util.List;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    List<Landmark> findByType(LandmarkType type);
    List<Landmark> findByTownId(Long townId);
}
