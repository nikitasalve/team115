import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployComponent } from './employ.component';
import { EmployeeService } from '../employee.service';
import { HttpModule } from '@angular/http';
import { of } from 'rxjs/observable/of';

const userServiceStub = {
  searchEmployee(empid) {
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
      }
    ];
    return of( emps );
  }
};


describe('EmployComponent', () => {
  let component: EmployComponent;
  let employService : EmployeeService;  
  let fixture: ComponentFixture<EmployComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpModule
      ],
      declarations: [ EmployComponent ],
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    employService = TestBed.get(EmployeeService);
    fixture = TestBed.createComponent(EmployComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    component.empno=1000;
    
  });

  xit(`the name employee Id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(EmployComponent);
    const app = fixture.debugElement.componentInstance;
    spyOn(employService, 'searchEmployee').and.returnValue( of (userServiceStub));
    app.ngOnInit();
    alert(app.employ);
    console.log(app.employ);
    expect(app.employee.empId).toEqual(1000);
  }));
  it('should return a single user', () => {
    const userResponse =  {
      "empId":2000,
      "empFullName":"OMKAR WAGHE",
      "empEmail":"OMKAR@GMAIL.COM",
      "empMobile":"9587456125",
      "empDOJ":"2017-10-15",
      "empLeaveBal":44,
      "empDepart":"INNOVATION",
      "mgrId":1000
    };
    let response;
    spyOn(employService, 'searchEmployee').and.returnValue( of (userResponse));

    employService.searchEmployee(2000).subscribe(res => {
      response = res;
    });

    expect(response).toEqual(userResponse);


  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

