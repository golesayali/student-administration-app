package com.studentsadmin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studentsadmin.auditing.Auditable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student extends Auditable<String> {

    private long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String address;

    public Student() {

    }

    public Student(String name, Date birthDate, String address) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", birthDate=" + birthDate + ", address=" + address + "]";
    }
}
