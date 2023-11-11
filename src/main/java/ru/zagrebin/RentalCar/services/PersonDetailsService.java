package ru.zagrebin.RentalCar.services;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ru.zagrebin.RentalCar.models.Person;
//import ru.zagrebin.RentalCar.repositories.PeopleRepository;
//import ru.zagrebin.RentalCar.security.PersonDetails;
//
//import java.util.Optional;
//
//@Service
//public class PersonDetailsService {
//    private final PeopleRepository peopleRepository;
//
//    @Autowired
//    public PersonDetailsService(PeopleRepository peopleRepository) {
//        this.peopleRepository = peopleRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Optional<Person> person = peopleRepository.findByUsername(s);
//
//        if (person.isEmpty())
//            throw new UsernameNotFoundException("User not found");
//
//        return new PersonDetails(person.get());
//    }
//}
