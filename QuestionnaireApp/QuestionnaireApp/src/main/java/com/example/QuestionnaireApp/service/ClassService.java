package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.model.Class;

import java.util.List;

public interface ClassService {
    String saveClass(Class newClass);
    String deleteClass(Long id);
    List<ClassDTO> getClasses();
    List<ClassDTO> getClasses(Long studentId);
    void addStudentToClass(Long studentId, Long classId);
}
