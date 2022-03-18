package com.example.QuestionnaireApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "challangesDemo1")
public class User {

    @Id
    private String id;
    private String challageName;
    private String description;
    private String problemStatement;
    private String inputFormat;
    private String constraints;
    private String outputFormat;
    private boolean published;

    public User() {
    }

    public User(String challageName, String description, String problemStatement, String inputFormat,
            String constraints, String outputFormat, boolean published) {
        this.challageName = challageName;
        this.description = description;
        this.problemStatement = problemStatement;
        this.inputFormat = inputFormat;
        this.constraints = constraints;
        this.outputFormat = outputFormat;
        this.published = published;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return challageName;
    }

    public void setTitle(String challageName) {
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
        return "Tutorial [id=" + id + ", challangeName=" + challageName + ", desc=" +
                description + ", problemStatement=" + problemStatement + ", inputFormat=" +
                inputFormat + ", constraints=" + constraints + ", outputFormat=" +
                outputFormat +
                ", published=" + published + "]";
    }

    /*
     * @Id
     * private String id;
     * private String title;
     * private String description;
     * private boolean published;
     * public User() {
     * }
     * public User(String title, String description, boolean published) {
     * this.title = title;
     * this.description = description;
     * this.published = published;
     * }
     * public String getId() {
     * return id;
     * }
     * public String getTitle() {
     * return title;
     * }
     * public void setTitle(String title) {
     * this.title = title;
     * }
     * public String getDescription() {
     * return description;
     * }
     * public void setDescription(String description) {
     * this.description = description;
     * }
     * public boolean isPublished() {
     * return published;
     * }
     * public void setPublished(boolean isPublished) {
     * this.published = isPublished;
     * }
     * 
     * @Override
     * public String toString() {
     * return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description +
     * ", published=" + published + "]";
     * }
     */
}
