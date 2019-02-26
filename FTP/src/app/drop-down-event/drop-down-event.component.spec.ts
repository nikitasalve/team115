import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropDownEventComponent } from './drop-down-event.component';

describe('DropDownEventComponent', () => {
  let component: DropDownEventComponent;
  let fixture: ComponentFixture<DropDownEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropDownEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropDownEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
