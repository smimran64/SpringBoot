import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LocationService } from '../../service/location.service';
import { HotelService } from '../../service/hotel.service';
import { Router } from '@angular/router';
import { environments } from '../../../environments/environments';

@Component({
  selector: 'app-home-componenent',
  standalone: false,
  templateUrl: './home-componenent.html',
  styleUrl: './home-componenent.css'
})
export class HomeComponenent {

  searchForm!: FormGroup;
  locations: any[] = [];
  hotels: any[] = [];
  searched: boolean = false;

  constructor(
    private fb: FormBuilder,
    private locationService: LocationService,
    private hotelService: HotelService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // form initialize
    this.searchForm = this.fb.group({
      locationId: [''],
      checkIn: [''],
      checkOut: ['']
    });

    // load all locations
    this.locationService.getAllLocations().subscribe(data => {
      this.locations = data;
    });
  }

  // search hotels
  onSearch() {
    const { locationId, checkIn, checkOut } = this.searchForm.value;
    this.hotelService.searchHotels(locationId, checkIn, checkOut).subscribe(data => {
      this.hotels = data;
      this.searched = true;
    });
  }

  // navigate to hotel details
  viewHotel(hotelId: number) {
    this.router.navigate(['/hotel-details', hotelId]);
  }


  placeholder = 'https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?q=80&w=1600&auto=format&fit=crop'; // বা লোকাল প্লেসহোল্ডার

getHotelImage(h: any): string {
  // h.image যদি শুধু fileName হয়:
  if (h?.image) {
    // উদাহরণ: http://localhost:8082/images/hotels/ + fileName
    return `${environments.apiUrl}/images/hotels/${h.image}`;
  }
  return this.placeholder;
}

imgFallback(ev: Event) {
  const target = ev.target as HTMLImageElement;
  target.src = this.placeholder;
}

trackById = (_: number, item: any) => item.id;
}
