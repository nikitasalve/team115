import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';
import { EmployeeService } from "../employee.service";
import { Employee } from '../employee';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  getemploymgr : Observable<Employee>;
  mgrno : number;
  constructor(private employService : EmployeeService) {
    alert("Manager Hi")
    this.mgrno = parseInt(localStorage.getItem("employMgrId"));
    alert(this.mgrno);
    this.getemploymgr = employService.searchEmploy(this.mgrno);
  }

  ngOnInit() {
  }

}
