import { Injectable } from '@angular/core';
import {catchError} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../../model/entity/user';

@Injectable()
export class UsersService {

  private url = '/api/users';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })};

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

  getUser(username: string): Observable<User> {
    return this.http.get<User>(this.url + '/' + username)
      .pipe(
        catchError((error: any) => {return Observable.throw(error); })
      );
  }

}
