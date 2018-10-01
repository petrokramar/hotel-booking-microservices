import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RoomCategory} from '../../model/entity/roomCategory';
import {catchError} from 'rxjs/operators';
import {Country} from '../../model/entity/country';

@Injectable()
export class RoomCategoryService {

  private url = '/api/roomCategories';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })};

  constructor(private http: HttpClient) { }

  getAllRoomCategories(): Observable<RoomCategory[]> {
    return this.http.get<RoomCategory[]>(this.url);
  }

  getRoomCategory(id: number): Observable<RoomCategory> {
    return this.http.get<RoomCategory>(this.url + '/' + id)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  saveRoomCategory(roomCategory: RoomCategory): Observable<RoomCategory> {
    return this.http.post<RoomCategory>(this.url, roomCategory, this.httpOptions)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }
}
