import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { JobSeeker } from '../../model/jobseeker.model';
import { JobseekerService } from '../../services/jobseeker.service';

@Component({
  selector: 'app-jobseekerprofilecomponent',
  standalone: false,
  templateUrl: './jobseekerprofilecomponent.html',
  styleUrl: './jobseekerprofilecomponent.css'
})
export class Jobseekerprofilecomponent implements OnInit {

  jobSeeker?: JobSeeker;

  constructor(
    private jobSeekerService: JobseekerService, 
    private cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    this.jobSeekerService.getProfile().subscribe({
      next: (data) => {
        this.jobSeeker = data;
        console.log(data);
        this.cdr.markForCheck();

      },
      error: (err) => {
        console.error('Failed to load profile', err);
      }
    });
  }

}
