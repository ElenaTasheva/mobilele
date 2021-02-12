package com.example.mobilele.services.impl;


import com.example.mobilele.models.bindings.OfferSeedModel;
import com.example.mobilele.models.bindings.OfferServiceModel;
import com.example.mobilele.models.entities.Offer;
import com.example.mobilele.repositories.ModelRepository;
import com.example.mobilele.repositories.OffersRepository;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.services.ModelService;
import com.example.mobilele.services.OfferService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OffersRepository offersRepository;
    private  final ModelMapper modelMapper;
    private final Gson gson;
    private final ModelService modelService;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private String PATH = "D:\\Users\\User\\Downloads\\mobilele\\src\\main\\resources\\static\\files\\offers.json";


    public OfferServiceImpl(OffersRepository offersRepository, ModelMapper modelMapper, Gson gson, ModelService modelService, ModelRepository modelRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.offersRepository = offersRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.modelService = modelService;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    public List<OfferSeedModel> getAllOffers(){
        List<Offer> offers = this.offersRepository.findAll();
        List<OfferSeedModel> offerSeedModels = new ArrayList<>();
        for (Offer offer : offers) {
            OfferSeedModel offerSeedModel = this.modelMapper.map(offer, OfferSeedModel.class);
            offerSeedModels.add(offerSeedModel);
        }
        return offerSeedModels;

    }

    @Override
    public void seedOffers() throws IOException {
//        String result = String.join("",Files.readAllLines(Path.of(PATH)));
//        OfferServiceModel[] offerServiceModels = gson.fromJson(result, OfferServiceModel[].class);
//        for (OfferServiceModel offerServiceModel : offerServiceModels) {
//            Offer offer = this.modelMapper.map(offerServiceModel,Offer.class);
//            offer.setCreated(Instant.now());
//            offer.setModified(Instant.now());
//            offer.setModel(this.modelService.getByName("TT"));
//            offer.setTransmission(Transmission.valueOf(offerServiceModel.getTransmission()));
//            offer.setEngine(Engine.valueOf(offerServiceModel.getEngine()));
//            this.offersRepository.saveAndFlush(offer);
//        }

    }

    @Override
    public long save(OfferServiceModel offerModel) {
        Offer offer = this.modelMapper.map(offerModel, Offer.class);
        offer.setModel(modelRepository.findById(offerModel.getModelId()).orElse(null));
        offer.setSeller(userRepository.findByUsername(currentUser.getName()).orElse(null));
        offer.setCreated(Instant.now());
        offer.setModified(Instant.now());
        Offer offerNew = this.offersRepository.save(offer);
         return  offerNew.getId();
    }

    @Override
    public void delete(Long id) {
        this.offersRepository.deleteById(id);
    }

    @Override
    public OfferServiceModel getOfferById(Object id) {
       Offer offer = this.offersRepository.findById((Long) id).orElse(null);
        this.modelMapper.map(offer, OfferServiceModel.class);
        return  this.modelMapper.map(offer, OfferServiceModel.class);
    }

    @Override
    public Offer getOfferEntity(Long id) {
        return this.offersRepository.findById(id).orElse(null);
    }
}
