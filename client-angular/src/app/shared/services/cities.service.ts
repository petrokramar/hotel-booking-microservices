import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { City } from '../../model/entity/city';
import {catchError} from 'rxjs/operators';
import {CityRequest} from '../../model/request/cityRequest';
import {CityListDTO} from '../../model/dto/cityListDTO';

@Injectable()
export class CitiesService {

  private url = '/api/cities';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })};

  constructor(private http: HttpClient) { }

  getAllCities(): Observable<City[]> {
    return this.http.get<City[]>(this.url);
  }

  findCities(filter: string, sortOrder: string, pageIndex: number, pageSize: number): Observable<CityListDTO> {
    return this.http.get<CityListDTO>(this.url, {
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

  getCity(id: number): Observable<City> {
    return this.http.get<City>(this.url + '/' + id)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  saveCity(city: CityRequest): Observable<City> {
    return this.http.post<City>(this.url, city, this.httpOptions)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }
}
