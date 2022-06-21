package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.McqQuestions;
import com.example.QuestionnaireApp.service.McqQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mcq_questions")
public class McqQuestionsController {

    @Autowired
    private McqQuestionsService mcqQuestionsService;

    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody McqQuestions data){
        try {
            mcqQuestionsService.saveQuestions(data);
            return ResponseEntity.status(HttpStatus.OK).body("mcq question created");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/getQuestionByQuestionnaireId/{id}")
    public ResponseEntity<?> getQuestionByQuestionnaireId(@PathVariable("id") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.getQuestionByQuestionnaireId(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable("id") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.getQuestion(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PatchMapping("/updateQuestion/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable("id") int id, @RequestBody McqQuestions mcqQuestions){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.updateQuestion(id, mcqQuestions));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.deleteQuestion(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
