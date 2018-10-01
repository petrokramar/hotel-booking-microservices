import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../../model/entity/country';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {CountryListDTO} from '../../model/dto/countryListDTO';

@Injectable()
export class CountriesService {

  private url = '/api/countries';
  private httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })};

  constructor(private http: HttpClient) { }

  getAllCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.url)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  findCountries(filter: string, sortOrder: string, pageIndex: number, pageSize: number): Observable<CountryListDTO> {
    return this.http.get<CountryListDTO>(this.url, {
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

  getCountry(id: number): Observable<Country> {
    return this.http.get<Country>(this.url + '/' + id)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
    );
  }

  saveCountry(country: Country): Observable<Country> {

    return this.http.post<Country>(this.url, country, this.httpOptions)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }
}
