package com.example.mobilele.services;

import com.example.mobilele.models.bindings.OfferServiceModel;

import java.io.IOException;
import java.util.List;

public interface OfferService {

    List<OfferServiceModel> getAllOffers();

    void seedOffers() throws IOException;
}
