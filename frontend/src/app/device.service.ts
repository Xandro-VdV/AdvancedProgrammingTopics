import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Device, DevicePost } from './device';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  apiUrl = environment.apiURL + '/device';
  
  constructor(private http: HttpClient) { }

    // Helper function to create headers with Bearer token
    private getHeaders(token: string): HttpHeaders {
      return new HttpHeaders({
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',  // Specify content type as JSON
      });
    }

  getDevices() : Observable<Device[]> {
    return this.http.get<Device[]>(this.apiUrl);
  }

  addDevice(device: DevicePost, token: string): Observable<Device> {
    const headers = this.getHeaders(token);
    return this.http.post<Device>(this.apiUrl, device, { headers });
  }

  updateDevice(id: string, device: Device): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, device);
  }
  

  deleteDevice(id: string) : Observable<Device> {
    return this.http.delete<Device>(this.apiUrl + '/' + id);
  }
}
