package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.model.SAQuestion;
import com.example.QuestionnaireApp.service.QuestionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/questions")
public class QuestionController {

    private final QuestionsService questionsService;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SAQuestion data){
        try {
            questionsService.saveQuestions(data);
            return ResponseEntity.status(HttpStatus.OK).body("question created");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionByQuestionnaireId(@PathVariable("id") Long id){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(questionsService.getQuestionByQuestionnaireId(id)).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable("id") Long id, @RequestBody SAQuestion SAQuestion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionsService.updateQuestion(id, SAQuestion));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionsService.deleteQuestion(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
