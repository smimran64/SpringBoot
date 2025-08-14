import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { environments } from '../../environments/environments';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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


  getAllHotel(): Observable<Hotel[]> {
  return this.http.get<Hotel[]>(`${this.baseUrl}/all`).pipe(
    catchError(this.handleError)
  );
}


  // creatHotel(hotel: any, image: File): Observable<any> {

  //   const formData = new FormData();
  //   formData.append('hotel', new Blob([JSON.stringify(hotel)], { type: 'application/json' }));
  //   formData.append('image', image);

  //   return this.http.post<any>(this.baseUrl+'save',formData)
  //   .pipe(catchError(this.handleError));

  // }



  saveHotel(hotel: Hotel, imageFile?: File): Observable<any> {
    const formData = new FormData();
    formData.append('hotel', new Blob([JSON.stringify(hotel)], { type: 'application/json' }));

    if (imageFile) {
      formData.append('image', imageFile);
    }

    // Add JWT token from localStorage
    const token = localStorage.getItem('authToken');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    return this.http.post(`${this.baseUrl}/save/`, formData, { headers })
      .pipe(
        catchError(err => {
          console.error('Error saving hotel', err);
          return throwError(() => err);
        })
      );
  }


   updateHotel(id: number, hotel: Hotel, image?: File) {
      const formData = new FormData();
      formData.append('hotel', new Blob([JSON.stringify(hotel)], { type: 'application/json' }));
  
      // Append image only if provided (optional)
      if (image) {
        formData.append('image', image);
      }
  
      return this.http.put(this.baseUrl + `/update/${id}`, formData, {
        responseType: 'text' as 'json'
      });
    }


   deleteHotels(id: number) {
    return this.http.delete(this.baseUrl + `/delete/${id}`, {
      responseType: 'text' as 'json'
    });
  }






  private handleError(error: any) {

    console.error('An error occurred:', error);
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}
