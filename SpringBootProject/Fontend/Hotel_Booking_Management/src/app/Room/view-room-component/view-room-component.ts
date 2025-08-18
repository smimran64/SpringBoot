import { ChangeDetectorRef, Component } from '@angular/core';
import { Hotel } from '../../model/hotel.model';
import { Room } from '../../model/room.model';
import { RoomService } from '../../service/room-service';
import { HotelService } from '../../service/hotel.service';

@Component({
  selector: 'app-view-room-component',
  standalone: false,
  templateUrl: './view-room-component.html',
  styleUrl: './view-room-component.css'
})
export class ViewRoomComponent {


  rooms: Room[] = [];
  hotels: Hotel[] = [];
  selectedHotelId?: number;
  loading: boolean = true;
  errorMessage: string = '';

  constructor(
    private roomService: RoomService,
    private hotelService: HotelService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.loadHotels();
    this.loadRooms();
  }

  loadHotels() {
    this.hotelService.getMyHotels().subscribe({
      next: (data) => {
        this.hotels = data,
        this.cdr.markForCheck();
      },
      error: (err) => console.error('Hotel loading error', err)
    });
  }

  loadRooms() {
    this.loading = true;
    if (this.selectedHotelId) {
      this.roomService.getRoomsByHotelId(this.selectedHotelId).subscribe({
        next: (data) => {
           this.rooms = data; this.loading = false; 
           this.cdr.markForCheck();
          
          },
        error: (err) => { this.errorMessage = 'Failed to load rooms'; this.loading = false; }
      });
    } else {
      this.roomService.getAllRooms().subscribe({
        next: (data) => { this.rooms = data; this.loading = false; },
        error: (err) => { this.errorMessage = 'Failed to load rooms'; this.loading = false; }
      });
    }
  }

  onHotelChange() {
    this.loadRooms();
  }




}
