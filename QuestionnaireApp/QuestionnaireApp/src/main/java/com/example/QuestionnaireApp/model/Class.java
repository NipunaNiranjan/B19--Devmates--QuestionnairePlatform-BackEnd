package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Class {
    @Id
    private long Class_id;
    private String name;
    private long TeacherID;


}
