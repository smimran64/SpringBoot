import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { environments } from '../../environments/environments';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Room } from '../model/room.model';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl: string = environments.apiUrl + '/api/room';



  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object

  ) { }


  private getToken(): string {
    if (isPlatformBrowser(this.platformId)) {
      return localStorage.getItem('authToken') || '';
    }
    return '';
  }

  private getAuthHeaders(): HttpHeaders {
    const token = this.getToken();
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  // Get all rooms
  getAllRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(`${this.baseUrl}/all`).pipe(
      catchError(this.handleError)
    );
  }

  getRoomsByHotelId(hotelId: number): Observable<Room[]> {
    return this.http.get<Room[]>(`${this.baseUrl}/hotel/${hotelId}`);
  }

  // Get rooms by hotel name
  getRoomsByHotelName(hotelName: string): Observable<Room[]> {
    return this.http.get<Room[]>(`${this.baseUrl}/r/searchRoom?hotelName=${hotelName}`).pipe(
      catchError(this.handleError)
    );
  }

  saveRoom(room: Room, imageFile?: File): Observable<any> {
    const formData = new FormData();
    formData.append('room', new Blob([JSON.stringify({
      ...room,
      hotelDTO: { id: room.hotel.id }   // Backend expects hotelDTO.id
    })], { type: 'application/json' }));

    if (imageFile) formData.append('image', imageFile);

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.getToken()}`
    });

    return this.http.post(`${this.baseUrl}/save`, formData, { headers, responseType: 'text' }).pipe(
      catchError(this.handleError)
    );

  }



  updateRoom(id: number, room: Room, imageFile?: File): Observable<any> {
    if (room.hotel && room.hotel.id && typeof room.hotel.id === 'string') {
      room.hotel.id = parseInt(room.hotel.id, 10);
    }

    const formData = new FormData();
    formData.append('room', new Blob([JSON.stringify(room)], { type: 'application/json' }));
    if (imageFile) {
      formData.append('image', imageFile);
    }

    const token = localStorage.getItem('authToken') || '';
    const headers = new HttpHeaders({ 'Authorization': `Bearer ${token}` });

    return this.http.put(`${this.baseUrl}/update/${id}`, formData, { headers }).pipe(
      catchError(this.handleError)
    );
  }


  // Delete room
  deleteRoom(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any) {
    console.error('RoomService Error:', error);
    return throwError(() => error);
  }

}
