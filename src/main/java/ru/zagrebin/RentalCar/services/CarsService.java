package ru.zagrebin.RentalCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.repositories.CarsRepository;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;

import java.io.IOException;
import java.util.List;

@Service
public class CarsService {

    private final CarsRepository carsRepository;


    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    public List<Car> findAll() {
        return carsRepository.findAll();
    }


//    public List<Car> listCars(String model) {
//        if (model != null) return carsRepository.findByModel(model);
//        return carsRepository.findAll();
//    }
//
//    public void saveCar(Car car, MultipartFile file) throws IOException {
//        Image image = null;
//        Car carNew = car;
//
//        if (file.getSize() != 0) {
//            image = toImageEntity(file);
//            carNew.addImageToCar(image);
//        }
//        carsRepository.save(carNew);
//    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

//    public void deleteProduct(int id) {
//        carsRepository.deleteById(id);
//    }

    public Car getCarById(int id) {
        return carsRepository.findById(id).orElse(null);
    }
}
