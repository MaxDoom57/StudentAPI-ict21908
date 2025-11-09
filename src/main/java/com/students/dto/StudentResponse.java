package com.students.dto;

public class StudentResponse {

    private Integer id;
    private String name;
    private String email;
    private String course;
    private Integer age;

    public StudentResponse(Integer id, String name, String email, String course, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Integer getAge() { return age; }
}
