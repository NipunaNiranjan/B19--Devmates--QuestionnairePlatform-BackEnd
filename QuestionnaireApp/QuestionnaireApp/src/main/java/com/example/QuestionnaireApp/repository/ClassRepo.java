package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepo extends JpaRepository<Class, Long> {


    @Query(value = "SELECT * FROM USER WHERE name =?1",nativeQuery = true)
    List<Class> getUserByUserName(String stu_username);

}
