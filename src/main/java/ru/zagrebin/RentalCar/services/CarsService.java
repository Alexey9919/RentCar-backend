package ru.zagrebin.RentalCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.models.Person;
import ru.zagrebin.RentalCar.repositories.CarsRepository;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CarsService {

    private final CarsRepository carsRepository;


    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }


    public List<Car> findAll() {
        return carsRepository.findAll();
    }


    public Car findOne(int id) {
        Optional<Car> foundCar = carsRepository.findById(id);
        return foundCar.orElse(null);
    }

    @Transactional
    public void saveCar(Car car, MultipartFile file) throws IOException {
        Image image = null;
        Car carNew = car;

        if (file.getSize() != 0) {
            image = toImageEntity(file);
            carNew.addImageToCar(image);
        }
        carsRepository.save(carNew);
    }

    @Transactional
    public void update(int id, Car updateCar) throws IOException {
        Car carToBeUpdated = carsRepository.findById(id).get();

        updateCar.setId(id);
        updateCar.setOwner(carToBeUpdated.getOwner());



        carsRepository.save(updateCar);
    }

//    @Transactional
//    public void update(int id, Car updateCar, MultipartFile file) throws IOException {
//        Image image = null;
//        Car carToBeUpdated = carsRepository.findById(id).get();
//        carsRepository.delete(findOne(id));
//        updateCar.setId(id);
//        updateCar.setOwner(carToBeUpdated.getOwner());
//
//        if (file.getSize() != 0) {
//            image = toImageEntity(file);
//            updateCar.addImageToCar(image);
//        }
//
//        carsRepository.save(updateCar);
//    }

    @Transactional
    public void delete(int id) {
        carsRepository.delete(findOne(id));
    }

    public List<Car> searchByTitle(String query) {
        return carsRepository.findByModelStartingWith(query);
    }


//    public List<Car> listCars(String model) {
//        if (model != null) return carsRepository.findByModel(model);
//        return carsRepository.findAll();
//    }
//


//    public void saveCar(Car car) throws IOException {
//
//        Car carNew = car;
//
//        carsRepository.save(carNew);
//    }

    public Optional<Person> getCarOwner(int id) {
        // Тут Hibernate.initialize() не нужен, так как владелец (сторона One) загружается не лениво
        return carsRepository.findById(id).map(Car::getOwner);
    }


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
