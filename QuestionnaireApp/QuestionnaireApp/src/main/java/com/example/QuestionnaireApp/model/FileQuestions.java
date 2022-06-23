package com.example.QuestionnaireApp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "filequestions")
public class FileQuestions {
    @Id
    @GeneratedValue
    private Integer fqid;
    @Column
    private Integer questionnaireId;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    @Lob
    private byte[] data;
    public FileQuestions() {
    }
    public FileQuestions(Integer questionnaireId, String name, String type, byte[] data) {
        this.questionnaireId=questionnaireId;
        this.name = name;
        this.type = type;
        this.data = data;
    }
    public Integer getId() {
        return fqid;
    }

    public void setFqid(Integer fqid) {
        this.fqid = fqid;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

//    @ManyToOne(
//            targetEntity = Questionnaire.class,
//            optional = false
//    )
//    private Questionnaire questionnaire;
}
