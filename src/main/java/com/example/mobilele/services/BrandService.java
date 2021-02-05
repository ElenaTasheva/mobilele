package com.example.mobilele.services;

import com.example.mobilele.models.bindings.BrandViewModel;
import com.example.mobilele.models.entities.Brand;

import java.io.IOException;
import java.util.List;

public interface BrandService {

    void seedData() throws IOException;
    String readFileContent() throws IOException;
    Brand getBrandByName(String name);
    List<BrandViewModel> getAllBrands();
}
