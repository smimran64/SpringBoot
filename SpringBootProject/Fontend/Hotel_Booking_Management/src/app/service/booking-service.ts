import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking.model';
import { environments } from '../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private apiUrl = environments+"/api/booking"


  constructor(private http: HttpClient) {}


  getAllBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.apiUrl}/all`);
  }

  
  getBookingsByCustomer(customerId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.apiUrl}/customer/${customerId}`);
  }

  
  getBookingsByHotel(hotelId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.apiUrl}/hotel/${hotelId}`);
  }

 
  getBookingsByRoom(roomId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.apiUrl}/room/${roomId}`);
  }

  
  createBooking(booking: Booking): Observable<Booking> {
    return this.http.post<Booking>(`${this.apiUrl}/save`, booking);
  }

  
  updateBooking(booking: Booking): Observable<Booking> {
    return this.http.put<Booking>(`${this.apiUrl}/${booking.id}`, booking);
  }

 
  deleteBooking(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  
}
