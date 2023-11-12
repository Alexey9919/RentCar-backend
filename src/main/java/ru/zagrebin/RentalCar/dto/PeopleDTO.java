package ru.zagrebin.RentalCar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PeopleDTO {

    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int yearOfBirth;

    @NotEmpty(message = "Данные пасспорта должны быть заполнены")
    private String passport;

    private int contractNumber;

    @NotEmpty(message = "мобильный телефон не должен быть пустым")
    private String mobilePhone;

    PeopleDTO(){}

    public PeopleDTO(String fullName, int yearOfBirth, String passport, int contractNumber, String mobilePhone) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.passport = passport;
        this.contractNumber = contractNumber;
        this.mobilePhone = mobilePhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
