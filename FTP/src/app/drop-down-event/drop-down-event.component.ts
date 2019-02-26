import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeService } from "../employee.service";
import { Employee } from '../employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-drop-down-event',
  templateUrl: './drop-down-event.component.html',
  styleUrls: ['./drop-down-event.component.css']
})
export class DropDownEventComponent implements OnInit {
  name :string;
  employees : Observable<Employee[]>;
  constructor(private EmployeeService:EmployeeService, private _router : Router) {
    this.employees = EmployeeService.getUsers();
   }

  ngOnInit() {
  }

}
