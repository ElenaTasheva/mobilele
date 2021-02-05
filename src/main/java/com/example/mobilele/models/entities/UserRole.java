package com.example.mobilele.models.entities;


import com.example.mobilele.models.entities.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Role role;



    public Role getRole() {
        return this.role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }


}