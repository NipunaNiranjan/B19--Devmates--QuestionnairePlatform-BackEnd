package com.example.QuestionnaireApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "QuestionnaireDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireDTO {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Integer duration;
    @Column
    private String type;
}