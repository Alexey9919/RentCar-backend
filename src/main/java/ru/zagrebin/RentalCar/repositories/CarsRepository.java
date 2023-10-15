package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zagrebin.RentalCar.models.Car;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Integer> {

    List<Car> findByModel(String model);
}
