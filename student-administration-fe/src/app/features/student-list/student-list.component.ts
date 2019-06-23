import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Student} from "../../models/student";
import {StudentService} from "../../student.service";
import {Router} from "@angular/router";

// @ts-ignore
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Observable<Student[]>;

  constructor(private studentService: StudentService,
              private router: Router) {
  }

  ngOnInit() {
    this.students = this.studentService.getStudentsList();
  }

  modifyStudent(student: Student) {
    this.studentService.student = student;
    this.router.navigate(['/add'])
  }

}
