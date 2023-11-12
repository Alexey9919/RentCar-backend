package ru.zagrebin.RentalCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.zagrebin.RentalCar.models.Image;
import ru.zagrebin.RentalCar.repositories.ImagesRepository;

import java.io.ByteArrayInputStream;

@RestController
@CrossOrigin
public class ImagesController {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesController(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable int id) {
        Image image = imagesRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
