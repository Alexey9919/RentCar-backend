package ru.zagrebin.RentalCar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Название авто не должно быть пустым")
    @Size(min = 2, max = 100, message = "Название авто должно быть от 2 до 100 символов длиной")
    @Column(name = "model")
    private String model;
    @NotEmpty(message = "Цвет не должен быть пустым")
    @Size(min = 2, max = 100, message = "Цвет должен быть от 2 до 100 символов длиной")
    @Column(name = "color")
    private String color;
    @Min(value = 1980, message = "Год должен быть больше, чем 1980")
    @Column(name = "year")
    private int year;

    @NotEmpty
    @Column(name = "state_number")
    private String stateNumber;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Column(name = "rental_period")
    private int rentalPeriod;

    @Transient
    private boolean expired;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "car")
    private List<Image> images = new ArrayList<>();

    @Column(name = "image_id")
    private int imageId;

    @Column(name = "body")
    private int body;

    public Car() {

    }

    public Car(String model, String color, int year, String stateNumber, Person owner, Date takenAt, int rentalPeriod, boolean expired, List<Image> images, int imageId, int body) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.stateNumber = stateNumber;
        this.owner = owner;
        this.takenAt = takenAt;
        this.rentalPeriod = rentalPeriod;
        this.expired = expired;
        this.images = images;
        this.imageId = imageId;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Person getOwner() {return owner;}

    public void setOwner(Person owner) {this.owner = owner;}

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public int getImageId() {return imageId;}
    public void setImageId(int imageId) {this.imageId = imageId;}
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getBody() {return body;}

    public void setBody(int body) {this.body = body;}

    //    @PrePersist
//    private void init() {
//        dateOfCreated = LocalDateTime.now();
//    }


    public void addImageToCar(Image image) {
        image.setCar(this);
        images.add(image);
    }

}
