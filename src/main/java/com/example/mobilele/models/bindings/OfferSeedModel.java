package com.example.mobilele.models.bindings;

import com.example.mobilele.models.entities.Brand;
import com.example.mobilele.models.entities.Model;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class OfferSeedModel {


    private long id;
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

    public long getId() {
        return id;
    }

    public OfferSeedModel setId(long id) {
        this.id = id;
        return this;
    }

    public OfferSeedModel() {
    }

    public String getEngine() {
        return engine;
    }

    public OfferSeedModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSeedModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSeedModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSeedModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSeedModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferSeedModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public OfferSeedModel setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public OfferSeedModel setModel(Model model) {
        this.model = model;
        return this;
    }
}
