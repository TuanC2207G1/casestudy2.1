package model;

import java.io.Serializable;

public class FoodAndDrink implements Serializable {
    private int id;
    private String name;
    private double price;

    public FoodAndDrink() {
    }

    public FoodAndDrink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "FoodAndDrink{id=" + this.id + ", name='" + this.name + '\'' + ", price=" + this.price + '}';
    }
}
