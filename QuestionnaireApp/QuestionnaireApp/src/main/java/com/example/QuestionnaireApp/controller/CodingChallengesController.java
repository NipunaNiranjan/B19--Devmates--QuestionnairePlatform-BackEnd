package com.example.QuestionnaireApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.QuestionnaireApp.model.CodeChallengeQuestionnaire;
import com.example.QuestionnaireApp.model.CodingChallenges;
import com.example.QuestionnaireApp.repository.CodeChallengeQuestionnaireRepository;
import com.example.QuestionnaireApp.repository.CodingChallengesRepository;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
public class CodingChallengesController {
    
    @Autowired
    private CodingChallengesRepository codingChallengesRepository ;

    @Autowired
    private CodeChallengeQuestionnaireRepository codeChallengeQuestionnaireRepository ;

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


    //  @PutMapping("/codingChallenges/{id}")
    //  public ResponseEntity<CodingChallenges> updateTutorial(@PathVariable("id") int id , @RequestBody CodingChallenges tutorial ) {
    //      Optional<CodingChallenges> tutorialData = codingChallengesRepository.findById(id) ;
        
    //      if (tutorialData.isPresent()) {
    //          CodingChallenges _tutorial = tutorialData.get();
    //          _tutorial.setChallageName(tutorial.getChallageName());
    //          _tutorial.setDescription(tutorial.getDescription());
    //          _tutorial.setProblemStatement(tutorial.getProblemStatement());
    //          _tutorial.setInputFormat(tutorial.getInputFormat());
    //          _tutorial.setConstraints(tutorial.getConstraints());
    //          _tutorial.setOutputFormat(tutorial.getOutputFormat());
    //          _tutorial.setPublished(tutorial.isPublished());
    //          return ResponseEntity.status( HttpStatus.OK).body(codingChallengesRepository.save(_tutorial)) ;
    //      } else {
    //          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //      }
    //  }
  @PutMapping("/codingChallenges/{id}")
  CodingChallenges updateChallenges(@RequestBody CodingChallenges newCode, @PathVariable int id){

        return codingChallengesRepository.findById(id)
            .map(code -> {
                code.setChallageName( newCode.getChallageName());
                code.setDescription( newCode.getDescription());
                code.setProblemStatement( newCode.getProblemStatement());
                code.setInputFormat( newCode.getInputFormat());
                code.setConstraints( newCode.getConstraints());
                code.setOutputFormat( newCode.getOutputFormat());
                code.setPublished( newCode.isPublished()); 
                return codingChallengesRepository.save(code);
            } ) 
            .orElseGet( () -> {
                newCode.setId(id);
                return codingChallengesRepository.save(newCode);

            }) ;
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

     //-----------------for Questionnaire--------------------------
    //  @GetMapping("/codingChallenges/{cId}/codeQuestionnaires")
    //     public ResponseEntity<List<CodeChallengeQuestionnaire>>getAllQuestionnairesByChallengeId( @PathVariable(value = "cId") int cId){
    //         List<CodeChallengeQuestionnaire> questionnaires = codingChallengesRepository.findQuestionnairesByChallengesId(cId);
    //         return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    //     }
    
    //  @GetMapping("/codeQuestionnaires/{questionnaireId}/codingChallenges")
    //  public ResponseEntity<List<CodingChallenges>>getAllChallengesByQuestionnaireId( @PathVariable(value = "qId") Long qId){
    //     List<CodingChallenges> challenges = codingChallengesRepository.findChallengesByQuestionnairesId( qId);
    //     return new ResponseEntity<>(challenges, HttpStatus.OK);
    //  }

     //------adding challenges to the Questionnaire---

    //  @PostMapping("/codeQuestionnaires/{questionnaireId}/codingChallenges")
    //  public ResponseEntity<CodingChallenges> addChallengesToQuestionnaire(@PathVariable(value = "qId") Long qId , @RequestBody CodingChallenges codeRequest ){
    //     CodingChallenges challenge = codeChallengeQuestionnaireRepository.findById( qId).map( questionnaire -> {
    //         int cId = codeRequest.getId();

    //         //challenge exists
    //         if(cId != 0){
    //             CodingChallenges _challenge = codingChallengesRepository.findByIdOrderByIdDesc(cId);
    //             questionnaire.addChallenge(_challenge);
    //             codeChallengeQuestionnaireRepository.save(questionnaire);
    //             return _challenge ;
    //         }
    //         // add and create new challenge
    //         // questionnaire.addChallenge(codeRequest);
    //         // return codingChallengesRepository.save(codeRequest);
    //         return  ;
    //     })
    //     return new ResponseEntity<>(challenge , HttpStatus.OK);
    //  }

    }
