package ru.zagrebin.RentalCar.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zagrebin.RentalCar.dto.PeopleDTO;
import ru.zagrebin.RentalCar.models.Person;
import ru.zagrebin.RentalCar.repositories.PeopleRepository;
import ru.zagrebin.RentalCar.services.PeopleService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class PeopleController {

    private final PeopleService peopleService;

    private final ModelMapper modelMapper;

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleService peopleService, ModelMapper modelMapper, PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping()
    public List<PeopleDTO> getCars() {
        return peopleService.findAll().stream().map(this::convertToPeopleDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PeopleDTO getCar(@PathVariable("id") int id) {
        return convertToPeopleDTO(peopleService.findOne(id));
    }


    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(Person person) throws IOException {
        peopleService.saveCar(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{query}")
    public List<PeopleDTO> makeSearch(@PathVariable("query") String query) {
        return peopleService.searchByTitle(query).stream().map(this::convertToPeopleDTO)
                .collect(Collectors.toList());
    }


    @CrossOrigin
    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") int id, @RequestBody Person person) throws IOException {
        peopleService.update(id, person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    private Person convertToPerson(PeopleDTO peopleDTO) {
        return modelMapper.map(peopleDTO, Person.class);
    }

    private PeopleDTO convertToPeopleDTO(Person person) {
        return modelMapper.map(person, PeopleDTO.class);
    }
}
