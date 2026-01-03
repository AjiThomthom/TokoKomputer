package com.ppc.tokokomputer;

import java.io.Serializable;

public class Laptop implements Serializable {
    private String vendor;
    private String model;
    private double rating;
    private int price;
    private int stock;
    private String description;
    private String processor;
    private String ram;
    private String storage;
    private String display;
    private String graphics;
    private String os;
    private String battery;
    private String weight;
    private String year;
    private String port;
    private String connectivity;
    private String imageUrl;

    public Laptop(String vendor, String model, double rating, int price, int stock,
                  String description, String processor, String ram, String storage,
                  String display, String graphics, String os, String battery,
                  String weight, String year, String port, String connectivity) {
        this.vendor = vendor;
        this.model = model;
        this.rating = rating;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.display = display;
        this.graphics = graphics;
        this.os = os;
        this.battery = battery;
        this.weight = weight;
        this.year = year;
        this.port = port;
        this.connectivity = connectivity;
        this.imageUrl = "";
    }

    // Getter dan Setter
    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }

    public String getDisplay() { return display; }
    public void setDisplay(String display) { this.display = display; }

    public String getGraphics() { return graphics; }
    public void setGraphics(String graphics) { this.graphics = graphics; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getBattery() { return battery; }
    public void setBattery(String battery) { this.battery = battery; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getPort() { return port; }
    public void setPort(String port) { this.port = port; }

    public String getConnectivity() { return connectivity; }
    public void setConnectivity(String connectivity) { this.connectivity = connectivity; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}