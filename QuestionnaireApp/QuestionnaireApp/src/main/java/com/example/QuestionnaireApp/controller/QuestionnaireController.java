package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.Questionnaire;
import com.example.QuestionnaireApp.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createQuestionnaire(@RequestBody Questionnaire data){
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
    @GetMapping("/getQuestionnaire/{id}")
    public ResponseEntity<Object> getQuestionnaire(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.getQuestionnaire());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteQuestionnaire/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable("id") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.deleteQuestionnaire(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
