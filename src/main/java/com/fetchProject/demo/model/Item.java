package com.fetchProject.demo.model;

//This class represents an individual item on the receipt
public class Item {
    private String shortDescription;
    private String price;

    public Item(String shortDescription, String price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
