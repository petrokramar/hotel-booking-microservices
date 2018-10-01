import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  get isAdminUser() {
    // return this.userService.isAdminUser();
    return true;
  }

  get isUser() {
    // return this.userService.isUser();
    return true;
  }
}
