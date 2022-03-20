package com.example.QuestionnaireApp.controller;


import com.example.QuestionnaireApp.model.Question;
import com.example.QuestionnaireApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;
    @GetMapping("/question")
    public ResponseEntity<List<Question>> getAllQuestions(@RequestParam(required = false) String descriptiveName) {

        try {
            List<Question> questions = new ArrayList<Question>();
            if (descriptiveName == null)
                questionRepository.findAll().forEach(questions::add);
            else
                questionRepository.findByDescriptiveName(descriptiveName).forEach(questions::add);
            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") String id) {
        Optional<Question> questionData = questionRepository.findById(id);
        if (questionData.isPresent()) {
            return new ResponseEntity<>(questionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        try {
            Question _question = questionRepository.save(new Question(question.getDescriptiveName(), question.getQuestionContent()));
            return new ResponseEntity<>(_question, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") String id, @RequestBody Question question) {
        Optional<Question> questionData = questionRepository.findById(id);
        if (questionData.isPresent()) {
            Question _question = questionData.get();
            _question.setDescriptiveName(question.getDescriptiveName());
            _question.setQuestionContent(question.getQuestionContent());

            return new ResponseEntity<>(questionRepository.save(_question), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/question/{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("id") String id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/question")
    public ResponseEntity<HttpStatus> deleteAllQuestions() {
        try {
            questionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*@GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {

    }*/
}
