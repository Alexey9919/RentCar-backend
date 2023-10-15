package ru.zagrebin.RentalCar.dto;

import jakarta.persistence.*;
import ru.zagrebin.RentalCar.models.Car;
import ru.zagrebin.RentalCar.models.Person;

public class ImagesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String originalFileName;

    private Long size;

    private String contentType;

    private byte[] bytes;

    private Car car;

    public ImagesDTO(){}

    public ImagesDTO(String originalFileName, Long size, String contentType, byte[] bytes, Person owner) {
        this.originalFileName = originalFileName;
        this.size = size;
        this.contentType = contentType;
        this.bytes = bytes;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}