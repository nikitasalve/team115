import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Leavedetails } from "./leavedetails";
import 'rxjs/add/operator/map';
@Injectable({
  providedIn: 'root'
})
export class LeavedetailsService {

  constructor(private http:Http) { }
  getLeavedetails():Observable<Leavedetails[]>{
    return this.http.get
    ("http://localhost:8080/FTP115/api/leavedetails")
    .map((res:Response) =>res.json());
  }
}
