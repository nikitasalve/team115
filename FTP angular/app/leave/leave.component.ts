import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveService } from '../leave.service';
import { EmployeeService } from '../employee.service';
import { Leave } from '../leave';
import { Employee } from '../employee';
import { Router } from '@angular/router';


@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {
  empid:number;
  uname:string;
  leaves : Observable<Leave[]>;
  emps : Observable<Employee[]>;
  lev : Observable<Leave[]>;
  flag : boolean;
  order : string = 'leaStDate';
  reverse:boolean = true;

  sempno :string = 'empId';
  rev :boolean = false;

  constructor(private leaveService: LeaveService, private _router : Router, private empService : EmployeeService) { 
    this.emps = this.empService.getEmps();
     this.empid = parseInt(localStorage.getItem("empId"));
    this.lev = leaveService.getLevPending(this.empid);
    this.flag=false;
  }
  setClickRowDup(leaId,empId) {
    alert(leaId);
    this.flag=true;
    localStorage.setItem("leavId",leaId);
    localStorage.setItem("lempId",empId);
    alert("Employ ID" +this.empid);
  }

  setOrder(value:string){
    if(this.order == value){
        this.reverse =!this.reverse;
    }
    this.order = value;
  }

  doApproveDeny() {
    alert("Redirecting...");
    this._router.navigate(["/ApproveDeny"]);
  }

  doapplyLeave(){
    alert("Redirecting to apply leave");
    this._router.navigate(["/applyLeave"]);
  }
  //login(uname)
  // {
  //   localStorage.setItem("uname",uname);
  //   this. _router.navigate(["/login"]);
  // }

  ngOnInit() {
  }

}
