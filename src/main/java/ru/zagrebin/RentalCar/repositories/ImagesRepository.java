package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Image;

public interface ImagesRepository extends JpaRepository<Image, Integer> {
    Image findByCar(Car car);
}
