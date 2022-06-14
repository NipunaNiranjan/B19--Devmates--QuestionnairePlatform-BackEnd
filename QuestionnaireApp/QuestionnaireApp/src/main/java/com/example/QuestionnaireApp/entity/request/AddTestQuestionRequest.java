package com.example.QuestionnaireApp.entity.request;

import com.example.QuestionnaireApp.entity.Question;

import java.util.List;

public class AddTestQuestionRequest {

    private String lectureName;
    private String questionnaireName;
    private String subjectName;
    private String description;
    private int questionnaireDuration;
    private List<Question> questionList;

    public AddTestQuestionRequest(String lectureName,String questionnaireName ,String subjectName,String description,int questionnaireDuration,
                         List<Question> questionList ){

        this.lectureName = lectureName;
        this.questionnaireName = questionnaireName;
        this.subjectName = subjectName;
        this.description = description;
        this.questionnaireDuration = questionnaireDuration;
        this.questionList = questionList;

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

    public int getQuestionnaireDuration() {
        return questionnaireDuration;
    }

    public void setQuestionnaireDuration(int minForOneQuestion) {
        this.questionnaireDuration = questionnaireDuration;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }
}
