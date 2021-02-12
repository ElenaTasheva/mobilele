package com.example.mobilele.models.bindings;

import com.example.mobilele.models.entities.enums.Category;

public class ModelServiceModel {

    private long id;
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private Integer endYear;

    public long getId() {
        return id;
    }

    public ModelServiceModel setId(long id) {
        this.id = id;
        return this;
    }

    public ModelServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ModelServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelServiceModel setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelServiceModel setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }
}
