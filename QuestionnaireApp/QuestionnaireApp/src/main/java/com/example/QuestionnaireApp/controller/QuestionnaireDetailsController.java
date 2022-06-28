package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.QuestionnaireDetails;
import com.example.QuestionnaireApp.service.QuestionnaireDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
public class QuestionnaireDetailsController {
    
    private QuestionnaireDetailsService codeQuestionnaireService;

    public QuestionnaireDetailsController(QuestionnaireDetailsService codeQuestionnaireService) {
        this.codeQuestionnaireService = codeQuestionnaireService;
    }

    @PostMapping("/codeDetails")
    public ResponseEntity<Object> createQuestionnaire(@RequestBody QuestionnaireDetails data) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.saveQuestionnaire(data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Get all the questionnaires details
     * 
     * @return
     */
    @GetMapping("/codeDetails")
    public ResponseEntity<Object> getQuestionnaire() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.getQuestionnaire());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //----------------Get by Questionnaire ID--------------------------------
    @GetMapping("/codeDetails/{id}")
    public ResponseEntity<Object> getQuestionnaireById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.getQuestionnaireById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/codeDetails/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.deleteQuestionnaire(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
