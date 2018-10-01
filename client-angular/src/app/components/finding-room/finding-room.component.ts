import { Component, OnInit } from '@angular/core';
import {City} from '../../model/entity/city';
import {CitiesService} from '../../shared/services/cities.service';
import {FormControl} from '@angular/forms';
import {CityListDTO} from '../../model/dto/cityListDTO';
import {HotelsService} from '../../shared/services/hotels.service';
import {Hotel} from '../../model/entity/hotel';
import {HotelListDTO} from '../../model/dto/hotelListDTO';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-finding-room-list',
  templateUrl: './finding-room.component.html',
  styleUrls: ['./finding-room.component.css']
})
export class FindingRoomComponent implements OnInit {

  PAGE_INDEX = 0;
  PAGE_SIZE = 5;
  SORT_ORDER = 'asc';

  filteredCities: City[] = [];
  cityCtrl: FormControl;
  dataSource: MatTableDataSource<Hotel>;
  displayedColumns = ['hotel'];
  totalHotels: number;
  checkIn: Date = new Date();
  checkOut: Date = new Date();
  minCheckIn: Date = new Date();
  minCheckOut: Date = new Date();
  isLoaded = true;

  constructor(
    private citiesService: CitiesService,
    private hotelsService: HotelsService
  ) {
    this.cityCtrl = new FormControl();
    this.cityCtrl.valueChanges
      .subscribe(data => {
        this.findCities(data);
      })
  }

  ngOnInit() {
    this.setDate(this.minCheckIn, this.minCheckIn, 1);
    this.setDate(this.minCheckOut, this.minCheckIn, 1);
    this.setDate(this.checkIn, this.minCheckIn, 0);
    this.setDate(this.checkOut, this.minCheckOut, 0);
    console.log(this.minCheckIn);
    console.log(this.minCheckOut);
    console.log(this.checkIn);
    console.log(this.checkOut);
  }

  displayCity(city): string {
    return city ? city.name : city;
  }

  findCities(name: string): void {
    this.citiesService.findCities(name, this.SORT_ORDER, this.PAGE_INDEX, this.PAGE_SIZE).subscribe(
      (data: CityListDTO) => {
        this.filteredCities = data.cities;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  getHotelsWithFreeRooms(cityId: number, checkIn: Date, checkOut: Date): void {
    this.isLoaded = false;
    this.hotelsService.getHotelsWithFreeRooms(cityId, checkIn, checkOut, this.PAGE_INDEX, this.PAGE_SIZE).subscribe(
      (data: HotelListDTO) => {
        this.dataSource = new MatTableDataSource(data.hotels);
        this.totalHotels = data.totalElements;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  checkDates(): void {
    this.setDate(this.minCheckOut, this.checkIn, 1);
    if (this.checkIn >= this.checkOut) {
      this.checkOut = new Date();
      this.setDate(this.checkOut, this.minCheckOut, 0);
    };
  }

  setDate(targetDate: Date, baseDate: Date, addDays: number): void {
    targetDate.setFullYear(baseDate.getFullYear(), baseDate.getMonth(), baseDate.getDate() + addDays);
  };
}
