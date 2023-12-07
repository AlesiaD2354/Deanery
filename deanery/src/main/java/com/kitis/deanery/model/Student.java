package com.kitis.deanery.model;

public class Student {
    private String id;
    private String firstName;
    private String lastName;

    private String surname;

    private String patronymic;
    private String birthYear;

    public Student(String id, String firstName, String lastName, String surname, String patronymic, String birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
