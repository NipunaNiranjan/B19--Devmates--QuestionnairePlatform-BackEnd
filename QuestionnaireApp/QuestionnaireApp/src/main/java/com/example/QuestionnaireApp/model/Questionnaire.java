package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "Questionnaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
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

    @ManyToOne(
            targetEntity = ClassTable.class,
            optional = false
    )
    private ClassTable classtable;
}