package com.example.QuestionnaireApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "viewActivities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewActivities {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(
            targetEntity = ClassTable.class,
            optional = false
    )
    private ClassTable classID;

    @OneToOne(
            targetEntity = Questionnaire.class,
            optional = false
    )
    private Questionnaire questionnaireID;

}
