package com.example.mobilele.services.impl;


import com.example.mobilele.models.bindings.OfferServiceModel;
import com.example.mobilele.models.entities.Offer;
import com.example.mobilele.models.entities.enums.Engine;
import com.example.mobilele.models.entities.enums.Transmission;
import com.example.mobilele.repositories.OffersRepository;
import com.example.mobilele.services.ModelService;
import com.example.mobilele.services.OfferService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OffersRepository offersRepository;
    private  final ModelMapper modelMapper;
    private final Gson gson;
    private final ModelService modelService;
    private String PATH = "D:\\Users\\User\\Downloads\\mobilele\\src\\main\\resources\\static\\files\\offers.json";


    public OfferServiceImpl(OffersRepository offersRepository, ModelMapper modelMapper, Gson gson, ModelService modelService) {
        this.offersRepository = offersRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.modelService = modelService;
    }

    public List<OfferServiceModel> getAllOffers(){
        List<Offer> offers = this.offersRepository.findAll();
        List<OfferServiceModel> offerServiceModels = new ArrayList<>();
        for (Offer offer : offers) {
            OfferServiceModel offerServiceModel = this.modelMapper.map(offer, OfferServiceModel.class);
            offerServiceModels.add(offerServiceModel);
        }
        return offerServiceModels;

    }

    @Override
    public void seedOffers() throws IOException {
        String result = String.join("",Files.readAllLines(Path.of(PATH)));
        OfferServiceModel[] offerServiceModels = gson.fromJson(result, OfferServiceModel[].class);
        for (OfferServiceModel offerServiceModel : offerServiceModels) {
            Offer offer = this.modelMapper.map(offerServiceModel,Offer.class);
            offer.setCreated(Instant.now());
            offer.setModified(Instant.now());
            offer.setModel(this.modelService.getByName("TT"));
            offer.setTransmission(Transmission.valueOf(offerServiceModel.getTransmission()));
            offer.setEngine(Engine.valueOf(offerServiceModel.getEngine()));
            this.offersRepository.saveAndFlush(offer);
        }

    }
}
