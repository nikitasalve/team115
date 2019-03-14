import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeComponent } from './employee.component';
import { FormsModule } from '@angular/forms';
// import { of } from 'rxjs';
import { of } from 'rxjs/observable/of';
import { FilterdataPipe } from '../filterdata.pipe';
import { HttpModule } from '@angular/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';


const userServiceStub = {
  getEmps() {
    console.log('came inside the stub');
    const emps = [
      {
        "empId":1000,
        "empFullName":"NIKITA SALVE",
        "empEmail":"NIKITA@GMAIL.COM",
        "empMobile":"7028365639",
        "empDOJ":"2018-12-20",
        "empLeaveBal":8,
        "empDepart":"HEXAVARSITY",
        "mgrId":0
      },
      {
        "empId":2000,
        "empFullName":"OMKAR WAGHE",
        "empEmail":"OMKAR@GMAIL.COM",
        "empMobile":"9587456125",
        "empDOJ":"2017-10-15",
        "empLeaveBal":44,
        "empDepart":"INNOVATION",
        "mgrId":1000
      }
    ];
    return of( emps );
  }
};



describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,HttpModule,RouterTestingModule,HttpClientTestingModule
      ],
      declarations: [ EmployeeComponent,FilterdataPipe ], 
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  it(`the name employee Id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empId).toEqual(1000);
  }));

  it(`the name employee to be 'NIKITA SALVE'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empFullName).toEqual('NIKITA SALVE');
  }));

  it(`the Email employee to be 'NIKITA@GMAIL.COM'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empEmail).toEqual('NIKITA@GMAIL.COM');
  }));

  it(`the MobileNo employee to be '7028365639'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empMobile).toEqual('7028365639');
  }));

  it(`the DateOfJoining employee to be '2018-12-20'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empDOJ).toEqual('2018-12-20');
  }));

  it(`the Department employee to be 'HEXAVARSITY'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empDepart).toEqual('HEXAVARSITY');
  }));

  it(`the ManagerId employee to be '0'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].mgrId).toEqual(0);
  }));

  
  it(`the Available Leave Bal employee to be '8'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empLeaveBal).toEqual(8);
  }));

  
  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employee tr').length).toBe(2);
    });
  }));


  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
