package ru.zagrebin.RentalCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Contact;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.repositories.ContactRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;



@Service
public class ContactsService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactsService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContact(Contact contact) {

        contact.setApplicationTime(new Date());
        contactRepository.save(contact);
    }
}
