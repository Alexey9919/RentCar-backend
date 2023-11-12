package ru.zagrebin.RentalCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.models.Person;
import ru.zagrebin.RentalCar.repositories.CarsRepository;

import java.io.IOException;
import java.util.Date;
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
        updateCar.setTakenAt(new Date());
        updateCar.setOwner(carToBeUpdated.getOwner());



        carsRepository.save(updateCar);
    }

    @Transactional
    public void delete(int id) {
        carsRepository.delete(findOne(id));
    }

    public List<Car> searchByTitle(String query) {
        return carsRepository.findByModelStartingWith(query);
    }


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

    public Car getCarById(int id) {
        return carsRepository.findById(id).orElse(null);
    }
}
