package ru.zagrebin.RentalCar.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zagrebin.RentalCar.dto.ContactsDTO;
import ru.zagrebin.RentalCar.dto.PeopleDTO;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Contact;
import ru.zagrebin.RentalCar.models.Person;
import ru.zagrebin.RentalCar.repositories.ContactRepository;
import ru.zagrebin.RentalCar.services.ContactsService;
import ru.zagrebin.RentalCar.services.PeopleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    private final ModelMapper modelMapper;

    @Autowired
    public ContactsController(ContactsService contactsService, ModelMapper modelMapper) {
        this.contactsService = contactsService;
        this.modelMapper = modelMapper;
    }


    @GetMapping()
    public List<ContactsDTO> getCars() {
        return contactsService.findAll().stream().map(this::convertToContactsDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContactsDTO getCar(@PathVariable("id") int id) {
        return convertToContactsDTO(contactsService.findOne(id));
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> create(@RequestBody Contact contact) {

        contactsService.saveContact(contact);
        //отправляем HTTP ответ с пустым телом и со статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Contact convertToContact(ContactsDTO contactsDTO) {
        return modelMapper.map(contactsDTO, Contact.class);
    }

    private ContactsDTO convertToContactsDTO(Contact contact) {
        return modelMapper.map(contact, ContactsDTO.class);
    }
}
