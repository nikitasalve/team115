import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from'@angular/http';
import {FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployComponent } from './employ/employ.component';
import { LeaveComponent } from './leave/leave.component';
import { LeavehistoryComponent } from './leavehistory/leavehistory.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';

import { ApplyleaveComponent } from './applyleave/applyleave.component';
import { FilterdataPipe } from './filterdata.pipe';
import { SortdataPipe } from './sortdata.pipe';
<<<<<<< HEAD:app/app.module.ts
import {LeaveService} from './leave.service';
import {NgxPaginationModule} from 'ngx-pagination';


const data : Routes = [
  {path:'' ,component:EmployeeComponent},
=======
import { MainpageComponent } from './mainpage/mainpage.component';


const data : Routes = [
  {path:'' ,component:MainpageComponent},
>>>>>>> a30735c74f7b6949c318928c6f90dfc6c2d846ee:project/app/app.module.ts
  // {path:'dashboard/employ', component:EmployComponent},
  // {path:'dashboard/manager', component:ManagerComponent},
  {path:'login' ,component : LoginComponent},
  // {path:'dashboard/history' ,component : LeavehistoryComponent},
  {path:'employee' ,component : EmployeeComponent},
  {path:'dashboard',component:DashboardComponent,
  children: [                          //<---- child components declared here
    {
        path:'employ',
        component: EmployComponent
    },
    {
        path:'manager',
        component: ManagerComponent
    },
    {
      path:'leave',
      component: LeaveComponent
    },
    {
      path:'applyLeave',
      component: ApplyleaveComponent
    },
    {
      path:'history',
      component: LeavehistoryComponent
    },


  ]},
  // {path:'dashboard/leave',component: LeaveComponent},
  {path:'ApproveDeny',component: ApproveDenyComponent},
  // {path:'dashboard/applyLeave',component: ApplyleaveComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LoginComponent,
    ManagerComponent,
    DashboardComponent,
    EmployComponent,
    LeaveComponent,
    LeavehistoryComponent,
    ApproveDenyComponent,
    ApplyleaveComponent,
    FilterdataPipe,
    SortdataPipe,
<<<<<<< HEAD:app/app.module.ts
],
=======
    MainpageComponent,

  ],
>>>>>>> a30735c74f7b6949c318928c6f90dfc6c2d846ee:project/app/app.module.ts
  imports: [
    BrowserModule,HttpModule,FormsModule,NgxPaginationModule,
    RouterModule.forRoot(data)
  ],
  providers: [LeaveService],
  bootstrap: [AppComponent]
})
export class AppModule { }
