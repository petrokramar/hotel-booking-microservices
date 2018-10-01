import { Component, OnInit } from '@angular/core';
import {Room} from '../../../model/entity/room';
import {RoomService} from '../../../shared/services/room.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css']
})
export class RoomsListComponent implements OnInit {

  dataSource: Room[];
  displayedColumns = ['hotel', 'city', 'country', 'number', 'roomCategory', 'price', 'persons'];
  isLoaded = false;

  constructor(
    private roomService: RoomService,
    private router: Router
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    this.getAllRooms();
  }

  getAllRooms(): void {
    this.roomService.getAllRooms().subscribe(
      (data: Room[]) => {
        this.dataSource = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoRoom(id: number): void {
    this.router.navigate(['/rooms', id]);
  }

  addRoom(): void {
    this.router.navigate(['/rooms', '0']);
  }

}
