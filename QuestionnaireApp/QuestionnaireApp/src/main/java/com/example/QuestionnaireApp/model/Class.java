package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private int classId;

    @Column
    private String Classname;

    @Column
    private int noOfStudents;

    @Column
    private Date _from;

    @Column
    private Date _to;

    @Column(nullable = false)
    private String stu_username;

}
