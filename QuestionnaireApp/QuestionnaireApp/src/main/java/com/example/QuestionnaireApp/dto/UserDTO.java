package com.example.QuestionnaireApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int classId;
    private String Classname;
    private int noOfStudents;
    private Date _from;
    private Date _to;
    private String stu_username;

}



