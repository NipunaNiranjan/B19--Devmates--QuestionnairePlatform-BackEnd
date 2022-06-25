package com.example.QuestionnaireApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodingChallenges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String challageName;
    @Column
    private String description;
    @Column
    private String problemStatement;
    @Column
    private String inputFormat;
    @Column
    private String constraints;
    @Column
    private String outputFormat;
    @Column(columnDefinition = "boolean default false")
    private boolean published;

    public CodingChallenges(String challageName, String description, String problemStatement, String inputFormat,
            String constraints, String outputFormat, boolean published) {
        this.challageName = challageName;
        this.description = description;
        this.problemStatement = problemStatement;
        this.inputFormat = inputFormat;
        this.constraints = constraints;
        this.outputFormat = outputFormat;
        this.published = published;
    }

    public void setId(int id){
        this.id = id ;
    }

    public int getId() {
        return id;
    }
    
    public String getChallageName() {
        return challageName;
    }

    public void setChallageName(String challageName) {
        this.challageName = challageName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProblemStatement() {
        return problemStatement;
    }
    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }
    public String getInputFormat() {
        return inputFormat;
    }
    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }
    public String getConstraints() {
        return constraints;
    }
    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }
    public String getOutputFormat() {
        return outputFormat;
    }
    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }
    
    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "CodingChallenges [challageName=" + challageName + ", constraints=" + constraints + ", description="
                + description + ", id=" + id + ", inputFormat=" + inputFormat + ", outputFormat=" + outputFormat
                + ", problemStatement=" + problemStatement + ", published=" + published + "]";
    }

    
    public CodingChallenges(){

    }
    
}
