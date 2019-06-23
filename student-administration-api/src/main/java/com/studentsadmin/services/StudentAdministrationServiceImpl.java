package com.studentsadmin.services;

import com.studentsadmin.exception.ResourceNotFoundException;
import com.studentsadmin.model.Student;
import com.studentsadmin.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAdministrationServiceImpl implements StudentAdministrationService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student employee) {
        return studentRepository.save(employee);
    }

    @Override
    public Student updateStudent(Long studentId, Student studentDetails) throws ResourceNotFoundException {
        Student student = null;
        Student updatedStudent = null;

        student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));
        student.setName(studentDetails.getName());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setAddress(studentDetails.getAddress());
        updatedStudent = studentRepository.save(student);
        return updatedStudent;

    }
}
