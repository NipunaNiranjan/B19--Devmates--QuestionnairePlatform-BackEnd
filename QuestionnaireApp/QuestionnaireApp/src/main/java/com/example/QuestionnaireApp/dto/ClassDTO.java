package com.example.QuestionnaireApp.dto;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassDTO {
    private long classId;
    private String className;
    private Integer noOfStudents;
    private Date fromDate;
    private Date toDate;
    private Date createdAt;
    private TeacherDTO teacher;
}
