import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../student.service";
import {Observable} from "rxjs";
import {Student} from "../../models/student";

@Component({
  selector: 'app-user-activity',
  templateUrl: './user-activity.component.html',
  styleUrls: ['./user-activity.component.css']
})
export class UserActivityComponent implements OnInit {
  students: Observable<Student[]>;

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.students = this.studentService.getStudentsList();
  }

}
