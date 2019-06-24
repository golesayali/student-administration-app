package com.studentsadmin.controller;

import com.studentsadmin.exception.ResourceNotFoundException;
import com.studentsadmin.exception.StudentAdministrationApplicationException;
import com.studentsadmin.model.Student;
import com.studentsadmin.services.StudentAdministrationService;
import com.studentsadmin.validation.StudentAdministrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/studentadminapi/v1")
public class StudentAdministrationController {

    @Autowired
    private StudentAdministrationService studentAdministrationService;

    @Autowired
    private StudentAdministrationValidator validator;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentAdministrationService.getAllStudents();
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) throws StudentAdministrationApplicationException {
        validator.validateInputStudentData(student);
        return studentAdministrationService.createStudent(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException, StudentAdministrationApplicationException {

        final Student updatedStudent;
        validator.validateInputStudentData(studentDetails);
        updatedStudent = studentAdministrationService.updateStudent(studentId, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }
}
