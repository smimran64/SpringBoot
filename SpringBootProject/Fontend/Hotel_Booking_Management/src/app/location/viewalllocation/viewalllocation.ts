import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../service/location.service';
import { Location } from '../../model/location.model';

@Component({
  selector: 'app-viewalllocation',
  standalone: false,
  templateUrl: './viewalllocation.html',
  styleUrl: './viewalllocation.css'
})
export class Viewalllocation implements OnInit {

  locations: Location[] = [];
  errorMessage: string = '';
  loading: boolean = false;

  constructor(private locationService: LocationService) {}

  ngOnInit(): void {
    this.fetchLocations();
  }

  fetchLocations(): void {
    this.loading = true;
    this.locationService.getAllLocations().subscribe({
      next: (data: any) => {
        this.locations = data;
        this.loading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to load locations.';
        this.loading = false;
        console.error(err);
      }
    });
  }



}
