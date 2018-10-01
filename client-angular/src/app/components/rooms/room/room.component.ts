import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';
import {Room} from '../../../model/entity/room';
import {RoomCategory} from '../../../model/entity/roomCategory';
import {RoomService} from '../../../shared/services/room.service';
import {RoomCategoryService} from '../../../shared/services/room-category.service';
import {Hotel} from '../../../model/entity/hotel';
import {HotelsService} from '../../../shared/services/hotels.service';
import {RoomRequest} from '../../../model/request/roomRequest';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  dataSource: Room;
  hotels: Hotel[];
  hotelId: number;
  roomCategories: RoomCategory[];
  roomCategoryId: number;
  isLoaded = false;

  constructor(
    private roomService: RoomService,
    private hotelService: HotelsService,
    private roomCategoryService: RoomCategoryService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (id === 0) {
      this.dataSource = new Room();
      this.dataSource.id = 0;
      this.hotelId = id;
      this.roomCategoryId = id;
      this.getHotels();
    } else {
      this.getRoom(id);
    }
  }

  getRoom(id: number): void {
    this.roomService.getRoom(id).subscribe(
      (data: Room) => {
        this.dataSource = data;
        this.hotelId = this.dataSource.hotel.id;
        this.roomCategoryId = this.dataSource.roomCategory.id;
        this.getHotels();
      },
      (error: any) => {
        console.log(error);
      });
  }

  getHotels(): void {
    this.hotelService.getAllHotels().subscribe(
      (data: Hotel[]) => {
        this.hotels = data;
        this.getRoomCategories();
      },
      (error: any) => {
        console.log(error);
      });
  }

  getRoomCategories(): void {
    this.roomCategoryService.getAllRoomCategories().subscribe(
      (data: RoomCategory[]) => {
        this.roomCategories = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  onRoomSubmit(): void {
    const roomRequest = new RoomRequest();
    roomRequest.id = this.dataSource.id;
    roomRequest.number = this.dataSource.number;
    roomRequest.hotelId = this.hotelId;
    roomRequest.roomCategoryId = this.roomCategoryId;
    roomRequest.price = this.dataSource.price;
    roomRequest.persons = this.dataSource.persons;
    this.roomService.saveRoom(roomRequest).subscribe(
      () => {
        this.goBack()
      },
      (error: any) => {
        console.log(error);
      });
  }

  goBack(): void {
    this.location.back();
  }
}
