import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeavehistoryComponent } from './leavehistory.component';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgxPaginationModule } from 'ngx-pagination';
import { LeaveService } from '../leave.service';
import { HttpModule } from '@angular/http';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from "rxjs/observable/of";


const leaveServiceStub = {
  leavehistory(empId) {
    console.log('came inside the stub');
    const emps = [
      {
        "leaId":1,
        "leaNoOfDays":1,
        "leaStDate":"2019-12-27",
        "leaEndDate":"2019-12-27",
        "leaType":"EL",
        "leaReas":"sick",
        "leaAppOn":"2019-02-27",
        "leaStatus":"PENDING",
        "leaMngCmts":null,
        "leaEmpId":2000
      },
      
      {
        "leaId":2,
        "leaNoOfDays":1,
        "leaStDate":"2019-03-05",
        "leaEndDate":"2019-03-05",
        "leaType":"PL",
        "leaReas":"sick",
        "leaAppOn":"2019-03-01",
        "leaStatus":"PENDING",
        "leaMngCmts":null,
        "leaEmpId":3000
      }
    ];
    return of( emps );
  }
};




describe('LeavehistoryComponent', () => {
  let component: LeavehistoryComponent;
  let fixture: ComponentFixture<LeavehistoryComponent>;

  beforeEach(async(() => {
    localStorage.setItem("empId","1");
    TestBed.configureTestingModule({
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
      imports : [NgxPaginationModule,HttpModule, RouterTestingModule],
      declarations: [ LeavehistoryComponent ],

      providers: [{provide: LeaveService, 
        useValue: leaveServiceStub},EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavehistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it(`the employee id to be '1'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaId).toEqual(1);
  }));

  it(`the employee leave number of days '1'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaNoOfDays).toEqual(1);
  }));

  it(`the employee leave start date '2019-12-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaStDate).toEqual("2019-12-27");
  }));

  it(`the employee leave end date '2019-12-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaEndDate).toEqual("2019-12-27");
  }));

  it(`the employee leave type 'EL'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaType).toEqual("EL");
  }));


  it(`the employee leave reason 'sick'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaReas).toEqual("sick");
  }));

  it(`the employee leave applied on '2019-02-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaAppOn).toEqual("2019-02-27");
  }));

  it(`the employee leave status 'PENDING'`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaStatus).toEqual("PENDING");
  }));

  it(`the managerial comments null`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaMngCmts).toEqual(null);
  }));

  
  it(`the employee id 2000`, async(()=>{
    const fixture = TestBed.createComponent(LeavehistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].leaEmpId).toEqual(2000);
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
