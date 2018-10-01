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
    // this.auth.login(credentials).subscribe(
    //   data => {
    //     console.log(data);
    //   }
    // )

    // .map(res => res.json())
       // .subscribe(
       //   response => this.auth.finishAuthentication(response.token),
       //   error => this.errorMessage = error.json().message
       // );
   }

   onSignupSubmit(credentials) {
  //   this.auth.signup(credentials)
  //     .map(res => res.json())
  //     .subscribe(
  //       response => this.auth.finishAuthentication(response.token),
  //       error => this.errorMessage = error.json().message
  //     );
   }

  // login() {
  //   this.loading = true;
  //
  //   this.authenticationService.login(this.model.username, this.model.password)
  //     .subscribe(
  //       result => {
  //         this.loading = false;
  //
  //         if (result) {
  //           this.userService.login(result);
  //           this.navigateAfterSuccess();
  //         } else {
  //           this.error = 'Username or password is incorrect';
  //         }
  //       },
  //       error => {
  //         this.error = 'Username or password is incorrect';
  //         this.loading = false;
  //       }
  //     );
  // }


}
