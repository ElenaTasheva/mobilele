package com.example.mobilele.services.impl;


import com.example.mobilele.models.bindings.BrandServiceModel;
import com.example.mobilele.models.bindings.BrandViewModel;
import com.example.mobilele.models.bindings.ModelServiceModel;
import com.example.mobilele.models.entities.Brand;
import com.example.mobilele.models.entities.Model;
import com.example.mobilele.repositories.BrandRepository;
import com.example.mobilele.repositories.ModelRepository;
import com.example.mobilele.services.BrandService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ModelRepository modelRepository;
    private String path = "D:\\Users\\User\\Downloads\\mobilele\\src\\main\\resources\\static\\files\\brand.json";

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper, Gson gson, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.modelRepository = modelRepository;
    }


    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>();// <- final result here

        List<Model> allModels =
                modelRepository.findAll();

        allModels.forEach(me -> {
            // example: fiesta -> ford
            Brand brandEntity = me.getBrand();

            Optional<BrandViewModel> brandViewModelOpt = findByName(result,
                    brandEntity.getName());
            if (!brandViewModelOpt.isPresent()) {
                // not yet in the result, we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel() ;
                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelServiceModel newModelViewModel = new ModelServiceModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);
        });

        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name) {
        return allModels.
                stream().
                filter(m-> m.getName().equals(name)).
                findAny();
    }



    @Override
    public void seedData() throws IOException {
        String result = readFileContent();
        BrandServiceModel[] brands = this.gson
        .fromJson(readFileContent(), BrandServiceModel[].class);
        for (BrandServiceModel brandServiceModel : brands) {
            Brand brand = this.modelMapper.map(brandServiceModel, Brand.class);
            brand.setModified(Instant.now());
            brand.setCreated(Instant.now());
            this.brandRepository.saveAndFlush(brand);


        }

    }

    @Override
    public String readFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(path)));
    }

    @Override
    public Brand getBrandByName(String name) {
        return this.brandRepository.getByName(name);
    }
}



