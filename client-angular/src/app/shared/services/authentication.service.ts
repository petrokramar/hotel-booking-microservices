import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class AuthenticationService {

  static AUTH_TOKEN = 'http://localhost:9002/authserver/oauth/token';
  static TOKEN_AUTH_USERNAME = 'auth';
  static TOKEN_AUTH_PASSWORD = 'auth';

  private token = null;

  constructor(private http: HttpClient, private router: Router) { }

  login(credentials): Observable<{token: string}> {
    const body = `grant_type=password&username=${encodeURIComponent(credentials.username)}&password=${encodeURIComponent(credentials.password)}`;
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers = headers.append('Authorization',
      'Basic ' + btoa(AuthenticationService.TOKEN_AUTH_USERNAME + ':' + AuthenticationService.TOKEN_AUTH_PASSWORD));
    return this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers})
      .map((res: any) => {
         if (res.access_token) {
           localStorage.setItem('auth-token', res.access_token);
           this.setToken(res.access_token);
           return res.access_token;
         }
         return null;
       });
    }

  setToken(token: string) {
    this.token = token;
  }

  getToken(): string {
    return this.token
  }

  isAuthenticated(): boolean {
    return !!this.token
  }

  logout() {
    this.setToken(null)
    localStorage.removeItem('auth-token');
  }
}
