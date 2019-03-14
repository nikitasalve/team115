import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { EmployService } from './employ.service';

describe('EmployService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({ 
      imports:[
        HttpModule
      ],
      providers: [EmployService]
    });
  });

  it('should be created', inject([EmployService], (service: EmployService) => {
    expect(service).toBeTruthy();
  }));
});
