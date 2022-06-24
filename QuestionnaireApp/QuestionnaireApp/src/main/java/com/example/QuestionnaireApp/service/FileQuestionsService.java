package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.message.ResponseSingleFile;
import com.example.QuestionnaireApp.model.FileQuestions;
import com.example.QuestionnaireApp.repository.FileQuestionsRepository;
import com.example.QuestionnaireApp.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
@Service
public class FileQuestionsService {
    @Autowired
    private FileQuestionsRepository fileQuestionsRepository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public String store(MultipartFile file, Integer questionnaireId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileQuestions fileQuestions = new FileQuestions(questionnaireId, fileName, file.getContentType(), file.getBytes());

        if(questionnaireRepository.findById(questionnaireId).isPresent()){
             fileQuestionsRepository.save(fileQuestions);
             return "Successfully saved.";
        }
        return "Cannot find relevant questionnaire";
    }
    public ArrayList<ResponseSingleFile> getFile(Integer fqid) {
        List<FileQuestions> fileQuestions=fileQuestionsRepository.findAllByQuestionnaireId(fqid);
        List<ResponseSingleFile>responseSingleFiles= new ArrayList<>();
        for (FileQuestions file:fileQuestions) {
            ResponseSingleFile responseFile = new ResponseSingleFile();
            responseFile.setFqid(file.getId());
            responseFile.setFileName(file.getName());
            responseSingleFiles.add(responseFile);
        }
        return (ArrayList<ResponseSingleFile>) responseSingleFiles;

    }

    public Stream<FileQuestions> getAllFiles() {
        return fileQuestionsRepository.findAll().stream();
    }

    public String deleteFile(Integer fqid) {
        if(fileQuestionsRepository.findById(fqid).isPresent()){
            fileQuestionsRepository.deleteById(fqid);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}
