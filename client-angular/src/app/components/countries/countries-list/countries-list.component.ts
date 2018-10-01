import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { CountriesService } from '../../../shared/services/countries.service';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {fromEvent} from 'rxjs';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs/operators';
import {merge} from 'rxjs';
import {Country} from '../../../model/entity/country';
import {CountryListDTO} from '../../../model/dto/countryListDTO';

@Component({
  selector: 'app-countries-list',
  templateUrl: './countries-list.component.html',
  styleUrls: ['./countries-list.component.css']
})
export class CountriesListComponent implements OnInit, AfterViewInit {

  dataSource: MatTableDataSource<Country>;
  displayedColumns = ['name'];
  totalCountries: number;
  isLoaded = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild(MatSort) sort: MatSort;

  @ViewChild('input') input: ElementRef;

  constructor(
    private countriesService: CountriesService,
    private router: Router
  ) { }

  ngOnInit() {
    this.isLoaded = false;
    this.input.nativeElement.value = '';
    this.sort.direction = 'asc';
    this.paginator.pageIndex = 0;
    this.paginator.pageSize = 10;
    this.findCountries();
  }

  ngAfterViewInit() {

    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    fromEvent(this.input.nativeElement, 'keyup')
      .pipe(
        debounceTime(150),
        distinctUntilChanged(),
        tap(() => {
          this.paginator.pageIndex = 0;
          this.findCountries(
            );
        })
      )
      .subscribe();

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        tap(() => this.findCountries()
      ))
      .subscribe();

  }

  findCountries(): void {
        this.countriesService.findCountries(
          this.input.nativeElement.value,
          this.sort.direction,
          this.paginator.pageIndex,
          this.paginator.pageSize).subscribe(
      (data: CountryListDTO) => {
        this.dataSource = new MatTableDataSource(data.countries);
        this.totalCountries = data.totalElements;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoCountry(id: string): void {
    this.router.navigate(['/countries', id]);
  }

  addCountry(): void {
    this.router.navigate(['/countries', '0']);
  }
}
