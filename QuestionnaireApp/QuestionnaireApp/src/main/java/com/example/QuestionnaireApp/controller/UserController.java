package com.example.QuestionnaireApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository tutorialRepository;

    @GetMapping("/codingChallenges")
    public ResponseEntity<List<User>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<User> tutorials = new ArrayList<User>();
            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/codingChallenges/{id}")
    public ResponseEntity<User> getTutorialById(@PathVariable("id") String id) {
        Optional<User> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/codingChallenges")
    public ResponseEntity<User> createTutorial(@RequestBody User tutorial) {
        try {
            User _tutorial = tutorialRepository
                    .save(new User(tutorial.getTitle(), tutorial.getDescription(), tutorial
                            .getProblemStatement(),
                            tutorial.getInputFormat(), tutorial.getConstraints(), tutorial.getOutputFormat(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/codingChallenges/{id}")
    public ResponseEntity<User> updateTutorial(@PathVariable("id") String id, @RequestBody User tutorial) {
        Optional<User> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            User _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setProblemStatement(tutorial.getProblemStatement());
            _tutorial.setInputFormat(tutorial.getInputFormat());
            _tutorial.setConstraints(tutorial.getConstraints());
            _tutorial.setOutputFormat(tutorial.getOutputFormat());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/codingChallenges/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/codingChallenges")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/codingChallenges/published")
    public ResponseEntity<List<User>> findByPublished() {
        try {
            List<User> tutorials = tutorialRepository.findByPublished(true);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
