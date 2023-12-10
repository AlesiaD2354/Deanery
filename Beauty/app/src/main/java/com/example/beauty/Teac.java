package com.example.beauty;

public class Teac {

    private String first_name;
    private String last_name;
    private String surname;
    private String discipline;

    public Teac(String first_name, String last_name, String surname, String discipline) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.surname = surname;
        this.discipline = discipline;

    }

    @Override
    public String toString() {
        return "\nИмя: " + first_name
                + "\nФамилия: " + last_name + "\nОтчество: " + surname + "\nДисциплина: " + discipline;
    }
}
