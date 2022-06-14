package com.example.QuestionnaireApp.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "test")
@Table(name = "test")
public class TestQuestions implements Serializable{

    @Id
    private String questionnaireName;


    private String lectureName;
    private String subjectName;
    private String description;
    private int questionnaireDuration;

    @OneToMany(targetEntity = Question.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "tq_fk",referencedColumnName = "questionnaireName")
    private List<Question> questionList;

    public TestQuestions(String lectureName,String questionnaireName ,String subjectName,String description,int questionnaireDuration,
                         List<Question> questionList ){

        this.lectureName = lectureName;
        this.questionnaireName = questionnaireName;
        this.subjectName = subjectName;
        this.description = description;
        this.questionnaireDuration = questionnaireDuration;
        this.questionList = questionList;

    }

    public TestQuestions() {

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

    public void setQuestionnaireDuration(int questionnaireDuration) {
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
