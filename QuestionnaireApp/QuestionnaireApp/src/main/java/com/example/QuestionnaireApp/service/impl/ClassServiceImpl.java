package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.dto.TeacherDTO;
import com.example.QuestionnaireApp.exception.BadRequestException;
import com.example.QuestionnaireApp.model.Class;
import com.example.QuestionnaireApp.model.IClassStudent;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.ClassRepository;
import com.example.QuestionnaireApp.repository.IClassStudentRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final IClassStudentRepository iClassStudentRepository;
    private final UserRepository userRepository;

    public ClassServiceImpl(ClassRepository classRepository, IClassStudentRepository iClassStudentRepository,
                            UserRepository userRepository) {
        this.classRepository = classRepository;
        this.iClassStudentRepository = iClassStudentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String saveClass(Class newClass) {
        classRepository.save(newClass);
        return "class created successfully";
    }

    @Override
    public List<ClassDTO> getClasses(Long studentId) {
        List<ClassDTO> classes = new ArrayList<>();
        for(IClassStudent e : iClassStudentRepository.findAllByStudent(new User(studentId))) {
            Class aClass = e.getAClass();
            classes.add(getClassDTOBuilder(aClass));
        }
        return classes;
    }

    @Override
    public List<ClassDTO> getClasses() {
        List<ClassDTO> classes = new ArrayList<>();
        for(Class aClass : classRepository.findAll()) {
            classes.add(getClassDTOBuilder(aClass));
        }
        return classes;
    }

    @Override
    public void addStudentToClass(Long studentId, Long classId) {
        if(!classRepository.existsByClassId(classId))
            throw new BadRequestException("The given class not exists!");
        if(!userRepository.existsById(studentId))
            throw new BadRequestException("The given student not exists!");
        iClassStudentRepository.save(new IClassStudent(
                new Class(classId), new User(studentId)
        ));
    }

    @Override
    public String deleteClass(Long id) {
        Class deletedClass = classRepository.findById(id).get();
        System.out.println(id);
        //setting flag to deleted
        if (!deletedClass.isFlag()){
            try {
                deletedClass.setFlag(true);
                classRepository.save(deletedClass);
                return "successfully deleted";
            }catch (Exception e){
                return "unsuccessful,something went wrong";
            }
        }else {
            return "unsuccessful,something went wrong";
        }
    }

    private ClassDTO getClassDTOBuilder(Class aClass) {
        return ClassDTO.builder()
                .className(aClass.getClassName())
                .classId(aClass.getClassId())
                .noOfStudents(aClass.getNoOfStudents())
                .fromDate(aClass.getFromDate())
                .toDate(aClass.getToDate())
                .createdAt(aClass.getCreatedAt())
                .flag(aClass.isFlag())
                .teacher(
                        TeacherDTO.builder()
                                .id(aClass.getTeacher().getId())
                                .email(aClass.getTeacher().getEmail())
                                .phone(aClass.getTeacher().getPhone())
                                .build()
                )
                .build();
    }
}
