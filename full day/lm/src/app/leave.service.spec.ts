import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { LeaveService } from './leave.service';

describe('LeaveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpModule
      ],
      providers: [LeaveService]
    });
  });

  it('should be created', inject([LeaveService], (service: LeaveService) => {
    expect(service).toBeTruthy();
  }));
});
