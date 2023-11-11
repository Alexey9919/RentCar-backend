package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zagrebin.RentalCar.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
