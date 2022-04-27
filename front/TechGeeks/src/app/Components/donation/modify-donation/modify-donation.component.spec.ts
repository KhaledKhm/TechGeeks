import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyDonationComponent } from './modify-donation.component';

describe('ModifyDonationComponent', () => {
  let component: ModifyDonationComponent;
  let fixture: ComponentFixture<ModifyDonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyDonationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyDonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
