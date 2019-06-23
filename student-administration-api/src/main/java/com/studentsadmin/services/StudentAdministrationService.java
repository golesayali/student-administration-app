package com.studentsadmin.services;

import com.studentsadmin.exception.ResourceNotFoundException;
import com.studentsadmin.model.Student;

import java.util.List;

public interface StudentAdministrationService {
    List<Student> getAllStudents();

    Student createStudent(Student employee);

    Student updateStudent(Long studentId, Student studentDetails) throws ResourceNotFoundException;

}
