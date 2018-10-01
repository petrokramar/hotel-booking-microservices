import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomCategoryService} from '../../../shared/services/room-category.service';
import {RoomCategory} from '../../../model/entity/roomCategory';

@Component({
  selector: 'app-room-category',
  templateUrl: './room-category.component.html',
  styleUrls: ['./room-category.component.css']
})
export class RoomCategoryComponent implements OnInit {

  dataSource: RoomCategory;
  isLoaded = false;

  constructor(
    private roomCategoryService: RoomCategoryService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (id === 0) {
      this.dataSource = new RoomCategory();
      this.dataSource.id = 0;
      this.isLoaded = true;
    } else {
      this.getRoomCategory(id);
    }
  }

  getRoomCategory(id: number): void {
    this.roomCategoryService.getRoomCategory(id).subscribe(
      (data: RoomCategory) => {
        this.dataSource = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  onRoomCategorySubmit(): void {
    this.roomCategoryService.saveRoomCategory(this.dataSource).subscribe(
      () => {this.goBack()},
      (error: any) => {
        console.log(error);
      });
  }

  goBack(): void {
    this.location.back();
  }
}
