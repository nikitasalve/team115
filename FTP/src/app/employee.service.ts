import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Employee } from "./employee";
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:Http) { }
  getUsers():Observable<Employee[]>{
    return this.http.get
    ("http://localhost:8080/FTP115/api/employees")
    .map((res:Response) =>res.json());
  }

  searchEmploy(mgrno:number):Observable<Employee>{
    return this.http.get
    ("http://localhost:8080/FTP115/api/employees/" +mgrno)
    .map((res:Response) =>res.json());
  }
}
