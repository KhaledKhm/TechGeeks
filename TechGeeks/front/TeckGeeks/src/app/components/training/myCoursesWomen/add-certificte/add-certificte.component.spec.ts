import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCertificteComponent } from './add-certificte.component';

describe('AddCertificteComponent', () => {
  let component: AddCertificteComponent;
  let fixture: ComponentFixture<AddCertificteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCertificteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCertificteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
