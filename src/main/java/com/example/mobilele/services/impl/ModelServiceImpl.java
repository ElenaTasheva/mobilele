package com.example.mobilele.services.impl;


import com.example.mobilele.models.entities.Model;
import com.example.mobilele.repositories.ModelRepository;
import com.example.mobilele.services.BrandService;
import com.example.mobilele.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private  final BrandService brandService;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }


    @Override
    public void saveEntities(Model model) {
        this.modelRepository.save(model);
    }

    @Override
    public Model getByName(String name) {
        return this.modelRepository.getByName(name);
    }
}
