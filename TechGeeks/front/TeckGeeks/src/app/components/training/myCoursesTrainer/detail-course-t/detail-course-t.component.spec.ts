import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCourseTComponent } from './detail-course-t.component';

describe('DetailCourseTComponent', () => {
  let component: DetailCourseTComponent;
  let fixture: ComponentFixture<DetailCourseTComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailCourseTComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCourseTComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
