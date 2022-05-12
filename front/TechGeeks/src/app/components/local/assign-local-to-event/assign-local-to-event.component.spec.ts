import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignLocalToEventComponent } from './assign-local-to-event.component';

describe('AssignLocalToEventComponent', () => {
  let component: AssignLocalToEventComponent;
  let fixture: ComponentFixture<AssignLocalToEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignLocalToEventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignLocalToEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
