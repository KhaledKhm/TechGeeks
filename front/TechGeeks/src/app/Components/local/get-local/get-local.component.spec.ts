import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetLocalComponent } from './get-local.component';

describe('GetLocalComponent', () => {
  let component: GetLocalComponent;
  let fixture: ComponentFixture<GetLocalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetLocalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
