import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';
import { Education } from '../model/education.model';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

   private apiUrl = environment.apiUrl + '/api/education/';

  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) { }

  addEducation(education: any): Observable<any> {

    let headers = new HttpHeaders();

    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('authToken');
      if (token) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      }
    }
    return this.http.post(this.apiUrl + "add", education, { headers });
  }


  getEducations(): Observable<Education[]> {
    let headers = new HttpHeaders();

    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('authToken');
      if (token) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      }
    }

    return this.http.get<Education[]>(this.apiUrl + 'all', { headers });
  }


  deleteEducation(id: number): Observable<void> {
 
    return this.http.delete<void>(this.apiUrl + id);
  }
  
}
