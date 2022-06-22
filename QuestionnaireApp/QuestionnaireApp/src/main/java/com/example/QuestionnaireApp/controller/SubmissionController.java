package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.dto.SubmissionDTO;
import com.example.QuestionnaireApp.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/v1/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<?> addSubmission(@RequestBody SubmissionDTO submissionDTO){
        submissionService.answerQuestionnaire(submissionDTO);
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.toString())
                .body("Answer saved successfully!")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
