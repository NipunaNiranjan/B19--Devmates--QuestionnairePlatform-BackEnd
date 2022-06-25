package com.example.QuestionnaireApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuestionnaireApp.model.CodingChallenges;
import com.example.QuestionnaireApp.repository.CodingChallengesRepository;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
public class CodingChallengesController {
    
    @Autowired
    private CodingChallengesRepository codingChallengesRepository ;

    // public CodingChallengesController ( CodingChallengesRepository challengeRepo){
    //     this.codingChallengesRepository = challengeRepo ;
    // }

    //  @GetMapping("/codingChallenges")
    //  public ResponseEntity<List<CodingChallenges>> getAllTutorials(@RequestParam(required = false) String title) {
    //      try {
    //          List<CodingChallenges> tutorials = new ArrayList<CodingChallenges>();
    //          if (title == null)
    //              codingChallengesRepository.findAll().forEach(tutorials::add);
    //          else
    //              codingChallengesRepository.findByTitle(title).forEach(tutorials::add);
    //          if (tutorials.isEmpty()) {
    //              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //          }
    //          return new ResponseEntity<>(tutorials, HttpStatus.OK);
    //      } catch (Exception e) {
    //          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //      }
    //  }

    @GetMapping("/codingChallenges")
    public Iterable<CodingChallenges> getAllTutorials() {
       
            return this.codingChallengesRepository.findAll() ;
    }

    //  @GetMapping("/codingChallenges/{id}")
    //  public ResponseEntity<CodingChallenges> getTutorialById(@PathVariable("id") int id) {
    //      Optional<CodingChallenges> tutorialData = codingChallengesRepository.findById(id);
    //      if (tutorialData.isPresent()) {
    //          return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    //      } else {
    //          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //      }
    //  }

    @GetMapping("/codingChallenges/{id}")
    public CodingChallenges getCodingChallenge( @PathVariable int id){
        return this.codingChallengesRepository.findByIdOrderByIdDesc(id) ; 
      }

    // @PostMapping("/codingChallenges")
    // public String createTutorial(@RequestBody CodingChallenges tutorial){
    //     CodingChallenges newcode = new CodingChallenges();
    //     newcode.setChallageName(tutorial.getChallageName());
    //     newcode.setDescription(tutorial.getDescription());
    //     newcode.setProblemStatement(tutorial.getProblemStatement());
    //     newcode.setInputFormat(tutorial.getInputFormat());
    //     newcode.setConstraints(tutorial.getConstraints());
    //     newcode.setOutputFormat( tutorial.getOutputFormat());
    //     newcode.setPublished(tutorial.isPublished());

    //     this.codingChallengesRepository.save(newcode);

    //     return "Successfully Saved!!!!!" ;
    // }

     @PostMapping("/codingChallenges")
     public ResponseEntity<CodingChallenges> createTutorial(@RequestBody CodingChallenges tutorial) {
         try {
            System.out.println(tutorial);
             CodingChallenges _tutorial = this.codingChallengesRepository
                     .save(new CodingChallenges(tutorial.getChallageName(), tutorial.getDescription(), tutorial
                             .getProblemStatement(),
                             tutorial.getInputFormat(), tutorial.getConstraints(), tutorial.getOutputFormat(), false));
             return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
         } catch (Exception e) {
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }


     @PutMapping("/codingChallenges/{id}")
     public ResponseEntity<?> updateTutorial(@PathVariable("id") int id , @RequestBody CodingChallenges tutorial ) {
         Optional<CodingChallenges> tutorialData = codingChallengesRepository.findById(id) ;
        
         if (tutorialData.isPresent()) {
             CodingChallenges _tutorial = tutorialData.get();
             _tutorial.setChallageName(tutorial.getChallageName());
             _tutorial.setDescription(tutorial.getDescription());
             _tutorial.setProblemStatement(tutorial.getProblemStatement());
             _tutorial.setInputFormat(tutorial.getInputFormat());
             _tutorial.setConstraints(tutorial.getConstraints());
             _tutorial.setOutputFormat(tutorial.getOutputFormat());
             _tutorial.setPublished(tutorial.isPublished());
             return ResponseEntity.status( HttpStatus.OK).body(codingChallengesRepository.save(_tutorial)) ;
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }

     @DeleteMapping("/codingChallenges/{id}")
     public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
         try {
             codingChallengesRepository.deleteById(id);
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

     @DeleteMapping("/codingChallenges")
     public ResponseEntity<HttpStatus> deleteAllTutorials() {
         try {
             codingChallengesRepository.deleteAll();
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

         }
     }

     @GetMapping("/codingChallenges/published/{id}")
     public ResponseEntity<?>  findByPublished(@PathVariable("id") int id) {
         try {
             Optional<CodingChallenges> tutorials = codingChallengesRepository.findById(id);
             if (!tutorials.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(tutorials);
             }
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tutorials);
         } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         }

     }

    }
