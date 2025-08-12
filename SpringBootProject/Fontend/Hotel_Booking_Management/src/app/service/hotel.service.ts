import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { environments } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Hotel } from '../model/hotel.model';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  baseUrl: string = environments.apiUrl + '/api/hotel';

  constructor(
    private http: HttpClient,
     @Inject(PLATFORM_ID) private platformId: Object
  ) { }


  getAllHotel(): Observable<any> {
    return this.http.get(this.baseUrl).pipe(

      catchError(this.handleError)
    );
  }

  creatHotel(hotel: Hotel, image: File): Observable<Hotel> {

    const formData = new FormData();
    formData.append('hotel', new Blob([JSON.stringify(hotel)], { type: 'application/json' }));
    formData.append('image', image);

    return this.http.post<Hotel>(this.baseUrl+'save',formData)
    .pipe(catchError(this.handleError));

  }


  private handleError(error: any) {

    console.error('An error occurred:', error);
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}
