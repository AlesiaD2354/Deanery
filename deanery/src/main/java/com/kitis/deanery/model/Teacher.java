package com.kitis.deanery.model;

public class Teacher {
    private String id;
    private String firstName;
    private String lastName;

    private String fatherName;
    private String patronymic;

    public Teacher(String id, String firstName, String lastName, String fatherName, String patronymic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.patronymic = patronymic;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
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
}
