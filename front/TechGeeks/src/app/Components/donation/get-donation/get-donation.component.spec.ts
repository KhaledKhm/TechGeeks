import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDonationComponent } from './get-donation.component';

describe('GetDonationComponent', () => {
  let component: GetDonationComponent;
  let fixture: ComponentFixture<GetDonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDonationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
