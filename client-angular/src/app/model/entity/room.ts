import {Country} from './country';
import {City} from './city';
import {RoomCategory} from './roomCategory';
import {Hotel} from './hotel';

export class Room {
  id: number;
  number: number;
  hotel: Hotel;
  roomCategory: RoomCategory;
  price: number;
  persons: number;
}
