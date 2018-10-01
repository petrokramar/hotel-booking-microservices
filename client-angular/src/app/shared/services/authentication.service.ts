import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class AuthenticationService {

  static AUTH_TOKEN = '/api/oauth/token';
  static TOKEN_AUTH_USERNAME = 'testjwtclientid';
  static TOKEN_AUTH_PASSWORD = 'XY7kmzoNzl100';
  constructor(private http: HttpClient, private router: Router) { }

  login(credentials): Observable<any> {
    const body = `username=${encodeURIComponent(credentials.username)}&password=${encodeURIComponent(credentials.password)}
      &grant_type=password`;
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers = headers.append('Authorization', 'Basic ' + btoa(AuthenticationService.TOKEN_AUTH_USERNAME + ':' + AuthenticationService.TOKEN_AUTH_PASSWORD));
    // console.log(credentials);
    // console.log(this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers}));
    // console.log('Basic ' + btoa(AuthenticationService.TOKEN_AUTH_USERNAME + ':' + AuthenticationService.TOKEN_AUTH_PASSWORD));
    console.log(body);
    console.log(headers);
    // console.log(headers.get('Authorization'));
    // let options = new RequestOptions({ headers: headers });
    // return this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers});
    return this.http.get('http://localhost:8080/booking');
      // .map(res => res.json())
      // .map((res: any) => {
      //   if (res.access_token) {
      //     return res.access_token;
      //   }
      //   return null;
      // });
    }


  // login(credentials): Observable<Response> {
  //   return this.http.post(`${API_URL}/users/authenticate`, credentials);
  // }
  //
  // signup(credentials): Observable<Response> {
  //   return this.http.post(`${API_URL}/users`, credentials);
  // }
  //
  // finishAuthentication(token): void {
  //   localStorage.setItem('token', token)
  //   this.router.navigate(['profile']);
  // }
  //
  // logout(): void {
  //   localStorage.removeItem('token');
  // }
  //
  // isAuthenticated(): boolean {
  //   return tokenNotExpired('token');
  // }
  //
  // isAdmin(): boolean {
  //   return jwtDecode(this.getToken()).scope === 'admin';
  // }
  //
  // getToken(): string {
  //   return localStorage.getItem('token');
  // }
  //
  // getUseRole(): string {
  //   return jwtDecode(this.getToken()).scope;
  // }

}

// static AUTH_TOKEN = 'http://localhost:8080/oauth/token';
// // static AUTH_TOKEN = '/oauth/token';
//
// constructor(private http: Http) {
// }
//
// login(username: string, password: string) {
//   const body = `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}&grant_type=password`;
//
//   const headers = new Headers();
//   headers.append('Content-Type', 'application/x-www-form-urlencoded');
//   headers.append('Authorization', 'Basic ' + btoa(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD));
//
//   //console.log(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD);
//   //console.log('Basic ' + btoa(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD));
//   // console.log(AuthenticationService.AUTH_TOKEN);
//   console.log(body);
//   console.log(headers);
//   // const res = this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers});
//   // console.log(res);
//
//   // localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
//
//   //console.log(this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers}).map(res => res.json()));
//
//   return this.http.post(AuthenticationService.AUTH_TOKEN, body, {headers})
//     .map(res => res.json())
//     .map((res: any) => {
//       if (res.access_token) {
//         return res.access_token;
//       }
//       return null;
//     });
// }
