package com.example.model;

/**
 * @author David.Shahbazyan
 * @since Mar 09, 2017
 */
public class Car {
    private int id;
    private int brand;
    private String plateNbr;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }
    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getPlateNbr() {
        return plateNbr;
    }
    public void setPlateNbr(String plateNbr) {
        this.plateNbr = plateNbr;
    }
}
