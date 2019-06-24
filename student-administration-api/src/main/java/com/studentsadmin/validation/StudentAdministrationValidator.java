package com.studentsadmin.validation;

import com.studentsadmin.exception.StudentAdministrationApplicationException;
import com.studentsadmin.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class StudentAdministrationValidator {

    public void validateInputStudentData(Student student) throws StudentAdministrationApplicationException {
        validateName(student.getName());
        validateBirthDate(student.getBirthDate());
        validateAddress(student.getAddress());
    }

    private void validateAddress(String address) throws StudentAdministrationApplicationException {
        if (StringUtils.isEmpty(address)) {
            throw StudentAdministrationApplicationException.getBuilder()
                    .errorCode("ERROR_SAAPI_0004")
                    .errorMessage("Address can not be empty").buildGenericException();
        }
    }

    private void validateBirthDate(Date birthDate) throws StudentAdministrationApplicationException {

        if (null == birthDate) {
            throw StudentAdministrationApplicationException.getBuilder()
                    .errorCode("ERROR_SAAPI_0002")
                    .errorMessage("Birth Date can not be empty").buildGenericException();
        }
        if (birthDate.after(new Date())) {
            throw StudentAdministrationApplicationException.getBuilder()
                    .errorCode("ERROR_SAAPI_0003")
                    .errorMessage("Birth Date can not be in future").buildGenericException();
        }
    }

    private void validateName(String name) throws StudentAdministrationApplicationException {
        if (StringUtils.isEmpty(name)) {
            throw StudentAdministrationApplicationException.getBuilder()
                    .errorCode("ERROR_SAAPI_0001")
                    .errorMessage("Please enter Student Name in name field").buildGenericException();
        }
    }


}
