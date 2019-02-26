import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule } from '@angular/http';
import {RouterModule,Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import {FormsModule} from '@angular/Forms';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import { EmployeedashComponent } from './employeedash/employeedash.component';
import { LeavedetailsComponent } from './leavedetails/leavedetails.component';
import { PendingleavesComponent } from './pendingleaves/pendingleaves.component';
import { EmployComponent } from './employ/employ.component';
import { ManagerComponent } from './manager/manager.component';
import { LeavehistoryComponent } from './leavehistory/leavehistory.component';
import { DropDownEventComponent } from './drop-down-event/drop-down-event.component';
const data:Routes =[
  {path:'',component:EmployeeComponent},
  {path:'employeelogin',component:EmployeeloginComponent},
  {path:'employeedash',component:EmployeedashComponent},
  {path:'leavedetails', component:LeavedetailsComponent},
  {path:'pendingleaves',component:PendingleavesComponent},
  {path:'dropdown',component:DropDownEventComponent}
 ]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    EmployeeloginComponent,
    EmployeedashComponent,
    LeavedetailsComponent,
    PendingleavesComponent,
    EmployComponent,
    ManagerComponent,
    LeavehistoryComponent,
    DropDownEventComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpModule,RouterModule.forRoot(data)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
