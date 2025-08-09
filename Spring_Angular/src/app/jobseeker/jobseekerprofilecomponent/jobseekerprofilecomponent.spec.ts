import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Jobseekerprofilecomponent } from './jobseekerprofilecomponent';

describe('Jobseekerprofilecomponent', () => {
  let component: Jobseekerprofilecomponent;
  let fixture: ComponentFixture<Jobseekerprofilecomponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Jobseekerprofilecomponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Jobseekerprofilecomponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
