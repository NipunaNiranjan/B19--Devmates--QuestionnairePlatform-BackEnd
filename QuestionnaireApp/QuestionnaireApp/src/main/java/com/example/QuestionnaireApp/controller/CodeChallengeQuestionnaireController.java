package com.example.QuestionnaireApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.QuestionnaireApp.model.CodeChallengeQuestionnaire;
import com.example.QuestionnaireApp.repository.CodeChallengeQuestionnaireRepository;
import com.example.QuestionnaireApp.service.CodeChallengeQuestionnaireService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
public class CodeChallengeQuestionnaireController {
    
   
    private CodeChallengeQuestionnaireService codeQuestionnaireService ;


    public CodeChallengeQuestionnaireController(CodeChallengeQuestionnaireService codeQuestionnaireService) {
        this.codeQuestionnaireService = codeQuestionnaireService;
    }

    @PostMapping("/codeQuestionnaire")
    public ResponseEntity<Object> createQuestionnaire(@RequestBody CodeChallengeQuestionnaire data) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.saveQuestionnaire(data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Get all the questionnaires
     * 
     * @return
     */
    @GetMapping("/codeQuestionnaire")
    public ResponseEntity<Object> getQuestionnaire() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.getQuestionnaire());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/codeQuestionnaire/{id}")
    public ResponseEntity<Object> getQuestionnaireById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.getQuestionnaireById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/codeQuestionnaire/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(codeQuestionnaireService.deleteQuestionnaire(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // @GetMapping("/codeQuestionnaires")
    // public List<CodeChallengeQuestionnaire> getAllQuestionnaires(@RequestParam(required = false) String title) {
    //     return codeQuestionnaireRepository.findAll() ;
    // }

    // @GetMapping("/codeQuestionnaires/{id}")
    // public CodeChallengeQuestionnaire getQuestionnairesById(@PathVariable("id") long id) {
    //     return this.codeQuestionnaireRepository.findByIdOrderById(id);
    // }
    
    // // @PostMapping("/codeQuestionnaires")
    // // public ResponseEntity<CodeChallengeQuestionnaire> createQuestionnaire( @RequestBody CodeChallengeQuestionnaire questionnaire){
    // //     try {
    // //         CodeChallengeQuestionnaire ques = this.codeQuestionnaireRepository.save(
    // //                 new CodeChallengeQuestionnaire(questionnaire.getTitle(), questionnaire.getDescription(), true));
    // //         return new ResponseEntity<>(ques, HttpStatus.CREATED);
    // //     } catch (Exception e) {
    // //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // //     }
        
    // // }

    // @PostMapping("/codeQuestionnaires")
    // public ResponseEntity<CodeChallengeQuestionnaire> createQuestionnaire(
    //         @RequestBody CodeChallengeQuestionnaire questionnaire) {
    //     try {
    //         CodeChallengeQuestionnaire ques = this.codeQuestionnaireRepository.save(
    //                 new CodeChallengeQuestionnaire(questionnaire.getTitle(), questionnaire.getDescription(), true));
    //         return new ResponseEntity<>(ques, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

}
