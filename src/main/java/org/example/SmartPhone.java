package org.example;

public class SmartPhone extends Product {

    private String manufacturer;

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManuFacturer() {
        return manufacturer;
    }

}
