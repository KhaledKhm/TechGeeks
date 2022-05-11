import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCoursesWomenComponent } from './my-courses-women.component';

describe('MyCoursesWomenComponent', () => {
  let component: MyCoursesWomenComponent;
  let fixture: ComponentFixture<MyCoursesWomenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyCoursesWomenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyCoursesWomenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
