import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Message, MessagePost } from './message';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  apiUrl = environment.apiURL + '/message'; 
  private getHeaders(token: string): HttpHeaders {
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',  // Specify content type as JSON
    });
  }
  getMessages() : Observable<Message[]> {
    return this.http.get<Message[]>(this.apiUrl);
  }

  sendMessage(message: MessagePost, token: string) : Observable<Message> {
    const headers = this.getHeaders(token);
    return this.http.post<Message>(this.apiUrl, message, { headers });
  }
}
