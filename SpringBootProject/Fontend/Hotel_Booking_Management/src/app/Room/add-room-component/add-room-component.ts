import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RoomService } from '../../service/room-service';
import { HotelService } from '../../service/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../../model/room.model';
import { Hotel } from '../../model/hotel.model';

@Component({
  selector: 'app-add-room-component',
  standalone: false,
  templateUrl: './add-room-component.html',
  styleUrl: './add-room-component.css'
})
export class AddRoomComponent implements OnInit {


  roomForm!: FormGroup;
  hotels: Hotel[] = [];
  selectedImage?: File;
  message = '';

  constructor(
    private fb: FormBuilder,
    private roomService: RoomService,
    private hotelService: HotelService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.loadHotels();
  }

  private initForm(): void {
    this.roomForm = this.fb.group({
      roomType: ['', Validators.required],
      totalRooms: [0, [Validators.required, Validators.min(1)]],
      adults: [0, [Validators.required, Validators.min(1)]],
      children: [0, [Validators.required, Validators.min(0)]],
      price: [0, [Validators.required, Validators.min(0)]],
      hotelId: ['', Validators.required]
    });
  }

  private loadHotels(): void {
    this.hotelService.getAllHotel().subscribe({
      next: (data) => {
        this.hotels = data;
      },
      error: (err) => {
        console.error('Error loading hotels:', err);
      }
    });
  }

  onImageSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedImage = file;
    }
  }

  // ✅ Save Room
  saveRoom(): void {
    if (this.roomForm.invalid) {
      this.message = 'Please fill all fields';
      return;
    }

    const room: Room = {
      roomType: this.roomForm.value.roomType,
      totalRooms: this.roomForm.value.totalRooms,
      adults: this.roomForm.value.adults,
      children: this.roomForm.value.children,
      price: this.roomForm.value.price,
      hotel: { id: Number(this.roomForm.value.hotelId) }
    };

    this.roomService.saveRoom(room, this.selectedImage).subscribe({
      next: () => {
        alert('Room added successfully');
        this.router.navigate(['/rooms']);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error saving room';
      }
    });
  }

  // ✅ Update Room
  updateRoom(id: number): void {
    if (this.roomForm.invalid) {
      this.message = 'Please fill all fields';
      return;
    }

    const room: Room = {
      roomType: this.roomForm.value.roomType,
      totalRooms: this.roomForm.value.totalRooms,
      adults: this.roomForm.value.adults,
      children: this.roomForm.value.children,
      price: this.roomForm.value.price,
      hotel: { id: Number(this.roomForm.value.hotelId) }
    };

    this.roomService.updateRoom(id, room, this.selectedImage).subscribe({
      next: () => {
        alert('Room updated successfully');
        this.router.navigate(['/rooms']);
      },
      error: (err) => {
        console.error(err);
        this.message = 'Error updating room';
      }
    });
  }

  // ✅ Delete Room
  deleteRoom(id: number): void {
    if (confirm('Are you sure you want to delete this room?')) {
      this.roomService.deleteRoom(id).subscribe({
        next: () => {
          alert('Room deleted successfully');
        },
        error: (err) => {
          console.error(err);
          this.message = 'Error deleting room';
        }
      });
    }
  }


}
