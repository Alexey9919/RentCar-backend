package ru.zagrebin.RentalCar.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.dto.CarsDTO;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;
import ru.zagrebin.RentalCar.services.CarsService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    private final ImagesRepository imagesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CarsController(CarsService carsService, ImagesRepository imagesRepository, ModelMapper modelMapper) {
        this.carsService = carsService;
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping()
    public List<CarsDTO> getCars() {
        return carsService.findAll().stream().map(this::convertToCarsDTO)
                .collect(Collectors.toList());
    }




//    @GetMapping()
//    public String cars(@RequestParam(name = "model", required = false) String model, Model models) {
//        models.addAttribute("cars", carsService.listCars(model));
//        return "products";
//    }
//
//
//    @GetMapping("/{id}")
//    public String carInfo(@PathVariable int id, Model model) {
//        Car car = carsService.getCarById(id);
//        model.addAttribute("car", car);
//        model.addAttribute("images", car.getImages());
//        return "product-info";
//    }

//    @GetMapping("/{id}")
//    public CarsDTO getCar(@PathVariable("id") int id) {
//        return convertToCarsDTO(carsService.findOne(id));
//    }

//    @PostMapping("/create")
//    public String createCar(@RequestParam("file") MultipartFile file, Car car) throws IOException {
//        carsService.saveCar(car, file);
//        return "redirect:/cars";
//    }

//    @PostMapping("/product/delete/{id}")
//    public String deleteProduct(@PathVariable int id) {
//        carsService.deleteProduct(id);
//        return "redirect:/";
//    }


    private Car convertToCar(CarsDTO carsDTO) {
        return modelMapper.map(carsDTO, Car.class);
    }

    private CarsDTO convertToCarsDTO(Car car) {
        CarsDTO dto = modelMapper.map(car, CarsDTO.class);
        Image image = imagesRepository.findByCar(car);
        dto.setImageId(image.getId());
        return dto;
    }
}
