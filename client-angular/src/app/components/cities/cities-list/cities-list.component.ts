import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { City } from '../../../model/entity/city';
import { CitiesService } from '../../../shared/services/cities.service';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {fromEvent} from 'rxjs';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs/operators';
import {merge} from 'rxjs';
import {CountryListDTO} from '../../../model/dto/countryListDTO';
import {CityListDTO} from '../../../model/dto/cityListDTO';

@Component({
  selector: 'app-cities-list',
  templateUrl: './cities-list.component.html',
  styleUrls: ['./cities-list.component.css']
})
export class CitiesListComponent implements OnInit, AfterViewInit {

  dataSource: MatTableDataSource<City>;
  displayedColumns = ['city', 'country'];
  totalCities: number;
  isLoaded = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild(MatSort) sort: MatSort;

  @ViewChild('input') input: ElementRef;

  constructor(
    private citiesService: CitiesService,
    private router: Router
  ) { }

  ngOnInit() {
    this.input.nativeElement.value = '';
    this.sort.direction = 'asc';
    this.paginator.pageIndex = 0;
    this.paginator.pageSize = 10;
    this.findCities();
  }

  ngAfterViewInit() {

    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    fromEvent(this.input.nativeElement, 'keyup')
      .pipe(
        debounceTime(150),
        distinctUntilChanged(),
        tap(() => {
          this.paginator.pageIndex = 0;
          this.findCities(
          );
        })
      )
      .subscribe();

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        tap(() => this.findCities()
        ))
      .subscribe();

  }

  findCities(): void {
    this.citiesService.findCities(
      this.input.nativeElement.value,
      this.sort.direction,
      this.paginator.pageIndex,
      this.paginator.pageSize).subscribe(
      (data: CityListDTO) => {
        this.dataSource = new MatTableDataSource(data.cities);
        this.totalCities = data.totalElements;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoCity(id: number): void {
    this.router.navigate(['/cities', id]);
  }

  addCity(): void {
    this.router.navigate(['/cities', '0']);
  }
}
