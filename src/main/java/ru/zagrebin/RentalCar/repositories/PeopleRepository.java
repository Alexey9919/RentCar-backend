package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zagrebin.RentalCar.models.Person;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
