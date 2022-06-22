package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.model.Class;
import com.example.QuestionnaireApp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/v1/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<?> saveClass(@RequestBody Class newClass){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.toString())
                .body(classService.saveClass(newClass)).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<?> getClasses(){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(classService.getClasses()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getClasses(@PathVariable("id") Long id){
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(classService.getClasses(id)).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/add")
    public ResponseEntity<?> addStudentToClass(@RequestParam("studentId") Long studentId,
                                               @RequestParam("classId") Long classId) {
        classService.addStudentToClass(studentId, classId);
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body("Student has been added to the class successfully!").build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable Long id){
        return classService.deleteClass(id);
    }
}
