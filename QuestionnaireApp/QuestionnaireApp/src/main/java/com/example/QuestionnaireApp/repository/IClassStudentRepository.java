package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.IClassStudent;
import com.example.QuestionnaireApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassStudentRepository extends JpaRepository<IClassStudent, Long> {
    List<IClassStudent> findAllByStudent(User student);
}
