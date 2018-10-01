import { Component, OnInit } from '@angular/core';
import {City} from '../../../model/entity/city';
import {ActivatedRoute, Router} from '@angular/router';
import {CitiesService} from '../../../shared/services/cities.service';
import {Location} from '@angular/common';
import {Hotel} from '../../../model/entity/hotel';
import {HotelsService} from '../../../shared/services/hotels.service';
import {HotelRequest} from '../../../model/request/hotelRequest';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  dataSource: Hotel;
  cities: City[];
  cityId: number;
  hotelCategories = ['ONE_STAR', 'TWO_STARS', 'THREE_STARS', 'FOUR_STARS', 'FIVE_STARS'];
  hotelCategory: string;
  isLoaded = false;

  constructor(
    private hotelsService: HotelsService,
    private citiesService: CitiesService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (id === 0) {
      this.dataSource = new Hotel();
      this.dataSource.id = 0;
      this.cityId = id;
      this.getCities();
      this.isLoaded = true;
    } else {
      this.getHotel(id);
      // this.hotelCategory = this.dataSource.category;
    }
  }

  getHotel(id: number): void {
    this.hotelsService.getHotel(id).subscribe(
      (data: Hotel) => {
        this.dataSource = data;
        this.cityId = this.dataSource.city.id;
        this.hotelCategory = this.dataSource.category;
        this.getCities();
        console.log(this.hotelCategory);
      },
      (error: any) => {
        console.log(error);
      });
  }

  getCities(): void {
    this.citiesService.getAllCities().subscribe(
      (data: City[]) => {
        this.cities = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  onHotelSubmit(): void {
    const hotelRequest = new HotelRequest();
    hotelRequest.id = this.dataSource.id;
    hotelRequest.name = this.dataSource.name;
    hotelRequest.cityId = this.cityId;
    hotelRequest.category = this.hotelCategory;
    this.hotelsService.saveHotel(hotelRequest).subscribe(
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
