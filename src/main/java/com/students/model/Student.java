package com.students.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudetKey")
    private Integer studetKey;

    @Column(name = "Id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "Email", length = 50)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "Course", nullable = false, length = 30)
    @NotBlank(message = "Course is mandatory")
    private String course;

    @Column(name = "Age", nullable = false)
    @Min(value = 18, message = "Age should be at least 18")
    private Integer age;


    public Integer getStudetKey() {
        return studetKey;
    }

    public void setStudetKey(Integer studetKey) {
        this.studetKey = studetKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
