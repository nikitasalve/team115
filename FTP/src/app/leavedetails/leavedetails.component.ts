import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeavedetailsService } from '../leavedetails.service';
import {Leavedetails} from '../leavedetails';
import {Router} from '@angular/router';

@Component({
  selector: 'app-leavedetails',
  templateUrl: './leavedetails.component.html',
  styleUrls: ['./leavedetails.component.css']
})
export class LeavedetailsComponent implements OnInit {
  
  leavedetailsdata : Observable<Leavedetails[]>;
  constructor (private LeavedetailsService:LeavedetailsService, private _router : Router){
  this.leavedetailsdata = LeavedetailsService.getLeavedetails();
  } 
  ngOnInit() {
  }

}
