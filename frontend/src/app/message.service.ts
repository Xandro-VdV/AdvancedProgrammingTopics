import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Message } from './message';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  apiUrl = environment.apiURL + '/message'; 

  getMessages() : Observable<Message[]> {
    return this.http.get<Message[]>(this.apiUrl);
  }

  addSponsor(message: Message) : Observable<Message> {
    return this.http.post<Message>(this.apiUrl, message);
  }
}
