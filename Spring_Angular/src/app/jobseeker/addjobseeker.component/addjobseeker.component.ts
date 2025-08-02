import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JobseekerService } from '../../services/jobseeker.service';
import e from 'express';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addjobseeker.component',
  standalone: false,
  templateUrl: './addjobseeker.component.html',
  styleUrl: './addjobseeker.component.css'
})
export class AddjobseekerComponent {


  userForm!: FormGroup;
  jobSeekerForm!: FormGroup;
  photoFile!: File;
  message: string ='';

  constructor(
    private fb : FormBuilder,
    private jobseekerService: JobseekerService, // Replace with actual service type
    private router: Router
  ) {
    this.userForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      password: ['', [Validators.required]]
    });

    this.jobSeekerForm = fb.group({

      gender: ['', Validators.required],
      address: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
    });
  }


  onPhotoSelected(event: any): void {
    if (event.target.files.length > 0) {
      this.photoFile = event.target.files[0];

      console.log('Selected photo:', this.photoFile);
    }
  }


  onSubmit(): void {

    if(!this.photoFile){
      this.message = 'Please select a photo.';
      return;
    }

    if(this.userForm.invalid || this.jobSeekerForm.invalid) {
      this.message = 'Please fill in all required fields.';
      return;
    }

    const user = {
      name: this.userForm.value.name,
      email: this.userForm.value.email,
      phone: this.userForm.value.phone,
      password: this.userForm.value.password,
      role : 'JOBSEEKER'
    };

    const jobseeker = {
      name: this.userForm.value.name,
      email: this.userForm.value.email,
      phone: this.userForm.value.phone,
      gender: this.jobSeekerForm.value.gender,
      address: this.jobSeekerForm.value.address,
      dateOfBirth: this.jobSeekerForm.value.dateOfBirth

    };

    this.jobseekerService.registerJobSeeker(user, jobseeker, this.photoFile).subscribe({

      next: res =>{
        this.message = res.message || 'Jobseeker registered successfully!';
        this.userForm.reset();
        this.jobSeekerForm.reset();
        this.photoFile = undefined!;
        this.router.navigate(['']);
        
      },
      error: err => {
        this.message = 'Registration failed. Please try again.';+( err.error?.message || err.message);
      }
    });
  }

}
