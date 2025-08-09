import { Injectable } from '@angular/core';
import { environments } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Location } from '../model/location.model';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private baseUrl = environments.apiUrl + '/api/location/';

  constructor(
    private http: HttpClient
  ) { }

  //creat location

  createLocation(location: Location, image: File) {
    const formData = new FormData();
    formData.append('location', new Blob([JSON.stringify(location)], { type: 'application/json' }));
    formData.append('image', image);

    return this.http.post(this.baseUrl + 'save', formData, {
      responseType: 'text' as 'json'
    });
  }




  getAllLocations() {
    return this.http.get(this.baseUrl);
  }

}
