package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM USER WHERE name =?1",nativeQuery = true)
    List<User> getUserByUserName(String stu_username);

}
