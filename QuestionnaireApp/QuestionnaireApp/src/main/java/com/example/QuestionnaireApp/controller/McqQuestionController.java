package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.model.MCQQuestion;
import com.example.QuestionnaireApp.service.McqQuestionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/mcq_questions")
public class McqQuestionController {

    private final McqQuestionsService mcqQuestionsService;

    public McqQuestionController(McqQuestionsService mcqQuestionsService) {
        this.mcqQuestionsService = mcqQuestionsService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody MCQQuestion data){
        try {
            mcqQuestionsService.saveQuestions(data);
            return ResponseEntity.status(HttpStatus.OK).body("mcq question created");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionByQuestionnaireId(@PathVariable("id") Long id){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(mcqQuestionsService.getQuestionByQuestionnaireId(id)).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable("id") Long id, @RequestBody MCQQuestion MCQQuestion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.updateQuestion(id, MCQQuestion));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mcqQuestionsService.deleteQuestion(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
