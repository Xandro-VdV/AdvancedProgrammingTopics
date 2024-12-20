import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { House } from './house';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  apiURL =  environment.apiURL + '/house';


  constructor(private http: HttpClient) { }

  getHouses() : Observable<House[]> {
    return this.http.get<House[]>(this.apiURL);
  }

}
