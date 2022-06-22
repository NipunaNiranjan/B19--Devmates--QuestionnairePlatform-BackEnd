package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classId;

    @Column(unique = true, nullable = false)
    private String className;

    @Column
    private Integer noOfStudents;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;

    @Column
    private Date createdAt;

    @OneToOne(
            targetEntity = User.class,
            optional = false
    )
    private User teacher;

    @OneToMany(
            mappedBy = "aClass",
            fetch = FetchType.LAZY
    )
    private List<IClassStudent> students;

    @OneToMany(
            mappedBy = "aClass",
            fetch = FetchType.LAZY
    )
    private List<Questionnaire> questionnaires;

    public Class(long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "IClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", noOfStudents=" + noOfStudents +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
