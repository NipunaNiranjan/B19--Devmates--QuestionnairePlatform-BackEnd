package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.ClassTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassTable,Long> {
}
