import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDonationComponent } from './list-donation.component';

describe('ListDonationComponent', () => {
  let component: ListDonationComponent;
  let fixture: ComponentFixture<ListDonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListDonationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
