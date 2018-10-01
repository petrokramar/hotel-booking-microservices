import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '@angular/common';
import {UsersService} from '../../../shared/services/users.service';
import {User} from '../../../model/entity/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  dataSource: User;
  isAdmin = false;
  isManager = true;
  isUser = false;
  isLoaded = false;

  constructor(
    private usersService: UsersService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    const username = this.route.snapshot.paramMap.get('username');
    this.getUser(username);
  }

  getUser(username: string): void {
    this.usersService.getUser(username).subscribe(
      (data: User) => {
        this.dataSource = data;
        this.dataSource.roles.forEach(role => {
          if (role.authority === 'ROLE_ADMIN') {
            this.isAdmin = true;
          } else if(role.authority === 'ROLE_MANAGER') {
            this.isManager = true;
          } else if(role.authority === 'ROLE_USER') {
            this.isUser = true;
          };
        });
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  onUserSubmit(): void {
    this.goBack();
  }

  goBack(): void {
    this.location.back();
  }
}
