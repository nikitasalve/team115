import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from "../employee.service";
@Component({
  selector: 'app-employeedash',
  templateUrl: './employeedash.component.html',
  styleUrls: ['./employeedash.component.css']
})
export class EmployeedashComponent implements OnInit {
constructor (){}
  ngOnInit() {
  }

}
