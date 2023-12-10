package com.example.beauty;
public class Stud extends Students {

    private String first_name;
    private String last_name;
    private String surname;
    private int birth_year;
    private String group_name;

    public Stud(String first_name, String last_name, String surname, int birth_year, String group_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.surname = surname;
        this.birth_year = birth_year;
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "Фамилия: " + first_name + "\nИмя: " + last_name + "\nОтчество: " + surname +
                "\nГод рождения: " + birth_year + "\nГруппа: " + group_name + "\n";
    }
}
