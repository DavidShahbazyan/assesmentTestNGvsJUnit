package com.example.model;

import java.time.LocalDate;

/**
 * @author David.Shahbazyan
 * @since Mar 09, 2017
 */
public class Person {
    private int id;
    private String fName;
    private String lName;
    private int age;
    private LocalDate bDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getbDate() {
        return bDate;
    }
    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }
}
