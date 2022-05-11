import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailTrainingComponent } from './detail-training.component';

describe('DetailTrainingComponent', () => {
  let component: DetailTrainingComponent;
  let fixture: ComponentFixture<DetailTrainingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailTrainingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
