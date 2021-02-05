package com.example.mobilele.security;


import com.example.mobilele.models.entities.enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private static final String ANONYMOUS_NAME = "anonymous";

    private String name = ANONYMOUS_NAME;
    private boolean isAnonymous = true;
    private List<Role> userRoles =new ArrayList<>();


    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public CurrentUser setUserRoles(List<Role> userRoles) {
        userRoles.clear();
        this.userRoles.addAll(userRoles);
        return this;
    }

    public boolean isAdmin() {
        return userRoles.contains(Role.ADMIN);
    }

    public boolean isLoggedIn() { return !isAnonymous();}

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = ANONYMOUS_NAME;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }
}
