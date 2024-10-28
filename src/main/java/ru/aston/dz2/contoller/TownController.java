package ru.aston.dz2.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aston.dz2.dtos.town.TownCreateDto;
import ru.aston.dz2.dtos.town.TownDto;
import ru.aston.dz2.dtos.town.TownUpdateDto;
import ru.aston.dz2.service.TownService;

import java.util.List;

@RestController
@RequestMapping("/towns")
@RequiredArgsConstructor
public class TownController {

    private final TownService townService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TownDto addTown(@RequestBody TownCreateDto townCreateDto) {
        return townService.addTown(townCreateDto);
    }

    @GetMapping
    public List<TownDto> getAllTowns() {
        return townService.getAllTowns();
    }

    @PutMapping("/{id}")
    public TownDto updateTown(@PathVariable Long id, @RequestBody TownUpdateDto townUpdateDto) {
        return townService.updateTown(id, townUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTown(@PathVariable Long id) {
        townService.deleteTown(id);
    }
}
