package com.studentsadmin.validation;

import com.studentsadmin.exception.StudentAdministrationApplicationException;
import com.studentsadmin.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentAdministrationValidatorTest {
    @InjectMocks
    StudentAdministrationValidator validator;

    @Test
    public void validateInputStudentData_test1_happyFlow() {
        Student student = new Student();
        student.setName("John Doe");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        student.setBirthDate(date);
        student.setAddress("Amsterdam");
        try {
            validator.validateInputStudentData(student);
        } catch (StudentAdministrationApplicationException e) {
            Assert.fail("Exception was not expected");
        }
    }

    @Test
    public void validateInputStudentData_test2_nameEmpty() {
        Student student = new Student();
        student.setName("");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        student.setBirthDate(date);
        student.setAddress("Amsterdam");
        try {
            validator.validateInputStudentData(student);
            Assert.fail("Exeption was expected");
        } catch (StudentAdministrationApplicationException e) {
            assert(true);
        }
    }

    @Test
    public void validateInputStudentData_test3_birthDateFuture() {
        Student student = new Student();
        student.setName("");
        Date date = new GregorianCalendar(9900, Calendar.FEBRUARY, 11).getTime();
        student.setBirthDate(date);
        student.setAddress("Amsterdam");
        try {
            validator.validateInputStudentData(student);
            Assert.fail("Exeption was expected");
        } catch (StudentAdministrationApplicationException e) {
            assert(true);
        }
    }

    @Test
    public void validateInputStudentData_test4_addressEmpty() {
        Student student = new Student();
        student.setName("");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        student.setBirthDate(date);
        student.setAddress("");
        try {
            validator.validateInputStudentData(student);
            Assert.fail("Exeption was expected");
        } catch (StudentAdministrationApplicationException e) {
            assert(true);
        }
    }
}