import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveComponent } from './leave.component';
import { SortdataPipe } from '../sortdata.pipe';
import { HttpModule } from '@angular/http';
import { LeaveService } from '../leave.service';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from "rxjs/observable/of";


const userServiceStub = {
  getLevPending(empId) {
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


describe('LeaveComponent', () => {
  let component: LeaveComponent;
  let fixture: ComponentFixture<LeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpModule,RouterTestingModule
      ],
      
      declarations: [ LeaveComponent,SortdataPipe ],
      providers: [{provide: LeaveService, 
        useValue: userServiceStub},EmployeeService]
      // providers: [LeaveService, EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  // it(`the employee leave Id to be '1'`, async(()=>{
  //   const fixture = TestBed.createComponent(LeaveComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   app.ngOnInit();
  //   expect(app.lpending[0].leaId).toEqual(1);
  // }));



  it(`the employee id to be '2000'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaEmpId).toEqual(2000);
  }));

  it(`the employee leave id to be '1'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaId).toEqual(1);
  }));
  
  it(`the employee leave number of days'1'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaNoOfDays).toEqual(1);
  }));

  it(`the employee leave start date '2019-12-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaStDate).toEqual("2019-12-27");
  }));

  
  it(`the employee leave start date '2019-12-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaEndDate).toEqual("2019-12-27");
  }));

  it(`the employee leave type 'EL'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaType).toEqual("EL");
  }));

  it(`the employee leave reason 'sick'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaReas).toEqual("sick");
  }));

  it(`the employee leave applied on '2019-02-27'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaAppOn).toEqual("2019-02-27");
  }));

  it(`the employee leave applied on 'pending'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaStatus).toEqual("PENDING");
  }));

  
  it(`the employee leave manager comments 'null'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].leaMngCmts).toEqual(null);
  }));



  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
