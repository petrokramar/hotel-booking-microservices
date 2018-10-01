import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Booking} from '../../model/entity/booking';

@Injectable()
export class BookingService {

  private url = '/api/booking';

  constructor(private http: HttpClient) { }

  getAllBooking(): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.url);
  }
}
