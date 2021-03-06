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
  lpending : Leave[] = [];
  lev : Observable<Leave[]>;
  flag : boolean;
  order : string = 'leaStDate';
  reverse:boolean = true;
  sempno :string = 'empId';
  rev :boolean = false;
  leaveId : number;
  private prices = [];
  constructor(private leaveService: LeaveService, private _router : Router, private empService : EmployeeService) { 
    this.emps = this.empService.getEmps();
    this.empid = parseInt(localStorage.getItem("empId"));
    this.lev = leaveService.getLevPending(this.empid);
    this.flag = false;
    this.leaveId = parseInt(localStorage.getItem("leavId"));
    alert("total leaves:"+this.lev);
    alert(this.leaveId);
  }
  demo : boolean = false;
  //leaIdlist = [];
  empList= [];
  obj : Leave;
  mgrid : number;
  status : string;
  message : String;
  
  approveAll() {  
  
    this.status="YES";
    this.mgrid = parseInt(localStorage.getItem("empId"));
    this.obj = new Leave(); 
    //alert(this.empList);
    let str = this.empList.toString();   
    //alert(str);
    let res = str.split(',');
    for(var v in res) {
      this.obj.leaId=parseInt(res[v]);
      this.obj.leaMngCmts = "Enjoy";
      this.leaveService.approveDeny(this.mgrid,this.status,this.obj).subscribe(
        dd => {this.message=dd;
        },
        errorMsg => {
          this.message=errorMsg;
          console.log(errorMsg)
        }
      )
      setTimeout(()=> {
        this._router.navigate(['/dashboard'])
      },2000);
    }
  }

  checkbox(leaId, mgrId)
  {
    alert("Total Rec " + this.lpending.length);
    this.demo=true;
    var res1 = leaId + " ";
    this.empList.push(res1);
  }

  setClickRowDup(leaId,empId) {
    this.flag=true;
    localStorage.setItem("leavId",leaId);
    localStorage.setItem("lempId",empId);
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
    this._router.navigate(["dashboard/applyLeave"]);
  }
  //login(uname)
  // {
  //   localStorage.setItem("uname",uname);
  //   this. _router.navigate(["/login"]);
  // }

  ngOnInit() { 
    this.leaveService.getLevPending(this.empid).subscribe(res => {this.lpending = res});
  }

}
