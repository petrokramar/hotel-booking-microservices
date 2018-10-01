import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Hotel} from '../../../model/entity/hotel';
import {HotelsService} from '../../../shared/services/hotels.service';
import {Router} from '@angular/router';
import {fromEvent} from 'rxjs';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs/operators';
import {merge} from 'rxjs';
import {HotelListDTO} from '../../../model/dto/hotelListDTO';

@Component({
  selector: 'app-hotels-list',
  templateUrl: './hotels-list.component.html',
  styleUrls: ['./hotels-list.component.css']
})
export class HotelsListComponent implements OnInit, AfterViewInit {

  dataSource: MatTableDataSource<Hotel>;
  displayedColumns = ['hotel', 'city', 'country', 'category'];
  totalHotels: number;
  isLoaded = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild(MatSort) sort: MatSort;

  @ViewChild('input') input: ElementRef;

  constructor(
    private hotelsService: HotelsService,
    private router: Router) { }

  ngOnInit() {
    this.input.nativeElement.value = '';
    this.sort.direction = 'asc';
    this.paginator.pageIndex = 0;
    this.paginator.pageSize = 10;
    this.findHotels();
  }

  ngAfterViewInit() {

    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    fromEvent(this.input.nativeElement, 'keyup')
      .pipe(
        debounceTime(150),
        distinctUntilChanged(),
        tap(() => {
          this.paginator.pageIndex = 0;
          this.findHotels(
          );
        })
      )
      .subscribe();

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        tap(() => this.findHotels()
        ))
      .subscribe();

  }

  findHotels(): void {
    this.hotelsService.findHotels(
      this.input.nativeElement.value,
      this.sort.direction,
      this.paginator.pageIndex,
      this.paginator.pageSize).subscribe(
      (data: HotelListDTO) => {
        this.dataSource = new MatTableDataSource(data.hotels);
        this.totalHotels = data.totalElements;
        this.isLoaded = true;
      },
      (error: any) => {
        console.log(error);
      });
  }

  gotoHotel(id: number): void {
    this.router.navigate(['/hotels', id]);
  }

  addHotel(): void {
    this.router.navigate(['/hotels', '0']);
  }
}
