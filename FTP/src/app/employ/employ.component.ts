import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';
import { EmployeeService } from "../employee.service";
import { Employee } from '../employee';
@Component({
  selector: 'app-employ',
  templateUrl: './employ.component.html',
  styleUrls: ['./employ.component.css']
})
export class EmployComponent implements OnInit {

  getemploy : Observable<Employee>;
  empno : number;
  constructor (private EmployeeService:EmployeeService){
  this.empno = parseInt(localStorage.getItem("employId"));
  this.getemploy = EmployeeService.searchEmploy(this.empno);
  }


  ngOnInit() {
  }

}
