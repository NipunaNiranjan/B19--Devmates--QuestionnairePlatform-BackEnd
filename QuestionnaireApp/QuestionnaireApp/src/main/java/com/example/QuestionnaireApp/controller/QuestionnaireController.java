package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.QuestionnaireDTO;
import com.example.QuestionnaireApp.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createQuestionnaire(@RequestBody QuestionnaireDTO data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.saveQuestionnaire(data));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Get all the questionnaires
     * @return
     */
    @GetMapping("/getQuestionnaire")
    public ResponseEntity<Object> getQuestionnaire(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.getQuestionnaire());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
