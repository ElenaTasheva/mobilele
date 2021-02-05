package com.example.mobilele.services;

import com.example.mobilele.models.entities.Model;

public interface ModelService {

   void saveEntities(Model model);
   Model  getByName(String name);
}
