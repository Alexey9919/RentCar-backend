package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zagrebin.RentalCar.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFullNameStartingWith(String fullName);
//    Optional<Person> findByUsername(String username);
}
