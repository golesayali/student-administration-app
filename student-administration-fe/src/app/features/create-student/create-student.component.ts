import {Component, OnDestroy, OnInit} from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../student.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit,OnDestroy {

  student: Student = new Student();
  submitted: boolean = false;
  isEdit: boolean;
  yesterdayDate = new Date();
  maxDateBirthDate = new Date();
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
    this.studentService.student = null;
    this.isEdit = false;
    this.submitted = false;
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
