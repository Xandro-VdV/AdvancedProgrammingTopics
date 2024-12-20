import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Device } from './device';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  apiUrl = environment.apiURL + '/device';
  
  constructor(private http: HttpClient) { }

  getDevices() : Observable<Device[]> {
    return this.http.get<Device[]>(this.apiUrl);
  }

  addDevice(device: Device) : Observable<Device> {
    return this.http.post<Device>(this.apiUrl, device);
  }

  updateDevice(id: string, device: Device): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, device);
  }
  

  deleteDevice(id: string) : Observable<Device> {
    return this.http.delete<Device>(this.apiUrl + '/' + id);
  }
}
