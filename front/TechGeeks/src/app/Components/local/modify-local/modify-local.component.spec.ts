import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyLocalComponent } from './modify-local.component';

describe('ModifyLocalComponent', () => {
  let component: ModifyLocalComponent;
  let fixture: ComponentFixture<ModifyLocalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyLocalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
