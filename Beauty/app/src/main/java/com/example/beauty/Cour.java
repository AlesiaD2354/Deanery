package com.example.beauty;


import java.time.LocalDate;

public class Cour {

    private String subjectName;
    private SessionDateRange session;
    private LocalDate exams;
    private PracticeDateRange practice;
    private InternshipDateRange internship;
    private LocalDate diploma;
    private String groupName;

    public Cour(String subjectName, SessionDateRange session, LocalDate exams, PracticeDateRange practice, InternshipDateRange internship, LocalDate diploma, String groupName) {
        this.subjectName = subjectName;
        this.session = session;
        this.exams = exams;
        this.practice = practice;
        this.internship = internship;
        this.diploma = diploma;
        this.groupName = groupName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public SessionDateRange getSession() {
        return session;
    }

    public LocalDate getExams() {
        return exams;
    }

    public PracticeDateRange getPractice() {
        return practice;
    }

    public InternshipDateRange getInternship() {
        return internship;
    }

    public LocalDate getDiploma() {
        return diploma;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Дисциплина: " + subjectName +
                "\nСессия: " + session +
                "\nЭкзамены: " + exams +
                "\nУчебная практика: " + practice +
                "\nПроизводственная практика: " + internship +
                "\nДиплом: " + diploma +
                "\nГруппа: " + groupName +
                "\n";
    }
}
