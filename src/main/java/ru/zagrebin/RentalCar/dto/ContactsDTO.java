package ru.zagrebin.RentalCar.dto;


import java.util.Date;

public class ContactsDTO {

    private String nameClient;

    private String contactNumber;

    private Date applicationTime;

    private String comment;

    public ContactsDTO(){}

    public ContactsDTO(String nameClient, String contactNumber, Date applicationTime, String comment) {
        this.nameClient = nameClient;
        this.contactNumber = contactNumber;
        this.applicationTime = applicationTime;
        this.comment = comment;
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
