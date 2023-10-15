package ru.zagrebin.RentalCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zagrebin.RentalCar.models.Contact;
import ru.zagrebin.RentalCar.repositories.ContactRepository;
import ru.zagrebin.RentalCar.services.ContactsService;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> create(@RequestBody Contact contact) {

        contactsService.saveContact(contact);
        //отправляем HTTP ответ с пустым телом и со статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
