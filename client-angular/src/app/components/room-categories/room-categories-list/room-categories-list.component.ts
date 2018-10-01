import { Component, OnInit } from '@angular/core';
import {RoomCategory} from '../../../model/entity/roomCategory';
import {RoomCategoryService} from '../../../shared/services/room-category.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-room-categories-list',
  templateUrl: './room-categories-list.component.html',
  styleUrls: ['./room-categories-list.component.css']
})
export class RoomCategoriesListComponent implements OnInit {

  dataSource: RoomCategory[];
  displayedColumns = ['name', 'description'];
  isLoaded = false;

  constructor(
    private roomCategoryService: RoomCategoryService,
    private router: Router
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    this.getAllRoomCategories();
  }

  getAllRoomCategories(): void {
    this.roomCategoryService.getAllRoomCategories().subscribe(
      (data: RoomCategory[]) => {
        this.dataSource = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoRoomCategory(id: string): void {
    this.router.navigate(['/roomCategories', id]);
  }

  addRoomCategory(): void {
    this.router.navigate(['/roomCategories', '0']);
  }

}
