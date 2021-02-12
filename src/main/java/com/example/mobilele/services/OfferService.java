package com.example.mobilele.services;

import com.example.mobilele.models.bindings.OfferSeedModel;
import com.example.mobilele.models.bindings.OfferServiceModel;
import com.example.mobilele.models.entities.Offer;

import java.io.IOException;
import java.util.List;

public interface OfferService {

    List<OfferSeedModel> getAllOffers();

    void seedOffers() throws IOException;

    long save(OfferServiceModel offerModel);

    void delete(Long id);

    OfferServiceModel getOfferById(Object id);

    Offer getOfferEntity(Long id);
}
