import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeService } from "../employee.service";
import { Employee } from '../employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  // to get all the Employees
    employees : Observable<Employee[]>;
    constructor (private EmployeeService:EmployeeService, private _router : Router){
    this.employees = EmployeeService.getUsers();
    }


    // employname : string;
    login(empId,mgrId){
      alert("welcome to employee login")
      localStorage.setItem("employId",empId);
      localStorage.setItem("employMgrId",mgrId);
      this._router.navigate(["/employeelogin"]);
      
    }
  ngOnInit() {
  }

} 
