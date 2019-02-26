import { TestBed } from '@angular/core/testing';

import { LeavedetailsService } from './leavedetails.service';

describe('LeavedetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeavedetailsService = TestBed.get(LeavedetailsService);
    expect(service).toBeTruthy();
  });
});
