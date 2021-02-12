package com.example.mobilele.models.bindings;

import com.example.mobilele.models.entities.enums.Engine;
import com.example.mobilele.models.entities.enums.Transmission;
import com.example.mobilele.validation.YearInPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {


    @NotNull
    private Engine engine;
    @NotEmpty
    private String imageUrl;
    @NotNull
    @PositiveOrZero
    private Integer mileage;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @YearInPastOrPresent(minYear = 1930)
    private Integer year;
    @NotEmpty
    @Size(min = 10, max = 512)
    private String description;
    @NotNull
    private Transmission transmission;
    @NotNull
    private Long modelId;

    public Engine getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(Engine engine) {
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

    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
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

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(
            Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", transmission=" + transmission +
                ", modelId=" + modelId +
                '}';
    }
}

