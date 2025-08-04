import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllJobSeeker } from './view-all-job-seeker';

describe('ViewAllJobSeeker', () => {
  let component: ViewAllJobSeeker;
  let fixture: ComponentFixture<ViewAllJobSeeker>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewAllJobSeeker]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAllJobSeeker);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
