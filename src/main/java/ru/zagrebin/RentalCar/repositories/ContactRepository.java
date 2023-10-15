package ru.zagrebin.RentalCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zagrebin.RentalCar.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
