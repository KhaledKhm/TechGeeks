import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCoursesTrainerComponent } from './my-courses-trainer.component';

describe('MyCoursesTrainerComponent', () => {
  let component: MyCoursesTrainerComponent;
  let fixture: ComponentFixture<MyCoursesTrainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyCoursesTrainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyCoursesTrainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
