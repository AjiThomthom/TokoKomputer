package com.ppc.tokokomputer;

import android.os.Parcel;
import android.os.Parcelable;

public class Laptop implements Parcelable {
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
                  String weight, String year, String port, String connectivity, String imageUrl) {
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
        this.imageUrl = imageUrl;
    }

    // --- Implementasi Parcelable ---
    protected Laptop(Parcel in) {
        vendor = in.readString();
        model = in.readString();
        rating = in.readDouble();
        price = in.readInt();
        stock = in.readInt();
        description = in.readString();
        processor = in.readString();
        ram = in.readString();
        storage = in.readString();
        display = in.readString();
        graphics = in.readString();
        os = in.readString();
        battery = in.readString();
        weight = in.readString();
        year = in.readString();
        port = in.readString();
        connectivity = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Laptop> CREATOR = new Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel in) {
            return new Laptop(in);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vendor);
        dest.writeString(model);
        dest.writeDouble(rating);
        dest.writeInt(price);
        dest.writeInt(stock);
        dest.writeString(description);
        dest.writeString(processor);
        dest.writeString(ram);
        dest.writeString(storage);
        dest.writeString(display);
        dest.writeString(graphics);
        dest.writeString(os);
        dest.writeString(battery);
        dest.writeString(weight);
        dest.writeString(year);
        dest.writeString(port);
        dest.writeString(connectivity);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() { return 0; }

    // --- Getters ---
    public String getVendor() { return vendor; }
    public String getModel() { return model; }
    public double getRating() { return rating; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public String getDescription() { return description; }
    public String getProcessor() { return processor; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getDisplay() { return display; }
    public String getGraphics() { return graphics; }
    public String getOs() { return os; }
    public String getBattery() { return battery; }
    public String getWeight() { return weight; }
    public String getYear() { return year; }
    public String getPort() { return port; }
    public String getConnectivity() { return connectivity; }
    public String getImageUrl() { return imageUrl; }
}