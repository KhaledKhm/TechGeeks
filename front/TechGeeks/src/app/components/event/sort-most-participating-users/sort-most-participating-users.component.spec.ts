import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortMostParticipatingUsersComponent } from './sort-most-participating-users.component';

describe('SortMostParticipatingUsersComponent', () => {
  let component: SortMostParticipatingUsersComponent;
  let fixture: ComponentFixture<SortMostParticipatingUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortMostParticipatingUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortMostParticipatingUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
