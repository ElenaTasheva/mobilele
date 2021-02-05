package com.example.mobilele.models.bindings;

import com.example.mobilele.models.entities.Brand;
import com.example.mobilele.models.entities.Model;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class OfferServiceModel {


    @Expose
    private Brand brand;
    @Expose
    private Model model;
    @Expose
    private String engine;
    @Expose
    private String imageUrl;
    @Expose
    private int mileage;
    @Expose
    private BigDecimal price;
    @Expose
    private int year;
    @Expose
    private String transmission;

    public OfferServiceModel() {
    }

    public String getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferServiceModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public OfferServiceModel setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public OfferServiceModel setModel(Model model) {
        this.model = model;
        return this;
    }
}
