package com.example.mobilele.models.bindings;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class BrandServiceModel {

    @Expose
    private String name;

    @Expose
    private List<ModelServiceModel> models = new ArrayList<>();

    public BrandServiceModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return name;
    }

    public BrandServiceModel setBrandName(String brandName) {
        this.name = brandName;
        return this;
    }


    public List<ModelServiceModel> getModels() {
        return models;
    }

    public void setModels(List<ModelServiceModel> models) {
        this.models = models;
    }

        public BrandServiceModel addModel(ModelServiceModel modelViewModel) {
        this.models.add(modelViewModel);
        return this;
    }

}
