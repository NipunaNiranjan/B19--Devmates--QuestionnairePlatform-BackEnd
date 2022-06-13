package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Class {
    @Id
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private long Class_id;
    private String name;
    private long TeacherID;


}
