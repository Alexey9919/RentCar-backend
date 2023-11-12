package ru.zagrebin.RentalCar.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.util.Date;

public class CarsDTO {

    private int id;
    @NotEmpty(message = "Название авто не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название авто должно быть от 2 до 100 символов длиной")
    private String model;

    @NotEmpty(message = "Цвет не должен быть пустым")
    @Size(min = 2, max = 100, message = "Цвет должен быть от 2 до 100 символов длиной")
    private String color;

    @Min(value = 1980, message = "Год должен быть больше, чем 1980")
    private int year;


    @NotEmpty
    private String stateNumber;

    private int rentalPeriod;

    private int imageId;

    private int body;

    private int personId;

    private int price;

    private int idOwner;

    @Temporal(TemporalType.DATE)
    private Date takenAt;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public int getImageId() {return imageId;}

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getBody() {return body;}

    public void setBody(int body) {this.body = body;}


    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
}
