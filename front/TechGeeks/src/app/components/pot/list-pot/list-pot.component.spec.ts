import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPotComponent } from './list-pot.component';

describe('ListPotComponent', () => {
  let component: ListPotComponent;
  let fixture: ComponentFixture<ListPotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
