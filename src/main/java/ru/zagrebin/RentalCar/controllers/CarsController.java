package ru.zagrebin.RentalCar.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.dto.CarsDTO;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.models.Person;
import ru.zagrebin.RentalCar.repositories.CarsRepository;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;
import ru.zagrebin.RentalCar.services.CarsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    private final ImagesRepository imagesRepository;

    private final ModelMapper modelMapper;

    private final CarsRepository carsRepository;

    @Autowired
    public CarsController(CarsService carsService, ImagesRepository imagesRepository, ModelMapper modelMapper, CarsRepository carsRepository) {
        this.carsService = carsService;
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
        this.carsRepository = carsRepository;
    }


    @GetMapping()
    public List<CarsDTO> getCars() {
        return carsService.findAll().stream().map(this::convertToCarsDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CarsDTO getCar(@PathVariable("id") int id) {
        return convertToCarsDTO(carsService.findOne(id));
    }


    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestParam("file") MultipartFile file1, Car car) throws IOException {
        carsService.saveCar(car, file1);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{query}")
    public List<CarsDTO> makeSearch(@PathVariable("query") String query) {
        return carsService.searchByTitle(query).stream().map(this::convertToCarsDTO)
                .collect(Collectors.toList());
    }


    @CrossOrigin
    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") int id, @RequestBody Car car) throws IOException {
        System.out.println(id);
        System.out.println(car);
        carsService.update(id, car);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        carsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    private Car convertToCar(CarsDTO carsDTO) {
        return modelMapper.map(carsDTO, Car.class);
    }

    private CarsDTO convertToCarsDTO(Car car) {
        CarsDTO dto = modelMapper.map(car, CarsDTO.class);
        Image image = imagesRepository.findByCar(car);
        dto.setImageId(image.getId());
        Optional<Person> carOwner = carsService.getCarOwner(car.getId());
        if(carOwner.isPresent())
        dto.setPersonId(carOwner.get().getId());
        else
            dto.setPersonId(0);
        return dto;
    }
}
