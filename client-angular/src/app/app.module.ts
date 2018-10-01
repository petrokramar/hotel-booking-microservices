import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {
  MatAutocompleteModule,
  MatButtonModule, MatCheckboxModule, MatDatepickerModule, MatInputModule, MatMenuModule, MatNativeDateModule, MatOptionModule,
  MatPaginatorModule, MatProgressSpinnerModule,
  MatSelectModule, MatSortModule, MatTableModule,
  MatTabsModule,
  MatToolbarModule
} from '@angular/material';
import { AppRoutingModule } from './app.router';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/common/header/header.component';
import { AlertModule, TabsModule } from 'ngx-bootstrap';
import { AuthenticationService } from './shared/services/authentication.service';
import { CountriesListComponent } from './components/countries/countries-list/countries-list.component';
import { CitiesListComponent } from './components/cities/cities-list/cities-list.component';
import { HotelsListComponent } from './components/hotels/hotels-list/hotels-list.component';
import {CountriesService} from './shared/services/countries.service';
import {CitiesService} from './shared/services/cities.service';
import {HotelsService} from './shared/services/hotels.service';
import { RoomsListComponent } from './components/rooms/rooms-list/rooms-list.component';
import {RoomCategoryService} from './shared/services/room-category.service';
import {RoomCategoriesListComponent} from './components/room-categories/room-categories-list/room-categories-list.component';
import {RoomService} from './shared/services/room.service';
import { BookingListComponent } from './components/booking/booking-list/booking-list.component';
import {BookingService} from './shared/services/booking.service';
import { CountryComponent } from './components/countries/country/country.component';
import {UsersListComponent} from './components/users/users-list/users-list.component';
import { CityComponent } from './components/cities/city/city.component';
import { HotelComponent } from './components/hotels/hotel/hotel.component';
import { RoomCategoryComponent } from './components/room-categories/room-category/room-category.component';
import { RoomComponent } from './components/rooms/room/room.component';
import {UsersService} from './shared/services/users.service';
import { UserComponent } from './components/users/user/user.component';
import { FindingRoomComponent } from './components/finding-room/finding-room.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    UsersListComponent,
    CountriesListComponent,
    CitiesListComponent,
    HotelsListComponent,
    RoomsListComponent,
    RoomCategoriesListComponent,
    BookingListComponent,
    CountryComponent,
    CityComponent,
    HotelComponent,
    RoomCategoryComponent,
    RoomComponent,
    UserComponent,
    FindingRoomComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatMenuModule,
    MatOptionModule,
    MatPaginatorModule,
    MatSelectModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatTabsModule,
    MatTableModule,
    MatToolbarModule,
    ReactiveFormsModule,
    TabsModule.forRoot(),
    AlertModule.forRoot()
  ],
  providers: [
    AuthenticationService,
    BookingService,
    CountriesService,
    CitiesService,
    HotelsService,
    RoomService,
    RoomCategoryService,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
