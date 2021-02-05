package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.UserRole;
import com.example.mobilele.models.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findById(long id);
    UserRole findByRole(Role role);
}
