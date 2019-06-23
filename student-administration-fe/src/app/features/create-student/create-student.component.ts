import {Component, OnDestroy, OnInit} from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../student.service";
import {Router} from '@angular/router';
import {MatDatepickerModule} from '@angular/material';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit,OnDestroy {

  student: Student = new Student();
  submitted = false;
  isEdit: boolean;
  yesterdayDate = new Date();

  constructor(private studentService: StudentService,
              private router: Router) {

  }

  ngOnInit() {
    if(this.studentService.student){
      this.isEdit = true;
    }
    this.student = this.isEdit ? this.studentService.student : new Student();
  }

  ngOnDestroy(){
    this.isEdit = false;
  }

  save() {
    this.studentService.createStudent(this.student)
      .subscribe(data => console.log(data), error => console.log(error));
    this.student = new Student();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  setYesterdayDate() {
    this.yesterdayDate = new Date();
    this.yesterdayDate.setDate(this.yesterdayDate.getDate() - 1);
  }

  onEdit() {
    this.submitted = true;
    this.update();
  }

  private update() {
    this.studentService.updateStudent(this.student)
      .subscribe(data => console.log(data), error => console.log(error));
    this.student = new Student();
  }
}
