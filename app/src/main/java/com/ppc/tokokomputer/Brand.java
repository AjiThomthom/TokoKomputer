package com.ppc.tokokomputer;

public class Brand {
    private String name;
    private int logoResId;
    private int backgroundColor;

    public Brand(String name, int logoResId, int backgroundColor) {
        this.name = name;
        this.logoResId = logoResId;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }

    public int getLogoResId() {
        return logoResId;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}