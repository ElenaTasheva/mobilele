package com.example.mobilele.entities;


import com.example.mobilele.enums.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
public class UserRole {


    @EmbeddedId
    private UserRolePK user_id;

    @Enumerated(EnumType.STRING)
    private Role role;



    public Role getRole() {
        return this.role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }


}