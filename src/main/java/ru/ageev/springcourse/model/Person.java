package ru.ageev.springcourse.model;

import jakarta.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "can't be empty")
    @Size(min = 3, max = 15, message = "should be between 3 and 15 characters")
    private String name;

    @Min(value = 0, message = "can't be less than 0")
    private int age;

    @NotEmpty(message = "can't be empty")
    @Email(message = "should be valid")
    private String email;

    @Pattern(
            regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",
            message = "Your address should be in this format: Russia, Moscow, 123456"
    )
    private String address;


    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
