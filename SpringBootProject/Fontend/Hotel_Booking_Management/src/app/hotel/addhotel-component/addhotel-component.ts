import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Hotel } from '../../model/hotel.model';
import { HotelService } from '../../service/hotel.service';
import { LocationService } from '../../service/location.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addhotel-component',
  standalone: false,
  templateUrl: './addhotel-component.html',
  styleUrl: './addhotel-component.css'
})
export class AddhotelComponent implements OnInit {


 locations:Location[] = [];
  formGroup!: FormGroup;
  image: File | null = null;


  constructor(
    private hotelService: HotelService,
    private locationService: LocationService,
    private router: Router,
    private cdr: ChangeDetectorRef,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    
  }

  loadLocations(): void {
    this.locationService.getAllLocations().subscribe({
      next: (locations) => {
        this.locations = locations;
        console.log(this.locations);
        this.cdr.markForCheck();
      },
      error: (err) => console.error('Error loading locations', err)
    });
  }


  



}
