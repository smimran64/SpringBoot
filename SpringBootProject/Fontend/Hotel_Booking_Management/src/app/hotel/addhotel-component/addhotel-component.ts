import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Hotel } from '../../model/hotel.model';
import { HotelService } from '../../service/hotel.service';
import { LocationService } from '../../service/location.service';
import { Router } from '@angular/router';
import { Authservice } from '../../service/authservice';
import { HotelAdmin } from '../../model/hotelAdmin.model';
import { HotelAdminService } from '../../service/hotel-admin-service';

@Component({
  selector: 'app-addhotel-component',
  standalone: false,
  templateUrl: './addhotel-component.html',
  styleUrl: './addhotel-component.css'
})
export class AddhotelComponent implements OnInit {


 hotelForm!: FormGroup;
  locations: any[] = [];
  photoFile!: File;
  message: string = '';

  constructor(
    private hotelService: HotelService,
    private locationService: LocationService,
    private hotelAdminService: HotelAdminService,
    private router: Router,
    private cdr: ChangeDetectorRef,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    
    this.hotelForm = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      rating: ['', Validators.required],
      locationId: ['', Validators.required],
      hotelAdminId: [''],
      hotelAdminName: ['']
    });

    // Location drop down data load
    this.loadLocations();

    // HotelAdmin data load
    const hotelAdminId = 1; 
    this.loadHotelAdmin(hotelAdminId);
  }

  // Location drop down load
  loadLocations(): void {
    this.locationService.getAllLocations().subscribe({
      next: (locations) => {
        this.locations = locations;
        this.cdr.markForCheck();
      },
      error: (err) => console.error('Error loading locations', err)
    });
  }

  // HotelAdmin auto-fill
  loadHotelAdmin(id: number): void {
    this.hotelAdminService.getHotelByAdminId(id).subscribe({
      next: (admin) => {
        this.hotelForm.patchValue({
          hotelAdminId: admin.id,
          hotelAdminName: admin.name
        });
      },
      error: (err) => console.error('Error loading hotel admin', err)
    });
  }

  // Image select
  onFileSelected(event: any): void {
    if (event.target.files && event.target.files.length > 0) {
      this.photoFile = event.target.files[0];
    }
  }

  // Form submit

  saveHotel(): void {

    
    if (this.hotelForm.invalid || !this.photoFile) {
      this.message = 'Please fill all required fields and select an image.';
      return;
    }

    const addHotel = {
      id: 0,
      name: this.hotelForm.value.name,
      image: '',
      address: this.hotelForm.value.address,
      rating: this.hotelForm.value.rating,
      location: {
        id: this.hotelForm.value.locationId,
        name: '',
        image: ''
      },
      hotelAdmin: {
        id: this.hotelForm.value.hotelAdminId,
        name: this.hotelForm.value.hotelAdminName
      }
    };

    this.hotelService.creatHotel(addHotel, this.photoFile).subscribe({
      next: () => {
        alert('Hotel added successfully!');
        this.router.navigate(['/hotels']);
      },
      error: (err) => {
        console.error('Error saving hotel:', err);
        this.message = 'Error saving hotel.';
      }
    });
  }






}
