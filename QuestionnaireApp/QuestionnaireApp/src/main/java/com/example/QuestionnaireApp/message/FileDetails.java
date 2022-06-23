package com.example.QuestionnaireApp.message;

import org.springframework.web.multipart.MultipartFile;

public class FileDetails {
    private MultipartFile file;
    private Integer questionnaireId;

    public FileDetails(MultipartFile file, Integer questionnaireId) {
        this.file = file;
        this.questionnaireId = questionnaireId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
