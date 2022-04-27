import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePotComponent } from './delete-pot.component';

describe('DeletePotComponent', () => {
  let component: DeletePotComponent;
  let fixture: ComponentFixture<DeletePotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletePotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletePotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
