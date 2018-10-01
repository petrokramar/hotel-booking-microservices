import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import {CountriesListComponent} from './components/countries/countries-list/countries-list.component';
import {CitiesListComponent} from './components/cities/cities-list/cities-list.component';
import {RoomCategoriesListComponent} from './components/room-categories/room-categories-list/room-categories-list.component';
import {RoomsListComponent} from './components/rooms/rooms-list/rooms-list.component';
import {BookingListComponent} from './components/booking/booking-list/booking-list.component';
import {CountryComponent} from './components/countries/country/country.component';
import {HotelsListComponent} from './components/hotels/hotels-list/hotels-list.component';
import {UsersListComponent} from './components/users/users-list/users-list.component';
import {CityComponent} from './components/cities/city/city.component';
import {HotelComponent} from './components/hotels/hotel/hotel.component';
import {RoomCategoryComponent} from './components/room-categories/room-category/room-category.component';
import {RoomComponent} from './components/rooms/room/room.component';
import {UserComponent} from './components/users/user/user.component';
import {FindingRoomComponent} from './components/finding-room/finding-room.component';

const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'booking',
        component: BookingListComponent
    },
    {
        path: 'cities',
        component: CitiesListComponent
    },
    {
        path: 'cities/:id',
        component: CityComponent
    },
    {
        path: 'countries/:id',
        component: CountryComponent
    },
    {
        path: 'countries',
        component: CountriesListComponent
    },
    {
        path: 'countries/:id',
        component: CountryComponent
    },
    {
        path: 'findingRoom',
        component: FindingRoomComponent
    },
    {
        path: 'hotels',
        component: HotelsListComponent
    },
    {
        path: 'hotels/:id',
        component: HotelComponent
    },
    {
        path: 'rooms',
        component: RoomsListComponent
     },
    {
        path: 'rooms/:id',
        component: RoomComponent
    },
    {
        path: 'roomCategories',
        component: RoomCategoriesListComponent
    },
    {
        path: 'roomCategories/:id',
        component: RoomCategoryComponent
    },
    {
        path: 'users',
        component: UsersListComponent
    },
    {
        path: 'users/:username',
        component: UserComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})

export class AppRoutingModule { }
