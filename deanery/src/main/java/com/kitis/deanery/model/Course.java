package com.kitis.deanery.model;

public class Course {
    private String id;
    private String subjectName;
    private String session;
    private String exams;
    private String practice;
    private String internship;
    private String diploma;
    private String groupName;

    public Course(String id, String subjectName, String session, String exams, String practice, String internship, String diploma, String groupName) {
        this.id = id;
        this.subjectName = subjectName;
        this.session = session;
        this.exams = exams;
        this.practice = practice;
        this.internship = internship;
        this.diploma = diploma;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getExams() {
        return exams;
    }

    public void setExams(String exams) {
        this.exams = exams;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
}
