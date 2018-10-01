import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Hotel} from '../../model/entity/hotel';
import {catchError} from 'rxjs/operators';
import {HotelRequest} from '../../model/request/hotelRequest';
import {HotelListDTO} from '../../model/dto/hotelListDTO';

@Injectable()
export class HotelsService {

  private url = '/api/hotels';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })};

  constructor(private http: HttpClient) { }

  getAllHotels(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(this.url)
      .pipe(
      catchError((error: any) => {return Observable.throw(error); })
    );
  }

  findHotels(filter: string, sortOrder: string, pageIndex: number, pageSize: number): Observable<HotelListDTO> {
    return this.http.get<HotelListDTO>(this.url, {
      params: new HttpParams()
        .set('filter', filter)
        .set('sortOrder', sortOrder)
        .set('page', pageIndex.toString())
        .set('size', pageSize.toString())
    })
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  getHotelsWithFreeRooms(cityId: number, checkIn: Date, checkOut: Date, pageIndex: number, pageSize: number): Observable<HotelListDTO> {
    return this.http.get<HotelListDTO>(this.url, {
      params: new HttpParams()
        .set('cityId', cityId.toString())
        .set('checkIn', checkIn.toISOString().slice(0, 10))
        .set('checkOut', checkOut.toISOString().slice(0, 10))
        .set('page', pageIndex.toString())
        .set('size', pageSize.toString())
    })
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  getHotel(id: number): Observable<Hotel> {
    return this.http.get<Hotel>(this.url + '/' + id)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  saveHotel(hotel: HotelRequest): Observable<Hotel> {
    return this.http.post<Hotel>(this.url, hotel, this.httpOptions)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }
}
