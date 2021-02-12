package com.example.mobilele.services.impl;

import com.example.mobilele.models.bindings.UserRegisterBindingModel;
import com.example.mobilele.models.entities.User;
import com.example.mobilele.models.entities.UserRole;
import com.example.mobilele.models.entities.enums.Role;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.repositories.UserRoleRepository;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleRepository userRoleRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegisterBindingModel user) {
        User user1 = this.modelMapper.map(user, User.class);
        user1.setCreated(Instant.now());
        user1.setModified(Instant.now());
        UserRole userRole = this.userRoleRepository.findByRole(Role.valueOf(user.getRoles().stream()
                .findFirst().get()));
        user1.setUserRoles(List.of(userRole));
        this.userRepository.save(user1);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);

    }

    @Override
    public boolean authenticate(String userName, String password) {
        Optional<User> user = userRepository.findByUsername(userName);

        if(user.isEmpty()){
            return false;
        }
        else{
          //  return passwordEncoder.matches(password,user.get().getPassword());
            return  password.equals(user.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {

        User user = userRepository.findByUsername(userName).orElse(null);

        List<Role> userRoles = user.getUserRoles().stream().map(UserRole::getRole)
                .collect(Collectors.toList());

        currentUser.setAnonymous(false).setName(user.getUsername()).setUserRoles(userRoles);
    }



}
