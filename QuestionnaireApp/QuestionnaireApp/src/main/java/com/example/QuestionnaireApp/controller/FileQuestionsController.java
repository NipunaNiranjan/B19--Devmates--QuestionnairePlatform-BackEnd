package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.message.FileDetails;
import com.example.QuestionnaireApp.message.ResponseFile;
import com.example.QuestionnaireApp.message.ResponseMessage;
import com.example.QuestionnaireApp.model.FileQuestions;
import com.example.QuestionnaireApp.service.FileQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "*")
public class FileQuestionsController {
    @Autowired
    private FileQuestionsService fileQuestionsService;
    @PostMapping(value="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@ModelAttribute FileDetails fileDetails) {
        String message = "";

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(fileQuestionsService.store(fileDetails.getFile(), fileDetails.getQuestionnaireId())));
        } catch (Exception e) {
            message = "Could not upload the file: " + fileDetails.getFile().getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
        }
    }
    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileQuestionsService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @GetMapping("/files/{id}")
    public ResponseEntity<String> getFile(@PathVariable Integer id) {
        //try{
            //return ResponseEntity.status(HttpStatus.OK).body(fileQuestionsService.getFile(id));
        //}catch(Exception e){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND);
        //}

        FileQuestions fileQuestions = fileQuestionsService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileQuestions.getName() + "\"")
                .body(fileQuestions.getName());
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<?>deleteFile(@PathVariable Integer id){
        String fileQuestions = fileQuestionsService.deleteFile(id);
        return ResponseEntity.ok()
                .body(fileQuestions);
    }
}
