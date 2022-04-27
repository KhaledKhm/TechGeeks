import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyPotComponent } from './modify-pot.component';

describe('ModifyPotComponent', () => {
  let component: ModifyPotComponent;
  let fixture: ComponentFixture<ModifyPotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyPotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyPotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
