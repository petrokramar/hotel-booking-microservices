import { Component, OnInit } from '@angular/core';
import {User} from '../../model/entity/user';
import {AuthenticationService} from '../../shared/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage: string;

  constructor(private auth: AuthenticationService) { }

  ngOnInit(): void {
  }

  onLoginSubmit(credentials) {
    this.auth.login(credentials).subscribe(
    )

   // onSignupSubmit(credentials) {
  //   this.auth.signup(credentials)
  //     .map(res => res.json())
  //     .subscribe(
  //       response => this.auth.finishAuthentication(response.token),
  //       error => this.errorMessage = error.json().message
  //     );
   }
}
