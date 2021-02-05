package com.example.mobilele.services;

import com.example.mobilele.models.bindings.UserRegisterBindingModel;

public interface UserService {

   void registerUser(UserRegisterBindingModel user);

    void logoutCurrentUser();

    boolean authenticate(String userName, String password);

    void loginUser(String userName);

}
