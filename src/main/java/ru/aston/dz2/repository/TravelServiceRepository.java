package ru.aston.dz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.dz2.model.TravelService;

@Repository
public interface TravelServiceRepository extends JpaRepository<TravelService, Long> {
}
