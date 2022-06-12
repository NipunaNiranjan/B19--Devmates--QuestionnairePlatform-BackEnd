package com.devmates.auth.repository;

import com.devmates.auth.model.ERole;
import com.devmates.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole name);
    Boolean existsByRole(ERole name);
}
