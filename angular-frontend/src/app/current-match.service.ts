import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { StringDTO } from './string-dto'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrentMatchService {

  private baseURL = "http://localhost:8080/api/v1/loadCurrentMatch";

  constructor(private httpClient: HttpClient) { }  

  loadCurrentMatch(): Observable<StringDTO>{
    return this.httpClient.post<StringDTO>(`${this.baseURL}`, null);
  }
}
