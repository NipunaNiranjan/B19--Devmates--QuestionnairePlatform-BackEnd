package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewClass {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long class_id;

    @Column
    private String name;
    @Column
    private long teacherID;

}
