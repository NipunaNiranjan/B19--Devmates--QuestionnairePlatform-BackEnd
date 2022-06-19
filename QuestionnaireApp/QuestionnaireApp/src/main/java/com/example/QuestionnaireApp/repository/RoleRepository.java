package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.ERole;
import com.example.QuestionnaireApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole name);
    Boolean existsByRole(ERole name);
}
