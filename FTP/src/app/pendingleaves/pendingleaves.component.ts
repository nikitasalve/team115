import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';
import { PendingleavesService } from'../Pendingleaves.service';
import { Pendingleaves } from '../pendingleaves';
@Component({
  selector: 'app-pendingleaves',
  templateUrl: './pendingleaves.component.html',
  styleUrls: ['./pendingleaves.component.css']
})
export class PendingleavesComponent implements OnInit {

  leavependingdata : Observable<Pendingleaves>;
  constructor (private PendingleavesService:PendingleavesService, private _router : Router){
  this.leavependingdata = PendingleavesService.getLeavepending();
  } 

  ngOnInit() {
  }

}
