package com.example.mobilele.models.bindings;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {
    private String name;

    private List<ModelServiceModel> models = new ArrayList<>();

    public List<ModelServiceModel> getModels() {
        return models;
    }

    public BrandViewModel addModel(ModelServiceModel modelViewModel) {
        this.models.add(modelViewModel);
        return this;
    }

    public BrandViewModel setModels(
            List<ModelServiceModel> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
