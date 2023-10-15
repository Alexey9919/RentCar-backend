package ru.zagrebin.RentalCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ImagesService {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public List<Image> getImages() {
        return imagesRepository.findAll();
    }
}
