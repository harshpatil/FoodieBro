package com.cs442.hpatil2.foodiebro.model;

/**
 * Created by HarshPatil on 9/25/16.
 */
public class Dish {

    String name;
    String price;
    String description;
    int itemId;
    int imageId;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getItemId() {
        return itemId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Dish(String name, String price, String description, int itemId, int imageId){
        this.name = name;
        this.price = price;
        this.description = description;
        this.itemId = itemId;
        this.imageId = imageId;
    }
}
