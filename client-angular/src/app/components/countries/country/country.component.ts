import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { Country} from '../../../model/entity/country';
import { CountriesService} from '../../../shared/services/countries.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {

  dataSource: Country;
  isLoaded = false;

  constructor(
    private countriesService: CountriesService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    const id = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (id === 0) {
      this.dataSource = new Country();
      this.dataSource.id = 0;
      this.isLoaded = true;
    } else {
        this.getCountry(id);
    }
  }

  getCountry(id: number): void {
    this.countriesService.getCountry(id).subscribe(
      (data: Country) => {
        this.dataSource = data;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  onCountrySubmit(): void {
    this.countriesService.saveCountry(this.dataSource).subscribe(
      () => {this.goBack()},
      (error: any) => {
        console.log(error);
      });
}

  goBack(): void {
    this.location.back();
  }
}
