package com.example.QuestionnaireApp.entity.response;

public class LecturerCreatedQuestionnaire {

    private String questionnaireName;
    private String subjectName;
    private String description;

    public LecturerCreatedQuestionnaire(String questionnaireName,String subjectName,String description){
        this.questionnaireName = questionnaireName;
        this.subjectName = subjectName;
        this.description = description;
    }


    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
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
