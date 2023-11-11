package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {

    List<Car> findByModel(String model);

    List<Car> findByModelStartingWith(String model);
}
