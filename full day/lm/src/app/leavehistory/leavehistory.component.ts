import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Observable } from 'rxjs';
import { LeaveService } from '../leave.service';
import { Leave } from '../leave';

@Component({
  selector: 'app-leavehistory',
  templateUrl: './leavehistory.component.html',
  styleUrls: ['./leavehistory.component.css']
})
export class LeavehistoryComponent implements OnInit {
  empno: number;
  page: number = 1;
  totalRec:number;
  lhistory : Leave[] = [];
  
leaveDetails1:Observable <Leave[]>
  constructor(private leaveService : LeaveService, private _router : Router) { 
    this.empno=parseInt(localStorage.getItem("empId"));
    this.leaveDetails1=leaveService.leavehistory(parseInt(localStorage.getItem("empId")));
    this.leaveDetails1.subscribe(result => { this.totalRec = result.length; console.log(result.length)});

  }

  ngOnInit() {
    this.leaveService.leavehistory(this.empno).subscribe(res => {this.lhistory =res}); 
  }

}
