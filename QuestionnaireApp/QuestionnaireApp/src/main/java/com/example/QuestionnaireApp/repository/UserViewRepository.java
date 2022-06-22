package com.example.QuestionnaireApp.repository;


import com.example.QuestionnaireApp.model.views.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserViewRepository extends JpaRepository<UserView,Long>, JpaSpecificationExecutor<UserView> {
}
