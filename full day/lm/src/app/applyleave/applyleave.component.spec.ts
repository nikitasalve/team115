import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyleaveComponent } from './applyleave.component';
import { LeaveService } from '../leave.service';
import { EmployeeService } from '../employee.service';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterTestingModule } from '@angular/router/testing';



describe('ApplyleaveComponent', () => {
  let component: ApplyleaveComponent;
  let fixture: ComponentFixture<ApplyleaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports : [FormsModule,HttpModule,RouterTestingModule],
      declarations: [ ApplyleaveComponent ],
      providers : [LeaveService,EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyleaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
