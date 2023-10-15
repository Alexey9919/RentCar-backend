package ru.zagrebin.RentalCar.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "application_time")
    private Date applicationTime;

    @Column(name = "comment")
    private String comment;

    public Contact() {}

    public Contact(String nameClient, String contactNumber, Date applicationTime, String comment) {
        this.nameClient = nameClient;
        this.contactNumber = contactNumber;
        this.applicationTime = applicationTime;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
