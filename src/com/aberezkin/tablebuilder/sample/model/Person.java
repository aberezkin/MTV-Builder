package com.aberezkin.tablebuilder.sample.model;

import com.aberezkin.tablebuilder.builder.IgnoreTable;

public class Person {
    @IgnoreTable
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Person(String firstName, String lastName, String email, int age) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
