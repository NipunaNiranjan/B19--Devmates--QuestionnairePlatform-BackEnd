package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.model.Questionnaire;
import com.example.QuestionnaireApp.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping
    public ResponseEntity<Object> createQuestionnaire(@RequestBody Questionnaire data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.saveQuestionnaire(data));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getQuestionnaires(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.getQuestionnaire());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<?> getQuestionnaires(@PathVariable("id") Long classId){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(questionnaireService.getQuestionnaires(classId)).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable("id") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.deleteQuestionnaire(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
