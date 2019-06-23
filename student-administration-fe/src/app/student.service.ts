import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from "../environments/environment";
import {Student} from "./models/student";


// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = environment.STUDENT_ADMINISTRATION_API_BASEURL_CONTEXT;
  public student : Student;

  constructor(private http: HttpClient) {
  }

  getStudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createStudent(student: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}`, student);
  }

  updateStudent(updatedStudent: Student): Observable<any> {
    return this.http.put(`${this.baseUrl}/${updatedStudent.id}`, updatedStudent);
  }

  getStudentsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
