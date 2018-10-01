import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../../../model/entity/user';
import {UsersService} from '../../../shared/services/users.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  dataSource: User[];
  displayedColumns = ['username', 'firstName', 'lastName', 'enabled'];
  isLoaded = false;

  constructor(
    private usersService: UsersService,
    private router: Router
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    this.getAllUsers();
  }

  getAllUsers(): void {
    this.usersService.getAllUsers().subscribe(
      (data: User[]) => {
        this.dataSource = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoUser(username: string): void {
    this.router.navigate(['/users', username]);
  }
}
