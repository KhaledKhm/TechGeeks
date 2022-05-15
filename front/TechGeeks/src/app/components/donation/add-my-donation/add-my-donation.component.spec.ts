import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMyDonationComponent } from './add-my-donation.component';

describe('AddMyDonationComponent', () => {
  let component: AddMyDonationComponent;
  let fixture: ComponentFixture<AddMyDonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMyDonationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMyDonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
