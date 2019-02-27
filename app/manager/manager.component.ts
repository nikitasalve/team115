import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  employ:Observable<Employee>;
  empno:number;
  mgno:number;

  constructor(private employeeService : EmployeeService) { 
    this.empno = parseInt(localStorage.getItem("mgrid"));
    alert(this.empno);
    this.employ = employeeService.searchEmployee(this.empno);

  }

  ngOnInit() {
  }

}
