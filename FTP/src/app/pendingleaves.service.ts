import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pendingleaves } from './pendingleaves';
import {Router} from '@angular/router';
import { Http, Response } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class PendingleavesService {
  constructor(private http:Http) { }
  
  getLeavepending():Observable<Pendingleaves>{
    return this.http.get
    ("http://localhost:8080/FTP115/api/leavedetails/leavepending/1000")
    .map((res:Response) =>res.json());
  }
}
