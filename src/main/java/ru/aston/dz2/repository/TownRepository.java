package ru.aston.dz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.dz2.model.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
}
