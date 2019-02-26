import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
@Component({
  selector: 'app-employeelogin',
  templateUrl: './employeelogin.component.html',
  styleUrls: ['./employeelogin.component.css']
})
export class EmployeeloginComponent implements OnInit {
  user : string;
  password:string;
  
    constructor(private _router: Router) {
      this.user =localStorage.getItem("employId");
     }

     emplogin(){
      if(this.user ==localStorage.getItem("employId") && this.password == "hexaware") {
        this._router.navigate(["/employeedash"]);
      }
      else {
        alert("invalid credential...");
      }
     }
  ngOnInit() {
  }

}
