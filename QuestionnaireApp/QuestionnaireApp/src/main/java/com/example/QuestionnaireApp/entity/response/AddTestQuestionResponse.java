package com.example.QuestionnaireApp.entity.response;

public class AddTestQuestionResponse {

    private String lectureName;
    private String subjectName;
    private String description;

    public AddTestQuestionResponse(String lectureName,String subjectName,String description){
        this.lectureName = lectureName;
        this.subjectName = subjectName;
        this.description = description;

    }


    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
