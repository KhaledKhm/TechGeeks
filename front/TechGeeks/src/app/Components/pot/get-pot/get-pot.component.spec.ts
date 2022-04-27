import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPotComponent } from './get-pot.component';

describe('GetPotComponent', () => {
  let component: GetPotComponent;
  let fixture: ComponentFixture<GetPotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetPotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
