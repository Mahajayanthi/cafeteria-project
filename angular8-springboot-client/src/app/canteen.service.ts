import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CanteenService {

  //private baseUrl ='http://localhost:8080/springboot-crud-rest/api/v1/canteens';
 // private baseUrl ='http://localhost:8080/api/canteen';
  private baseUrl ='http://localhost:8080/api/v1/canteens';
  constructor(private http: HttpClient) { }

  getCanteen(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCanteen(canteen: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, canteen);
  }

  updateCanteen(id:number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteCanteen(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getCanteensList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}